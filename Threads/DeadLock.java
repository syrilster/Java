package Threads;

import java.util.concurrent.TimeUnit;

/**
 * Created by Syril on 16-05-2016.
 */
public class DeadLock {

    /**
     * In this code, two threads operate over two shared resources r1 and r2. Resource class has 2 Synchronized methods
     * which will require the threads to obtain lock over the instance and unfortunately r1 has inter dependency on r2.
     */
    static class Resource {
        final String name;

        Resource(String name) {
            this.name = name;
        }

        synchronized void print() {
            System.out.println("This is the resource " + name);
        }

        synchronized void print(Resource anotherResource) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Thread " + Thread.currentThread().getName() + " acquired resource " + name);
            anotherResource.print();
        }
    }

    public static void main(String[] args){
        final Resource r1 = new Resource("r1");
        final Resource r2 = new Resource("r2");

        new Thread()
        {
            public void run() {
                r1.print(r2);
            }
        }.start();

        new Thread()
        {
            public void run() {
                r2.print(r1);
            }
        }.start();
    }
}
