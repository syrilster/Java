package Java8.FlatMap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class StreamSetFlatMap {
    public static void main(String[] args) {
        Student studentOne = new Student();
        studentOne.setName("Syril");
        studentOne.addBook("Effective Unit Testing");
        studentOne.addBook("AWS - Solutions Architect");
        studentOne.addBook("Data Science using Py");

        Student studentTwo = new Student();
        studentTwo.setName("Sandeep");
        studentTwo.addBook("Deep learning by example");
        studentTwo.addBook("AI for humans");

        List<Student> studentList = new ArrayList<>();
        studentList.add(studentOne);
        studentList.add(studentTwo);

        List<String> collect = studentList
                .stream()
                .map(Student::getBook)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        collect.forEach(System.out::println);

    }
}
