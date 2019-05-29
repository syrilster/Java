package Threads.ProducerConsumer;

import java.util.Queue;

public class ConsumerWaitNotify implements Runnable {

    private final Queue sharedQueue;

    public ConsumerWaitNotify(Queue sharedQueue) {
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

    private void consume() {

        synchronized (sharedQueue) {
            while (sharedQueue.size() == 0) {
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
                Thread.sleep((long) (Math.random() * 2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Consumed Message " + sharedQueue.remove());
            sharedQueue.notify();
        }
    }
}