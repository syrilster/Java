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

		/**Parameter as an argument. Note that println is not a static method but a instance method of System.out.
		The syntax is same for static method and instance method i.e. a double colon :: **/ 
		numbers.forEach(System.out::println);
		
		//Parameter as an argument to static method
		numbers.stream()
			//.map(e -> String.valueOf(e)) can be replaced as below
			.map(String::valueOf)
			.forEach(System.out::println);
		
		//Parameter as a target on which a function is being called
		numbers.stream()
			.map(e -> e.toString())
			.forEach(System.out::println);
		
		/*Two parameters coming in as argument
		  1st parameter - 0
		  2nd parameter - (total, e) sent to Integer.sum
		*/
		System.out.println(numbers.stream().reduce(0, (total, e) -> Integer.sum(total, e)));

		//Using Method Reference to replace the common parts.
		System.out.println(numbers.stream().reduce(0, Integer::sum));

		// Unlike the previous example the first parameter is target and second parameter is a argument
		System.out.println(numbers.stream()
				.map(e-> String.valueOf(e))
				.reduce("", (carry, str) -> carry.concat(str)));

		//Using Method Reference to replace the noise i.e carry and str
		System.out.println(numbers.stream()
					  .map(String::valueOf)
					  .reduce("", String::concat));
		
		/*Limitation of method references:
		  1. Cannot be used if there is any manipulation of data.
		  2. If there is a conflict between insatnce method and static method. i.e if the compiler finds two methods 
		     which are potential candidates then it will throw an error.		
		*/

	}
}
