package Java8;

import java.util.Arrays;
import java.util.List;

/**
 * @author SSadasivan
 * @since 6/23/2017.
 */
public class FunctionComposition {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		// To double the even numbers and total.
		System.out.println(numbers.stream()
				.filter(e -> e % 2 == 0)
				.map(e -> e * 2)
				.reduce(0, Integer::sum));
		System.out.println(numbers.stream()
				.filter(e -> e % 2 == 0)
				.mapToInt(e -> e * 2)
				.sum());
		//Using Parallel Streams
		System.out.println(numbers.parallelStream()
				.filter(e -> e % 2 == 0)
				.mapToInt(FunctionComposition::compute)
				.sum());
	}

	public static int compute(int number) {
		return number * 2;
	}
}
