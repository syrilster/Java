package Threads.CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        Thread threadOne = new Thread(new FileReader("Thread-1", "File-1", countDownLatch));
        Thread threadTwo = new Thread(new FileReader("Thread-2", "File-2", countDownLatch));
        Thread threadThree = new Thread(new FileReader("Thread-3", "File-3", countDownLatch));
        threadOne.start();
        threadTwo.start();
        threadThree.start();

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All files are read. Start further processing");
    }
}
