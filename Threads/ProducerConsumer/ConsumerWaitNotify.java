package Threads;

import java.util.Queue;

/**
 * Created by syrils on 3/23/16.
 */
public class ConsumerForWaitNotify implements Runnable {

    private Queue sharedQueue;

    ConsumerForWaitNotify(Queue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void consume() {

        synchronized (sharedQueue) {
            if (sharedQueue.size() == 0) {
                System.out.println("Shared Queue size is Zero. Waiting for producer to produce");
                try {
                    sharedQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        synchronized (sharedQueue) {
            try {
                Thread.sleep((long)(Math.random() * 2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Consumed Message " + sharedQueue.remove());
            sharedQueue.notify();
        }
    }
}
