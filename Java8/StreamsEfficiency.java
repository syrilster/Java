package Java8;

import java.util.Arrays;
import java.util.List;

/**
 1. Streams do lazy evaluation. All stream operations are pipelined until the terminal function is called. Like in the below 
    example findFirst().
 2. Streams does not work with the entire collection. Rather it slices across each element and applies the 
    pipeline of operations. Check execution stack trace.
 */
public class StreamsEfficiency {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
		System.out.println("Find double of first even number greater than 3 -------> Imperative");
		int result = 0;
		for (int number : numbers) {
			if (number > 3 && number % 2 == 0) {
				result = number * 2;
				break;
			}
		}
		System.out.println(result);
		System.out.println("Find double of first even number greater than 3 -------> Java 8 Way");
		System.out.println(numbers.stream()
				.filter(StreamsEfficiency::isGTThan3)
				.filter(StreamsEfficiency::isEven)
				.map(StreamsEfficiency::getDouble)
				.findFirst());
	}

	public static boolean isGTThan3(int number) {
		System.out.println("Inside GT3 method with parameter " + number);
		return number > 3;
	}

	public static boolean isEven(int number) {
		System.out.println("Inside isEven method with parameter " + number);
		return number % 2 == 0;
	}

	public static int getDouble(int number) {
		return number * 2;
	}
}
