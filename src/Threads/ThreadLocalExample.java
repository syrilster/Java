package Threads;

/**
 * Created by syrils on 3/30/16.
 */
public class ThreadLocalExample {

    static class MySharedRunnable implements Runnable {

        ThreadLocal<Integer> myThreadLocal = new ThreadLocal<>();

        @Override
        public void run() {
            myThreadLocal.set(Integer.valueOf((int) (Math.random() * 100)));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(myThreadLocal.get());
        }
    }

    public static void main(String args[]) throws InterruptedException {
        MySharedRunnable runnable = new MySharedRunnable();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}
