package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author SSadasivan
 * @since 6/23/2017.
 */
public class StreamsByExample {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		//Parameter :  stream<T> filter takes Predicate<T>
		numbers.stream()
				.filter(e -> e % 2 == 0);

		//Map Transform values. Number of input output = number of input
		//Parameter : Stream<T> map takes Function<T, R> to return Stream<R> i.e a transformation operation

		numbers.stream()
				.filter(e -> e % 2 == 0)
				.map(e -> e * 2.0) // Type going in is Integer but the Type Going out is a double
				.forEach(System.out::println);

		// Unlike Map and Filter, Reduce will consider all the input values and applies the operation to it.
		// But Map and Filter works differently i.e stick to their Swim lanes
		System.out.println("After reduce");
		System.out.println(numbers.stream()
				.filter(e -> e % 2 == 0)
				.map(e -> e * 2.0)
				.reduce(0.0, (carry, e) -> carry + e));

		//We can write the above as follows. Here sum() is the reduce operation
		System.out.println("After reduce using sum()");
		System.out.println(numbers.stream()
				.filter(e -> e % 2 == 0)
				.mapToDouble(e -> e * 2.0)
				.sum());

		List<Integer> duplicateNumbers = Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);
		//Double the even values and put in a list
		List<Integer> doubleOfEven = duplicateNumbers.stream()
				.filter(e -> e % 2 == 0)
				.map(e -> e * 2)
				.collect(Collectors.toList());
		printList(doubleOfEven);
	}

	public static void printList(List<Integer> numbers){
		for(Integer number : numbers){
			System.out.println(number);
		}
	}
}
