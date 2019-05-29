package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author SSadasivan
 * @since 6/22/2017.
 */
public class IterationExample {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		
		// This is a external iterator
		for (Integer number : numbers) {
			System.out.print(number + " ");
		}
		
		System.out.println("\nPrinting using internal Iterator to avoid user controls");
		numbers.forEach(new Consumer<Integer>() {
			@Override
			public void accept(Integer value) {
				System.out.print(value + " ");
			}
		});

		//Removed the noise using lambda
		numbers.forEach((Integer value) -> System.out.print(value + " "));

		//Java 8 has Type Inference.(Collection of numbers is already a Integer) But only for Lambda expressions.
		numbers.forEach((value) -> System.out.print(value + " "));

		//Parenthesis is optional, but for only one parameter lambda. If no parameter then (). Same is the case with 2 parameters
		numbers.forEach(value -> System.out.print(value + " "));

		//Replace lambda with a method reference
		numbers.forEach(System.out::println);
	}
}
