package Threads.JDKSorting.Comparator;

import Threads.JDKSorting.Comparable.Movie;

import java.util.Comparator;

/**
 * @author SSadasivan
 * @since 6/20/2017.
 */
public class NameComparator implements Comparator<Movie> {
	@Override
	public int compare(Movie o1, Movie o2) {
		return o1.getName().compareTo(o2.getName());
	}
}
