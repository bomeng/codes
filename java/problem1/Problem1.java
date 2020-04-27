import java.io.*;
import java.util.*;

public class Problem1 {

    static String[] multiset_subset(String multiset) {
        String[] input = multiset.split(",");
        Set<List<String>> set = new HashSet<>();
        for(int i = 1; i < Math.pow(2, input.length); i++) {
            String s = Integer.toBinaryString(i);
            while (s.length() < input.length) {
                s = "0" + s;
            }
            List<String> list = new ArrayList<>();
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '1') {
                    list.add(input[j]);
                }
            }
            Collections.sort(list);
            set.add(list);
        }
        String[] result = new String[set.size()];
        int index = 0;
        for (List<String> item: set) {
            String s = "";
            for (String k: item) {
                s = s + k + ",";
            }
            s = s.substring(0, s.length() - 1);
            result[index] = s;
            index = index + 1;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {

        String[] res = multiset_subset("apple,apple,banana");

        for (String i : res) {
            System.out.println(i);
        }
    }
}