import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Foo2 {
    Semaphore c1 = new Semaphore(1);
    Semaphore c2 = new Semaphore(0);
    Semaphore c3 = new Semaphore(0);

    public void first() throws InterruptedException {
        c1.acquire();
        System.out.println("first");
        c2.release();
    }

    public void second() throws InterruptedException {
        c2.acquire();
        System.out.println("second");
        c3.release();
    }

    public void third() throws InterruptedException {
        c3.acquire();
        System.out.println("third");
        c1.release();
    }
}

public class PrintInOrder2 {
    public static void main(String[] args) throws Exception {
        Foo2 foo = new Foo2();

        ExecutorService service = Executors.newFixedThreadPool(3);


        Thread t1 = new Thread() {
            @Override
            public void run() {
                try {
                    foo.first();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                try {
                    foo.second();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t3 = new Thread() {
            @Override
            public void run() {
                try {
                    foo.third();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        for (int i = 0; i < 100; i++) {
            service.submit(t1);
            service.submit(t2);
            service.submit(t3);
        }

        service.shutdown();
    }
}
