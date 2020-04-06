package HackerRankTests;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * We define the distance between two array values as the number of indices between the two values.
 * Given a, find the minimum distance between any pair of equal elements in the array. If no such value exists, print -1.
 * <p>
 * For example, if q=[3,2,1,2,3], there are two matching pairs of values: 3 and 2. The indices of the 2's are i=1 and , so their distance is . The indices of the 's are  and , so their distance is .
 */
public class MinimumDistances {

    // Complete the minimumDistances function below.
    static int minimumDistances(int[] a) {
        int minDist = Integer.MAX_VALUE;
        Map<Integer, Integer> distanceMap = new HashMap<>();
        for (int curIndex = 0; curIndex < a.length; curIndex++) {
            int elem = a[curIndex];
            if (distanceMap.get(elem) != null) {
                int prevIndex = distanceMap.get(elem);
                minDist = Math.min(minDist, (curIndex - prevIndex));
            } else {
                distanceMap.put(elem, curIndex);
            }
        }
        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int result = minimumDistances(a);
        System.out.println(result);

        scanner.close();
    }
}
