package Threads.RecursiveAction;

import java.util.concurrent.ForkJoinPool;

/**
 * @author ssadasivan
 * @since 3/5/2017.
 */
public class App {
	public static void main(String[] args) {
		ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		System.out.println("CPU's " + Runtime.getRuntime().availableProcessors());
		SimpleRecursiveAction simpleRecursiveAction = new SimpleRecursiveAction(120);
		pool.invoke(simpleRecursiveAction);
	}
}
