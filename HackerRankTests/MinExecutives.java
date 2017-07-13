package HackerRankTests;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author SSadasivan
 * @since 7/12/2017.
 */
public class MinExecutives {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(new BufferedInputStream(System.in));
		int currentExecutives = Integer.parseInt(stdin.nextLine());
		int numberOfInput = Integer.valueOf(stdin.nextLine());
		long[] startTimes = new long[numberOfInput];
		long[] endTimes = new long[numberOfInput];
		for (int i = 0; i < numberOfInput; i++) {
			Long startTime = stdin.nextLong();
			Long endTime = stdin.nextLong();
			startTimes[i] = startTime;
			endTimes[i] = endTime;
		}
		// Sort start and end time arrays
		Arrays.sort(startTimes);
		Arrays.sort(endTimes);
		int execNeeded = findExecutivesNeedForCenter(startTimes, endTimes, startTimes.length);
		System.out.println(execNeeded > currentExecutives ? (execNeeded - currentExecutives) : execNeeded);
	}

	public static int findExecutivesNeedForCenter(long[] start, long[] end, int n) {
		int execNeeded = 0, maxExecNeeded = 0;
		int i = 0, j = 0;
		// Similar to merge in merge sort
		while (i < n && j < n) {
			if (start[i] < end[j]) {
				execNeeded++;
				i++;
				if (execNeeded > maxExecNeeded) {
					maxExecNeeded = execNeeded;
				}
			} else {
				execNeeded--;
				j++;
			}
		}
		return maxExecNeeded;
	}
}
