package Threads.WorkStealing.ManagedBlocking;

import java.util.concurrent.Phaser;

public class QueryThread implements Runnable {
    private String threadName;
    private int queryParam;
    private Phaser phaser;

    public QueryThread(String threadName, int queryParam, Phaser phaser) {
        this.threadName = threadName;
        this.queryParam = queryParam;
        this.phaser = phaser;
        phaser.register();
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("This is phase " + phaser.getPhase());
        System.out.println("Querying DB using param " + queryParam + " thread " + threadName);
        phaser.arriveAndAwaitAdvance();
    }
}
