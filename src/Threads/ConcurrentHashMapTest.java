package Threads;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentHashMapTest {
    private static Map<Integer, Integer> map = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 3; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 50; i++) {
                        testMethod(i);
                    }
                    System.out.println("Map size " + map.size());
                }
            });
        }

        //executorService.shutdown();
    }

    public static void testMethod(Integer integer) {
        Random random = new Random();
        Integer randomNum = random.nextInt(200 - 0 + 1) + 0;
        //synchronized (map) {
            while (map.containsKey(randomNum)) {
                randomNum = random.nextInt(200 - 0 + 1) + 0;
            }
            map.putIfAbsent(randomNum, integer);
        //}
    }
}
