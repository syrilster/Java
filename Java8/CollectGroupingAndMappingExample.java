package Java8;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

/**
 * @author SSadasivan
 * @since 6/28/2017.
 */
public class CollectGroupingAndMappingExample {
	public static List<Person> createPerson() {
		return Arrays.asList(new Person("Syril", "Male", 29),
				new Person("Syril", "Male", 25),
				new Person("Anju", "Female", 27),
				new Person("Sandeep", "Male", 24));
	}

	public static void main(String[] args) {
		List<Person> people = createPerson();
		System.out.println("Create a Map with name and age as key and person as value");
		System.out.println(people.stream()
				.collect(toMap(person -> person.getName() + "-" + person.getAge(), person -> person)));
		System.out.println("Given a list of people, create a Map where key is the person name and value is all the people with the same name.");
		System.out.println(people.stream()
				.collect(groupingBy(Person::getName)));
		System.out.println("Create a Map with key as person name and value is all ages of the people with same name");
		System.out.println(people.stream()
				.collect(groupingBy(Person::getName, mapping(Person::getAge, toList()))));
	}
}
