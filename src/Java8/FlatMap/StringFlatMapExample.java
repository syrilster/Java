package Java8.FlatMap;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * How flatMap() works :
 *
 * { {1,2}, {3,4}, {5,6} } -> flatMap -> {1,2,3,4,5,6}
 *
 * { {'a','b'}, {'c','d'}, {'e','f'} } -> flatMap -> {'a','b','c','d','e','f'}
 */
public class StringFlatMapExample {
    public static void main(String[] args) {
        String[][] data = new String[][]{{"a", "b"}, {"d", "e", "c"}, {"g", "h"}};
        Stream<String[]> streamData = Arrays.stream(data);
        Stream<String> stringStream = streamData.flatMap(Arrays::stream);
        stringStream.forEach(System.out::println);
    }
}
