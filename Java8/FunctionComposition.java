package Java8;

import java.util.Arrays;
import java.util.List;

/**
 * @author SSadasivan
 * @since 6/23/2017.
 */
public class FunctionComposition {
	// Functional Composition is a series of compositions. Like a pipeline.
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		/*
		Java 8 Stream API was introduced to implement internal iteration, that is better because java framework is 
		in control of the iteration. It provides several features such as sequential and parallel execution, 
		filtering based on the given criteria, mapping etc.
		*/
		// To double the even numbers and total.
		System.out.println(numbers.stream()
				.filter(e -> e % 2 == 0)
				.map(e -> e * 2)
				.reduce(0, Integer::sum));
		
		// The above can also be re-written as follows:
		System.out.println(numbers.stream()
				.filter(e -> e % 2 == 0)
				.mapToInt(e -> e * 2)
				.sum());
		
		/*
		  The above style of writing code is called as Function Composition or pipeline. i.e In the above example
		  take stream of data, send it to a filter then map it to integer and finally sum it all.
		*/
		
		//Using Parallel Streams. Which is faster than normal streams. Not good always and should be used with caution.
		// Parallel stream is going to use a lot of threads and resources to arrive at a result faster.
		System.out.println(numbers.parallelStream()
				.filter(e -> e % 2 == 0)
				.mapToInt(FunctionComposition::compute)
				.sum());
	}

	public static int compute(int number) {
		// Assume this is time intensive
		return number * 2;
	}
}
