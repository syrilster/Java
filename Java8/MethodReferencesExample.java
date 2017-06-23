package Java8;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Arrays;
import java.util.List;

/**
 * @author SSadasivan
 * @since 6/22/2017.
 */
public class MethodReferencesExample {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		System.out.println(numbers.stream()
							.reduce(0, (total, e) -> Integer.sum(total, e)));

		//Using Method Reference
		System.out.println(numbers.stream()
							.reduce(0, Integer::sum));

		System.out.println(numbers.stream()
				.map(e-> String.valueOf(e))
				.reduce("", (carry, str) -> carry.concat(str)));

		//Using Method Reference
		System.out.println(numbers.stream()
							.map(String::valueOf)
							.reduce("", String::concat));

	}
}
