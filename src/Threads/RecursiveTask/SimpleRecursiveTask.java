package Threads.RecursiveTask;

import java.util.concurrent.RecursiveTask;

/**
 * @author ssadasivan
 * @since 3/6/2017.
 */
public class SimpleRecursiveTask extends RecursiveTask<Integer> {
	private int workLoad;

	public SimpleRecursiveTask(int workLoad) {
		this.workLoad = workLoad;
	}

	@Override
	protected Integer compute() {
		if (workLoad > 100) {
			System.out.println("Parallel Execution started.. " + workLoad);
			SimpleRecursiveTask simpleRecursiveTask1 = new SimpleRecursiveTask(workLoad / 2);
			SimpleRecursiveTask simpleRecursiveTask2 = new SimpleRecursiveTask(workLoad / 2);

			simpleRecursiveTask1.fork();
			simpleRecursiveTask2.fork();

			int solution = 0;

			solution += simpleRecursiveTask1.join();
			solution += simpleRecursiveTask2.join();
			return solution;
		} else {
			System.out.println("No Need of parallel, sequential is OK  ");
			return workLoad * 2;
		}
	}
}
