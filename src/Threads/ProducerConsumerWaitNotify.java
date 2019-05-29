package Threads;

import Threads.ProducerConsumer.ConsumerWaitNotify;
import Threads.ProducerConsumer.ProducerForWaitNotify;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by syrils on 3/23/16.
 */
public class ProducerConsumerWaitNotify {

    public static void main(String[] args) {
        Queue sharedQueue = new LinkedList<>();
        ProducerForWaitNotify producer = new ProducerForWaitNotify(sharedQueue);
        ConsumerWaitNotify consumer = new ConsumerWaitNotify(sharedQueue);
        Thread producerThread = new Thread(producer , "Producer Thread");
        Thread consumerThread = new Thread(consumer , "Consumer Thread");
        producerThread.start();
        consumerThread.start();
    }
}
