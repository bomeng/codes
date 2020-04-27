class Foo1 {
    private Integer num = 1;
    private final Object o = new Object();

    public void first() {
        synchronized (o) {
            while (num != 1) {
                try {
                    o.wait();
                } catch (InterruptedException e) {
                }
            }
            System.out.println("first");
            num = 2;
            o.notifyAll();
        }
    }

    public void second() {
        synchronized (o) {
            while (num != 2) {
                try {
                    o.wait();
                } catch (InterruptedException e) {
                }
            }
            System.out.println("second");
            num = 3;
            o.notifyAll();
        }
    }

    public void third() {
        synchronized (o) {
            while (num != 3) {
                try {
                    o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("third");
            num = 1;
            o.notifyAll();
        }
    }
}

public class PrintInOrder1 {
    public static void main(String[] args) {
        Foo1 foo = new Foo1();


        for (int i = 0; i < 100; i++) {
            Thread t1 = new Thread() {
                @Override
                public void run() {
                    foo.first();
                }
            };

            Thread t2 = new Thread() {
                @Override
                public void run() {
                    foo.second();
                }
            };

            Thread t3 = new Thread() {
                @Override
                public void run() {
                    foo.third();
                }
            };
            t1.start();
            t2.start();
            t3.start();
        }
    }
}
