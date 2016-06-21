package Threads;

import java.util.Queue;

/**
 * Created by syrils on 3/23/16.
 */
public class ProducerForWaitNotify implements Runnable {
    private Queue sharedQueue;
    private int MAX_SIZE = 2;

    ProducerForWaitNotify(Queue q) {
        this.sharedQueue = q;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            produce(i);
        }
    }

    void produce(int i) {
        synchronized (sharedQueue) {
            if (sharedQueue.size() == MAX_SIZE)
                try {
                    System.out.println("Shared Queue size has reached the limit. Waiting for consumers to consume");
                    sharedQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }

        synchronized (sharedQueue) {
            System.out.println("Produced " + i);
            sharedQueue.add(i);
            try {
                Thread.sleep((long) (Math.random() * 1000));
                sharedQueue.notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
