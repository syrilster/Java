package Threads;

import java.util.LinkedList;

/**
 * Created by Syril on 20-04-2016.
 */
public class CustomThreadPool {
    private WorkThread[] threads;
    private LinkedList<Runnable> taskQueue;

    public CustomThreadPool(int threadNumber) {
        taskQueue = new LinkedList<>();
        threads = new WorkThread[threadNumber];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new WorkThread();
            threads[i].start();
        }
    }

    //This is the enqueue where new tasks are added and waiting threads are notified.
    public void execute(Runnable r) {
        synchronized (taskQueue) {
            taskQueue.add(r);
            taskQueue.notify();
        }
    }

    public class WorkThread extends Thread {

        @Override
        public void run() {
            Runnable r;
            while (true) {
                synchronized (taskQueue) {
                    while (taskQueue.isEmpty()) {
                        try {
                            taskQueue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    r = taskQueue.removeFirst();
                }

                try {
                    r.run();
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }

        }
    }
}
