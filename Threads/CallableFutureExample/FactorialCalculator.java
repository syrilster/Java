package Threads.CallableFutureExample;

import java.util.concurrent.Callable;

/**
 * @author SSadasivan
 * @since 6/20/2017.
 */
public class FactorialCalculator implements Callable<Integer> {
	private Integer number;

	public FactorialCalculator(Integer number) {
		this.number = number;
	}

	@Override
	public Integer call() throws Exception {
		int result = 1;
		if(number == 2)
			throw new IllegalArgumentException("Test");
		if (number == 0 || number == 1)
			return 1;
		else {
			for (int i = 2; i <= number; i++) {
				result *= i;
			}
		}
		return result;
	}
}
