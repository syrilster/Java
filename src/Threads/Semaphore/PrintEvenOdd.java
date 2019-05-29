package Threads.Semaphore;

import java.util.concurrent.Semaphore;

public class PrintEvenOdd {

    public static void main(String[] args) {
        SharedPrinter sharedPrinter = new SharedPrinter();
        Thread evenThread = new Thread(new EvenPrinter(sharedPrinter, 10), "Even Thread");
        Thread oddThread = new Thread(new OddPrinter(sharedPrinter, 10), "Odd Thread");
        evenThread.start();
        oddThread.start();
    }

    private static class SharedPrinter {

        private Semaphore evenSemaphore = new Semaphore(0);
        private Semaphore oddSemaphore = new Semaphore(1);

        private void printEvenNumber(int number) {
            try {
                evenSemaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " printing " + number);
            oddSemaphore.release();
        }

        private void printOddNumber(int number) {
            try {
                oddSemaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " printing " + number);
            evenSemaphore.release();
        }
    }

    private static class EvenPrinter implements Runnable {
        private SharedPrinter sharedPrinter;
        private int maxCount;

        EvenPrinter(SharedPrinter sharedPrinter, int maxCount) {
            this.sharedPrinter = sharedPrinter;
            this.maxCount = maxCount;
        }

        @Override
        public void run() {
            for (int i = 2; i <= maxCount; i = i + 2) {
                sharedPrinter.printEvenNumber(i);
            }
        }
    }

    private static class OddPrinter implements Runnable {
        private SharedPrinter sharedPrinter;
        private int maxCount;

        public OddPrinter(SharedPrinter sharedPrinter, int maxCount) {
            this.sharedPrinter = sharedPrinter;
            this.maxCount = maxCount;
        }

        @Override
        public void run() {
            for (int i = 1; i <= maxCount; i = i + 2) {
                sharedPrinter.printOddNumber(i);
            }
        }
    }
}
