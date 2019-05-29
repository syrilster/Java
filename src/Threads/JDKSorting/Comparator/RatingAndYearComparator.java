package Threads.JDKSorting.Comparator;

import Threads.JDKSorting.Comparable.Movie;

import java.util.Comparator;

/**
 * @author SSadasivan
 * @since 6/20/2017.
 */
public class RatingAndYearComparator implements Comparator<Movie> {
	@Override
	public int compare(Movie movieOne, Movie movieTwo) {
		int value = movieOne.getYear() - movieTwo.getYear();
		if (value == 0) {
			return (int) (movieOne.getRating() - movieTwo.getRating());
		}
		return value;
	}
}
