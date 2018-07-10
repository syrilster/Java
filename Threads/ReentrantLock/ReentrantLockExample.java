package Threads.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * A simple counter example using Reentrant lock.
 */
public class ReentrantLockExample {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Thread threadOne = new Thread(new Counter("threadOne", lock));
        Thread threadTwo = new Thread(new Counter("threadTwo", lock));
        threadOne.start();
        threadTwo.start();
    }

    private static class SharedResource {
        private static int count = 0;
    }

    public static class Counter implements Runnable {
        private String threadName;
        private ReentrantLock lock;

        public Counter(String threadName, ReentrantLock lock) {
            this.threadName = threadName;
            this.lock = lock;
        }

        @Override
        public void run() {
            System.out.println("Thread " + threadName + " is entering the run method");
            lock.lock();
            System.out.println("Thread " + threadName + " acquired the lock");
            try {
                SharedResource.count++;
                System.out.println("Thread " + threadName + " updated the counter and value is " + SharedResource.count);
            } finally {
                System.out.println("Thread " + threadName + " is releasing the lock");
                lock.unlock();
            }
        }
    }
}
