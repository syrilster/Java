package DynamicProgramming;

import java.time.Duration;
import java.time.Instant;

/**
 * @author ssadasivan
 * @since 2/15/2017.
 */
class FibonacciDP {
	private static int[] lookUp;
	private static int max = 100;

	public static void main(String[] args) throws InterruptedException {
		int n = 40;
		lookUp = new int[max];
		initialize();
		//System.out.println(fibonacciUsingDP(n));
		System.out.println(fibonacciUsingRecursion(n));
	}

	private static void initialize() {
		for (int i = 0; i < max; i++) {
			lookUp[i] = -1;
		}
	}

	private static int fibonacciUsingDP(int n) {
		if (lookUp[n] == -1) {
			if (n <= 1)
				lookUp[n] = n;
			else
				lookUp[n] = fibonacciUsingDP(n - 1) + fibonacciUsingDP(n - 2);
		}
		return lookUp[n];
	}

	private static int fibonacciUsingRecursion(int n) {
		if (n <= 1)
			return n;
		else
			return fibonacciUsingDP(n - 1) + fibonacciUsingDP(n - 2);
	}
}
