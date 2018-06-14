package Threads;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by syrils on 3/23/16.
 */
public class ProducerConsumerWaitNotify {

    public static void main(String[] args) {
        Queue sharedQueue = new LinkedList<>();
        Threads.ProducerForWaitNotify producer = new Threads.ProducerForWaitNotify(sharedQueue);
        Threads.ConsumerForWaitNotify consumer = new Threads.ConsumerForWaitNotify(sharedQueue);
        Thread t = new Thread(producer , "Producer Thread");
        Thread thread = new Thread(consumer , "Consumer Thread");
        t.start();
        thread.start();
    }
}
