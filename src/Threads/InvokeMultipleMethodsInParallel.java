package Threads;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

/**
 * Created by Syril on 31-01-2018.
 */
public class InvokeMultipleMethodsInParallel {
    public static void main(String[] args) throws ExecutionException {
        long start = System.nanoTime();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Set<Callable<String>> callable = new HashSet<>();
        callable.add(new RequestResponse("connectApiOne"));
        callable.add(new RequestResponse("connectApiTwo"));
        callable.add(new RequestResponse("connectApiThree"));

        List<Future<String>> futureList;
        String resultString = "";
        try {
            futureList = executorService.invokeAll(callable);
            for (Future<String> future : futureList) {
                resultString = resultString + future.get() + "\n";
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
        System.out.println("Value is " + resultString);
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.print("Processed time\n" + duration);
    }

    private static String connectApiOne() {
        try {
            Thread.sleep(499);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Success_from_One";
    }

    private static String connectApiTwo() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Success_from_Two";
    }

    private static String connectApiThree() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Success_from_Three";
    }

    private static class RequestResponse implements Callable {
        String apiName;

        RequestResponse(String apiName) {
            this.apiName = apiName;
        }

        @Override
        public String call() {
            switch (apiName) {
                case "connectApiOne":
                    return InvokeMultipleMethodsInParallel.connectApiOne();
                case "connectApiTwo":
                    return InvokeMultipleMethodsInParallel.connectApiTwo();
                case "connectApiThree":
                    return InvokeMultipleMethodsInParallel.connectApiThree();
            }
            return null;
        }
    }
}
