package Threads.JDKSorting.Comparable;

import Threads.JDKSorting.Comparator.NameComparator;
import Threads.JDKSorting.Comparator.RatingAndYearComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author SSadasivan
 * @since 6/20/2017.
 */
public class TestApp {
	public static void main(String[] args) {
		List<Movie> movies = new ArrayList<>();
		Movie inception = new Movie(9.3, "Inception", 2009);
		Movie interstellar = new Movie(8.9, "Interstellar", 2016);
		Movie memento = new Movie(9.8, "Memento", 2009);
		Movie prestige = new Movie(8.6, "Prestige", 2004);

		movies.add(inception);
		movies.add(interstellar);
		movies.add(memento);
		movies.add(prestige);

		Collections.sort(movies);
		System.out.println("Movies sorted by year \n");
		print(movies);

		Collections.sort(movies, new RatingAndYearComparator());
		System.out.println("Movies sorted by year and rating \n");
		print(movies);

		System.out.println("Movies sorted by Name\n");
		Collections.sort(movies, new NameComparator());
		print(movies);
	}

	static void print(List<Movie> movies){
		for (Movie movie : movies) {
			System.out.println(movie.getName() + " " + movie.getRating() + " " + movie.getYear() + "\n");
		}
	}
}
