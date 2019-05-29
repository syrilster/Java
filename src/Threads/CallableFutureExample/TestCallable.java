package Threads.CallableFutureExample;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author SSadasivan
 * @since 6/20/2017.
 */
public class TestCallable {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		List<Future<Integer>> resultList = new ArrayList<>();
		Random random = new Random();
		for (int i = 0; i < 6; i++) {
			Integer number = random.nextInt(5);
			FactorialCalculator factorialCalculator = new FactorialCalculator(number);
			Future<Integer> result = executorService.submit(factorialCalculator);
			resultList.add(result);
		}
		for (Future<Integer> future : resultList) {
			try {
				System.out.println("Result is " + future.get() +"\n");
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
			executorService.shutdown();
		}
	}
}
