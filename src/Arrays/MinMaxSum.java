package Arrays;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/***
 * Sample Input
 *
 * 1 2 3 4 5
 * Sample Output
 *
 * 10 14
 * Explanation
 *
 * Our initial numbers are 1, 2, 3, 4, and 5. We can calculate the following sums using four of the five integers:
 *
 * If we sum everything except 1, our sum is 2 + 3 + 4 + 5 = 14.
 * If we sum everything except 2, our sum is 1 + 3 + 4 + 5 = 13.
 * If we sum everything except 3, our sum is 1 + 2 + 4 + 5 = 12.
 * If we sum everything except 4, our sum is 1 + 2 + 3 + 5 = 11.
 * If we sum everything except 5, our sum is 1 + 2 + 3 + 4 = 10.
 */
public class MinMaxSum {
    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
        long maxNum = -1;
        long minNum = Long.MAX_VALUE;
        long sum = 0;
        for (int i = 0; i < 5; i++) {
            int elem = arr[i];
            sum += elem;
            if (elem > maxNum) {
                maxNum = elem;
            }
            if (elem < minNum) {
                minNum = elem;
            }
        }
        System.out.println(sum - maxNum + " " + (sum - minNum));

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}
