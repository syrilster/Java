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
        Set<Callable<String>> callables = new HashSet<>();
        callables.add(new RequestResponse("connectApiOne"));
        callables.add(new RequestResponse("connectApiTwo"));
        callables.add(new RequestResponse("connectApiThree"));

        List<Future<String>> futures = null;
        String resultString = "";
        try {
            futures = executorService.invokeAll(callables);
            for (Future<String> future : futures) {
                resultString = resultString + future.get();
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
        return "SuccessFromOne";
    }

    private static String connectApiTwo() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "SuccessFromTwo";
    }

    private static String connectApiThree() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "SuccessFromThree";
    }

    private static class RequestResponse implements Callable {

        String apiName;

        public RequestResponse(String apiName) {
            this.apiName = apiName;
        }

        @Override
        public String call() throws Exception {
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
