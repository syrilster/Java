package Threads.Exchanger;

import java.util.concurrent.Exchanger;

/**
 * A producer consumer solution using Java Exchanger.
 * In this example there will be two threads, one thread will fill the buffer and
 * another thread will exchange that with an empty buffer.
 */
public class ExchangerDemo {
    public static void main(String[] args) {
        Exchanger<String> messageExchanger = new Exchanger<>();
        Thread threadOne = new Thread(new ProducerThread(messageExchanger));
        Thread threadTwo = new Thread(new ConsumerThread(messageExchanger));
        threadOne.start();
        threadTwo.start();
    }

    static class ProducerThread implements Runnable {
        private String message = "";
        private Exchanger<String> messageExchanger;

        public ProducerThread(Exchanger<String> messageExchanger) {
            this.messageExchanger = messageExchanger;
        }

        @Override
        public void run() {
            for (int i = 0; i <= 3; i++) {
                String message = "Producer " + i;
                try {
                    System.out.println("Producer is producing message: " + message);
                    messageExchanger.exchange(message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ConsumerThread implements Runnable {
        private String message;
        private Exchanger<String> messageExchanger;

        public ConsumerThread(Exchanger<String> messageExchanger) {
            this.messageExchanger = messageExchanger;
        }

        @Override
        public void run() {
            for (int i = 0; i <= 3; i++) {
                try {
                    message = messageExchanger.exchange("");
                    System.out.println("Consumer got the message: " + message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

