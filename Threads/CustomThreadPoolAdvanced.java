package Threads;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Refer https://github.com/SriramKeerthi/SimpleThreadpool/blob/master/threadpool/src/main/java/com/caffinc/threadpool/SimpleThreadpool.java
 */
public class CustomThreadPoolAdvanced {
    private AtomicBoolean execute;
    private LinkedList<Runnable> taskQueue;
    private PoolManager[] threads;

    public CustomThreadPoolAdvanced(int threadNumber) {
        taskQueue = new LinkedList<>();
        this.execute = new AtomicBoolean(true);
        threads = new PoolManager[threadNumber];
        for (int i = 1; i < threadNumber; i++) {
            threads[i] = new PoolManager(execute);
            threads[i].start();
        }
    }

    public void execute(Runnable r) {
        synchronized (taskQueue) {
            if (this.execute.get()) {
                taskQueue.add(r);
                taskQueue.notify();
            } else {
                throw new IllegalStateException("Threadpool terminating, unable to execute runnable");
            }

        }
    }

    /**
     * Clears the queue of runnables and stops the threadpool. Any runnables currently executing will continue to execute.
     */
    public void terminate() {
        taskQueue.clear();
        stop();
    }

    /**
     * Stops addition of new runnables to the threadpool and terminates the pool once all runnables in the queue are executed.
     */
    public void stop() {
        execute.set(false);
    }

    public class PoolManager extends Thread {
        private AtomicBoolean execute;

        public PoolManager(AtomicBoolean execute) {
            this.execute = execute;
        }

        @Override
        public void run() {
            Runnable runnable;
            // Continue to execute when the execute flag is true, or when there are runnables in the queue
            while (execute.get() || !taskQueue.isEmpty()) {
                synchronized (taskQueue) {
                    while (taskQueue.isEmpty()) {
                        try {
                            taskQueue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    runnable = taskQueue.removeFirst();
                }
                try {
                    runnable.run();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
