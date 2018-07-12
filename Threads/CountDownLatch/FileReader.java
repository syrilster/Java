package Threads.CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class FileReader implements Runnable {
    private String threadName;
    private String fileName;
    private CountDownLatch countDownLatch;

    public FileReader(String threadName, String fileName, CountDownLatch countDownLatch) {
        this.threadName = threadName;
        this.fileName = fileName;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("Thread " + threadName + " finished accessing file " + fileName);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDownLatch.countDown();
    }
}
