package Threads.RecursiveTask;

import Threads.RecursiveAction.SimpleRecursiveAction;

import java.math.BigDecimal;
import java.util.concurrent.ForkJoinPool;

/**
 * @author ssadasivan
 * @since 3/6/2017.
 */
public class App {
	public static void main(String[] args) {
		ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		System.out.println("CPU's " + Runtime.getRuntime().availableProcessors());
		SimpleRecursiveTask simpleRecursiveTask = new SimpleRecursiveTask(701);
		System.out.println(pool.invoke(simpleRecursiveTask));
	}
}
