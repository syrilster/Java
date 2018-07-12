package Threads.StampedLock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.StampedLock;

public class StampedLockCounter {
    int counter = 0;

    public static void main(String[] args) {
        StampedLock stampedLock = new StampedLock();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        StampedLockCounter stampedLockCounter = new StampedLockCounter();

        Runnable writeTask = () -> {
            long stamp = stampedLock.writeLock();
            try {
                stampedLockCounter.incrementCounter();
            } finally {
                stampedLock.unlockWrite(stamp);
            }
        };

        // Runnable as lambda - read
        Runnable readTask = () -> {
            long stamp = stampedLock.readLock();
            try {
                System.out.println("value of counter is " + stampedLockCounter.getCounterValue());

            } finally {
                stampedLock.unlockRead(stamp);
            }
        };

        executorService.submit(writeTask);
        executorService.submit(writeTask);
        executorService.submit(writeTask);

        executorService.submit(readTask);
        executorService.shutdownNow();
    }

    void incrementCounter() {
        counter++;
        System.out.println("Incremented value of counter");
    }

    int getCounterValue() {
        return counter;
    }
}

