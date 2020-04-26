import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class MutexTest {

    // max 1 people
    static ReentrantLock mutex = new ReentrantLock();

    static class MyLockerThread extends Thread {

        String name = "";

        MyLockerThread(String name) {
            this.name = name;
        }

        public void run() {

            try {

                System.out.println(name + " : acquiring lock...");
                System.out.println(name + " : Queue length: " + mutex.getQueueLength());

                mutex.lock();
                System.out.println(name + " : got the permit!");

                try {

                    for (int i = 1; i <= 5; i++) {

                        System.out.println(name + " : is performing operation " + i);

                        // sleep 1 second
                        Thread.sleep(1000);

                    }

                } finally {

                    // calling release() after a successful acquire()
                    System.out.println(name + " : releasing lock...");
                    mutex.unlock();
                    System.out.println(name + " : Queue length: " + mutex.getQueueLength());

                }

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

        }

    }

    public static void main(String[] args) {

        System.out.println("Total available Mutex permits : 1");

        ExecutorService executor = Executors.newCachedThreadPool();

        MyLockerThread t1 = new MyLockerThread("A");
//        t1.start();
//
        MyLockerThread t2 = new MyLockerThread("B");
//        t2.start();
//
        MyLockerThread t3 = new MyLockerThread("C");
//        t3.start();
//
        MyLockerThread t4 = new MyLockerThread("D");
//        t4.start();
//
        MyLockerThread t5 = new MyLockerThread("E");
//        t5.start();
//
        MyLockerThread t6 = new MyLockerThread("F");
//        t6.start();

        executor.submit(t1);
        executor.submit(t2);
        executor.submit(t3);
        executor.submit(t4);
        executor.submit(t5);
        executor.submit(t6);
        executor.shutdown();
    }
}
