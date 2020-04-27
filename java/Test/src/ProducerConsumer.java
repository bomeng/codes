import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        Queue<Integer> queue = new LinkedList<Integer>();
        ReentrantLock lock = new ReentrantLock();
        Condition con = lock.newCondition();
        final int size = 5;

        Thread p = new Producer(random, lock, con, queue, size);
        p.start();
        Thread c = new Consumer(random, lock, con, queue);
        c.start();

        Thread.sleep(1000);
        p.interrupt();
        p.join();
        c.interrupt();
        c.join();
    }
}

class Producer extends Thread {
    Random random;
    ReentrantLock lock;
    Condition con;
    Queue<Integer> queue;
    int size;

    public Producer(Random random, ReentrantLock lock, Condition con, Queue<Integer> queue, int size) {
        this.random = random;
        this.lock = lock;
        this.con = con;
        this.queue = queue;
        this.size = size;
    }


    public void run() {
        while (true) {
            lock.lock();
            while (queue.size() == size) {
                try {
                    con.await();
                } catch (InterruptedException ex) {
                    // Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
                    con.signal();
                    lock.unlock();
                    return;
                }
            }
            int value = random.nextInt(100);
            queue.add(value);
            System.out.println("Produced = " + value + ", queue size = " + queue.size());
            con.signal();
            lock.unlock();
        }
    }

}

class Consumer extends Thread {

    Random random;
    ReentrantLock lock;
    Condition con;
    Queue<Integer> queue;


    public Consumer(Random random, ReentrantLock lock, Condition con, Queue<Integer> queue) {
        this.random = random;
        this.lock = lock;
        this.con = con;
        this.queue = queue;
    }

    public void run() {
        while (true) {
            lock.lock();
            while (queue.size() < 1) {
                try {
                    con.await();
                } catch (InterruptedException ex) {
                    // Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
                    con.signal();
                    lock.unlock();
                    return;
                }
            }
            System.out.println("Consumed = " + queue.remove() + ", queue size = " + queue.size());
            con.signal();
            lock.unlock();
        }
    }
}
