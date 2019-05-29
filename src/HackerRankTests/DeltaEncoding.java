package HackerRankTests;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import static com.sun.org.apache.xalan.internal.lib.ExsltStrings.split;

/**
 * @author SSadasivan
 * @since 7/12/2017.
 */
public class DeltaEncoding {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		int escapeToken = -128;
		final int MIN_DELTA = -127;
		final int MAX_DELTA = 127;
		StringTokenizer stringTokenizer = new StringTokenizer(line);
		List<Integer> numberList = new ArrayList<>();
		List<Integer> deltaList = new ArrayList<>();
		while (stringTokenizer.hasMoreElements()) {
			int number = Integer.valueOf(stringTokenizer.nextToken(" "));
			numberList.add(number);
		}
		deltaList.add(numberList.get(0));
		for (int i = 1; i < numberList.size(); i++) {
			int deltaDiff = numberList.get(i) - numberList.get(i - 1);
			if (deltaDiff < MIN_DELTA || deltaDiff > MAX_DELTA) {
				deltaList.add(escapeToken);
			}
			deltaList.add(deltaDiff);
		}
		StringBuilder result = new StringBuilder();
		for (int deltaNumber : deltaList) {
			result.append(deltaNumber).append(" ");
		}
		System.out.print(result);
	}
}
