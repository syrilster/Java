package Threads.ReentrantReadWriteLock;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockDemo {
    private final Map<String, Integer> cache = new TreeMap<>();
    private final ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    private Integer get(String key) {
        Integer value;
        reentrantReadWriteLock.readLock().lock();
        try {
            System.out.println("Thread has acquired a read lock");
            value = cache.get(key);
        } finally {
            System.out.println("Thread is releasing the read lock");
            reentrantReadWriteLock.readLock().unlock();
        }
        return value;
    }

    private void put(String key, Integer value) {
        reentrantReadWriteLock.writeLock().lock();
        try {
            System.out.println("Thread has acquired a write lock");
            cache.put(key, value);
        } finally {
            System.out.println("Thread is releasing the write lock");
            reentrantReadWriteLock.writeLock().unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantReadWriteLockDemo reentrantReadWriteLockDemo = new ReentrantReadWriteLockDemo();
        reentrantReadWriteLockDemo.put("one", 1);
        reentrantReadWriteLockDemo.put("two", 2);
        reentrantReadWriteLockDemo.put("three", 3);
        reentrantReadWriteLockDemo.put("four", 5);

        Thread threadOne = new Thread(new ReaderThread(reentrantReadWriteLockDemo));
        Thread threadTwo = new Thread(new WriterThread(reentrantReadWriteLockDemo));
        Thread threadThree = new Thread(new ReaderThread(reentrantReadWriteLockDemo));

        threadOne.start();
        threadTwo.start();
        threadThree.start();

        try {
            threadOne.join();
            threadTwo.join();
            threadThree.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        reentrantReadWriteLockDemo.display();
    }

    private void display() {
        cache.entrySet().forEach(System.out::println);
    }

    static class WriterThread implements Runnable {
        private ReentrantReadWriteLockDemo reentrantReadWriteLockDemo;

        public WriterThread(ReentrantReadWriteLockDemo reentrantReadWriteLock) {
            this.reentrantReadWriteLockDemo = reentrantReadWriteLock;
        }

        @Override
        public void run() {
            System.out.println("Writer Thread is updating the cache value");
            reentrantReadWriteLockDemo.put("four", 5);
        }
    }

    static class ReaderThread implements Runnable {
        private ReentrantReadWriteLockDemo reentrantReadWriteLockDemo;

        public ReaderThread(ReentrantReadWriteLockDemo reentrantReadWriteLock) {
            this.reentrantReadWriteLockDemo = reentrantReadWriteLock;
        }

        @Override
        public void run() {
            System.out.println("Reader Thread is fetching the value from cache ");
            System.out.println("Reader Thread is getting value from cache " + reentrantReadWriteLockDemo.get("four"));
        }
    }
}
