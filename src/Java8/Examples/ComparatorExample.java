package Java8.Examples;

import Threads.JDKSorting.Comparable.Movie;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample {
    public static void main(String[] args) {
        System.out.println("Before Sort");
        List<Movie> moviesBeforeSort = getMovies();
        for (Movie movie : moviesBeforeSort) {
            System.out.println(movie.toString());
        }

        /*Collections.sort(moviesBeforeSort, new Comparator<Movie>() {
            @Override
            public int compare(Movie movieOne, Movie movieTwo) {
                return movieOne.getName().compareTo(movieTwo.getName());
            }
        });*/

        // Using lambda to sort by movie name and in reversed order
        moviesBeforeSort.sort(Comparator.comparing(Movie::getName).reversed());
        System.out.println("After sort by movie Name");
        moviesBeforeSort.forEach(System.out::println);

        Comparator<Movie> ratingComparator = Comparator.comparing(Movie::getRating);
        moviesBeforeSort.sort(ratingComparator.reversed());
        System.out.println("After sort by Movie rating");
        moviesBeforeSort.forEach(System.out::println);

    }

    private static List<Movie> getMovies() {
        List<Movie> movies = new ArrayList<>();
        Movie inception = new Movie(9.3, "Inception", 2009);
        Movie interstellar = new Movie(8.9, "Interstellar", 2016);
        Movie memento = new Movie(9.8, "Memento", 2009);
        Movie prestige = new Movie(8.6, "Prestige", 2004);

        movies.add(inception);
        movies.add(interstellar);
        movies.add(memento);
        movies.add(prestige);

        return movies;
    }
}
