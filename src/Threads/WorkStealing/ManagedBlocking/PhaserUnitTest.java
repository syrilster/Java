package Threads.WorkStealing.ManagedBlocking;

import java.util.concurrent.Phaser;

/**
 * first phase - we have three threads reading 3 different files, parsing and storing them in DB.
 * second phase - 2 threads start to query the DB table on the inserted records.
 * Let's assume that one of the field is age in the DB table and we want to query count of those having
 * age greater than 40 using one thread and
 * in another thread we want to get the count of those having age less than or equal to 40.
 */
public class PhaserUnitTest {

    public static void main(String[] args) {
        Phaser phaser = new Phaser(1);
        new FileReaderThread("Thread-1", phaser, "File-1");
        new FileReaderThread("Thread-2", phaser, "File-2");
        new FileReaderThread("Thread-3", phaser, "File-3");
        int currentPhase;
        currentPhase = phaser.getPhase();
        // This is for the main thread
        phaser.arriveAndDeregister();
        System.out.println("Phase " + currentPhase + " has completed");

        currentPhase = phaser.getPhase();
        System.out.println("parties --> " + phaser.getRegisteredParties());
        phaser.arriveAndAwaitAdvance();

        System.out.println("Phase " + currentPhase + " has completed");

        // Threads for third phase
        new QueryThread("thread-1", 40, phaser);
        new QueryThread("thread-2", 40, phaser);
        currentPhase = phaser.getPhase();
        System.out.println("parties registered --> " + phaser.getRegisteredParties());
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase " + currentPhase + " completed");
        // de registering the main thread
        phaser.arriveAndDeregister();

        /*
        Here it can be seen that first a Phaser instance ph is created with initial party count as 1,
        which corresponds to the main thread.
        Then in the first set of 3 threads which are used in the first phase phaser object is also passed which is
        used for synchronization.
        Then in the second phase the set of three threads used in the first phase are deregistered.
        In the third phase another set of two threads are created which used the same phaser object for synchronization.
         */
    }

}
