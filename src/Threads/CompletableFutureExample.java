package Threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * https://www.callicoder.com/java-8-completablefuture-tutorial/
 * https://stackoverflow.com/questions/33649902/execute-multiple-queries-in-parallel-via-streams
 * https://stackoverflow.com/questions/42504277/java-8-call-methods-async-in-parallel-and-combine-their-results
 * http://fahdshariff.blogspot.in/2016/06/java-8-completablefuture-vs-parallel.html
 */
public class CompletableFutureExample {
    public static void main(String[] args) {
        long start = System.nanoTime();
        CompletableFuture<String> callOne = CompletableFuture.supplyAsync(CompletableFutureExample::connectApiOne);
        CompletableFuture<String> callTwo = CompletableFuture.supplyAsync(CompletableFutureExample::connectApiTwo);
        CompletableFuture<String> callThree = CompletableFuture.supplyAsync(CompletableFutureExample::connectApiThree);
        CompletableFuture<String> result = CompletableFuture.allOf(callOne, callTwo, callThree).
                thenApplyAsync(test -> convert(callOne.join(), callTwo.join(), callThree.join()));

        invokeInParallel(result);
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Processed time --> " + duration);

        start = System.nanoTime();
        invokeInSequence();
        duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Processed time --> " + duration);
    }

    private static void invokeInSequence() {
        System.out.print("Invoking the methods sequentially");
        String s1 = connectApiOne();
        String s2 = connectApiTwo();
        String s3 = connectApiThree();
        System.out.println("\n" + convert(s1, s2, s3));
    }

    private static void invokeInParallel(CompletableFuture<String> result) {
        System.out.println("Invoking the methods in parallel using Completable Future");
        try {
            System.out.println(result.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static String convert(String s1, String s2, String s3) {
        return s1 + " " + s2 + " " + s3;
    }

    public static String connectApiOne() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "SuccessFromOne";
    }

    public static String connectApiTwo() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "SuccessFromTwo";
    }

    public static String connectApiThree() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "SuccessFromThree";
    }
}
