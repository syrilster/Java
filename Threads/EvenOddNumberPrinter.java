package Threads;

/**
 * Created by Syril on 08-04-2016.
 */
 
public class EvenOddNumberPrinter {

    public static class Printer {
        boolean isEvenPrinted = true;

        public void printOdd(int number) throws InterruptedException {
            synchronized (this) {
                if (!isEvenPrinted)
                    wait();

                System.out.println(Thread.currentThread().getName() + " Printing " + number);
                isEvenPrinted = false;
                notify();
            }
        }

        public void printEven(int number) throws InterruptedException {
            synchronized (this) {
                if (isEvenPrinted)
                    wait();

                System.out.println(Thread.currentThread().getName() + " Printing " + number);
                isEvenPrinted = true;
                notify();
            }
        }
    }

    public static class EvenNumberPrinter implements Runnable {
        Printer printer;
        int maxNumber;

        EvenNumberPrinter(Printer printer, int maxNumber) {
            this.printer = printer;
            this.maxNumber = maxNumber;
        }

        @Override
        public void run() {
            for (int i = 2; i <= maxNumber; i = i + 2) {
                try {
                    printer.printEven(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class OddNumberPrinter implements Runnable {
        Printer printer;
        int maxNumber;

        OddNumberPrinter(Printer printer, int maxNumber) {
            this.printer = printer;
            this.maxNumber = maxNumber;
        }

        @Override
        public void run() {
            for (int i = 1; i <= maxNumber; i = i + 2) {
                try {
                    printer.printOdd(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Printer printer = new Printer();
        int maxNumber = 100;

        new Thread(new EvenNumberPrinter(printer, maxNumber), "Even Thread").start();
        new Thread(new OddNumberPrinter(printer, maxNumber), "Odd Thread").start();
    }
}
