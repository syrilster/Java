package Threads.WorkStealing.ManagedBlocking;

import java.util.concurrent.Phaser;

public class FileReaderThread implements Runnable {
    private String threadName;
    private Phaser phaser;
    private String fileName;

    public FileReaderThread(String threadName, Phaser phaser, String fileName) {
        this.threadName = threadName;
        this.phaser = phaser;
        this.fileName = fileName;
        phaser.register();
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("This is phase " + phaser.getPhase() + " having registered parties " + phaser.getRegisteredParties());
        System.out.println("Thread " + threadName + " is trying the access file " + fileName);

        //Arrives at this phaser and awaits others(so that all threads wait here)
        phaser.arriveAndAwaitAdvance();
        try {
            //Adding a delay here. This is not required
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("De registered from phaser " + threadName);
        phaser.arriveAndDeregister();
    }
}
