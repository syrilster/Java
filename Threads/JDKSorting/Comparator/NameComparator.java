package Threads.JDKSorting.Comparator;

import Threads.JDKSorting.Comparable.Movie;

import java.util.Comparator;

/**
 * @author SSadasivan
 * @since 6/20/2017.
 */
public class NameComparator implements Comparator<Movie> {
	@Override
	public int compare(Movie movieOne, Movie movieTwo) {
		return movieOne.getName().compareTo(movieTwo.getName());
	}
}
