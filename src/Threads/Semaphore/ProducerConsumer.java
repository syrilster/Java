package Threads.Semaphore;

import java.util.concurrent.Semaphore;

public class ProducerConsumer {

    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        Thread producer = new Thread(new Producer(resource), "Producer");
        Thread consumer = new Thread(new Consumer(resource), "Consumer");
        producer.start();
        consumer.start();
    }

    private static class SharedResource {
        private int counter;
        private Semaphore producerSemaphore = new Semaphore(0);
        private Semaphore consumerSemaphore = new Semaphore(1);

        private void get() {
            try {
                consumerSemaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Got the value --> " + counter);

            producerSemaphore.release();
        }

        private void put(int conterValue) {
            try {
                producerSemaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.counter = conterValue;
            System.out.println("Produced value --> " + conterValue);
            consumerSemaphore.release();
        }
    }

    private static class Producer implements Runnable {
        private SharedResource resource;

        public Producer(SharedResource resource) {
            this.resource = resource;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                resource.put(i);
            }
        }
    }

    private static class Consumer implements Runnable {
        private SharedResource resource;

        public Consumer(SharedResource resource) {
            this.resource = resource;
        }

        @Override
        public void run() {
            for (int i = 0; i <= 5; i++) {
                resource.get();
            }
        }
    }
}
