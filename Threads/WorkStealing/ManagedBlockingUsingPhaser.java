package Threads.WorkStealing;

import java.util.concurrent.Phaser;

public class ManagedBlockingUsingPhaser implements Runnable {
    private String threadName;
    private Phaser phaser;

    public ManagedBlockingUsingPhaser(String threadName, Phaser phaser) {
        this.threadName = threadName;
        this.phaser = phaser;
        phaser.register();
    }

    @Override
    public void run() {
        System.out.println("Before arrive and await of thread " + threadName);
        phaser.arriveAndAwaitAdvance();
        try {
            System.out.println("Trying to simulate some work !!! ");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        phaser.arriveAndDeregister();
        System.out.println("After de registration of thread " + threadName);
    }
}



