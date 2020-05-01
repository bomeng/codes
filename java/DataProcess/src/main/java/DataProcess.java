import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;

public class DataProcess {
    private static final String BASE_FOLDER = "/tmp/";
    private static final int SPLIT_FILES = 10;

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        DataProcess process = new DataProcess();
        process.step0();
        process.step1();
        process.step2(n);
        process.step3();
    }

    /**
     * delete the dir and and its sub dir
     */
    private void deleteDirectory(File directoryToBeDeleted) {
        File[] allContents = directoryToBeDeleted.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                deleteDirectory(file);
            }
        }
        directoryToBeDeleted.delete();
    }

    /**
     * delete the existing temp folder and recreate them
     */
    public void step0() {
        System.out.println("step 0 started ...");
        File step1Dir = new File(BASE_FOLDER + "step1");
        deleteDirectory(step1Dir);
        step1Dir.mkdirs();

        File step2Dir = new File(BASE_FOLDER + "step2");
        deleteDirectory(step2Dir);
        step2Dir.mkdirs();

        File step3Dir = new File(BASE_FOLDER + "step3");
        deleteDirectory(step3Dir);
        step3Dir.mkdirs();
    }

    /**
     * split the big file into small files in order to fit into memory
     */
    public void step1() {
        System.out.println("step 1 started ...");
        try {
            File f = new File(BASE_FOLDER + "access.log");
            FileInputStream inputStream = new FileInputStream(f);
            Scanner scanner = new Scanner(inputStream, "UTF-8");

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] items = line.split(",");

                // String timestamp = items[0];
                int user = Integer.parseInt(items[1]);
                String url = items[2].substring(6);

                int id = user % SPLIT_FILES;

                String outputFileName = BASE_FOLDER + "step1/" + id;
                FileOutputStream fos = new FileOutputStream(outputFileName, true);
                fos.write((user + "\r\n").getBytes());
                fos.write((url + "\r\n").getBytes());
                fos.close();
            }

            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * For each small file, find the user that has great or equal to n unique urls
     */
    public void step2(int n) {
        System.out.println("step 2 started ...");
        try {
            Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
            for (int i = 0; i <= SPLIT_FILES - 1; i++) {
                map.clear();
                File f = new File(BASE_FOLDER + "step1/" + i);
                FileInputStream inputStream = new FileInputStream(f);
                Scanner scanner = new Scanner(inputStream, "UTF-8");

                while (scanner.hasNextLine()) {
                    int user = Integer.parseInt(scanner.nextLine());
                    int url = Integer.parseInt(scanner.nextLine());

                    Set<Integer> set = map.getOrDefault(user, new HashSet<Integer>());
                    set.add(url);
                    map.put(user, set);
                }
                scanner.close();

                // write out
                String outputFileName = BASE_FOLDER + "step2/" + i;
                FileOutputStream fos = new FileOutputStream(outputFileName, true);
                for (int user : map.keySet()) {
                    Set<Integer> set = map.get(user);
                    if (set.size() < n) {
                        continue;
                    }
                    fos.write((user + "\r\n").getBytes());
                }
                fos.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * get the final result by visiting each small files and put into one file
     */
    public void step3() {
        System.out.println("step 3 started ...");
        try {
            Map<Integer, Set<Integer>> map = new HashMap<>();
            File dir = new File(BASE_FOLDER + "step2/");

            // write out
            String outputFileName = BASE_FOLDER + "step3/result";
            FileOutputStream fos = new FileOutputStream(outputFileName, true);

            for (int i = 0; i <= SPLIT_FILES - 1; i++) {
                File f = new File(BASE_FOLDER + "step2/" + i);
                FileInputStream inputStream = new FileInputStream(f);
                Scanner scanner = new Scanner(inputStream, "UTF-8");
                while (scanner.hasNextLine()) {
                    String user = scanner.nextLine();
                    if (user != null && user.length() > 0) {
                        fos.write((user + "\r\n").getBytes());
                    }
                }
                scanner.close();
            }
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
