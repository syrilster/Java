package Java8.Examples;

import java.util.Arrays;
import java.util.List;

public class TaskOne {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("John", "", "Marry", "Jim", "", "", "Andrew");
        strings.stream()
                .filter(e -> !e.isEmpty())
                .forEach(System.out::println);

    }
}
