package Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ssadasivan on 01-02-2017.
 */
public class SimpleThreadPool {

    public static void main(String[] args) {
        /*ExecutorService executorService = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 10; i++) {
            Runnable worker = new WorkerThread("" + i);
            executorService.execute(worker);
        }
        executorService.shutdown();
        while (!executorService.isTerminated()) {
        }
        System.out.println("Finished all threads");*/

        CustomThreadPool customThreadPool = new CustomThreadPool(5);
        for (int i = 0; i < 10; i++) {
            Runnable worker = new WorkerThread("" + i);
            customThreadPool.execute(worker);
        }
    }

    private static class WorkerThread implements Runnable {
        String i;

        public WorkerThread(String s) {
            this.i = s;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
