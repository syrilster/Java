package Arrays;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 * Sample Input
 *
 * 6
 * -4 3 -9 0 4 1
 * Sample Output
 *
 * 0.500000
 * 0.333333
 * 0.166667
 * Explanation
 *
 * There are  positive numbers,  negative numbers, and  zero in the array.
 * The proportions of occurrence are positive: 3/6=0.50000, negative: 2/6= 0.33333 and zeros: 1/6=0.166667
 */
public class PlusMinus {
    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        BigDecimal positiveCount = BigDecimal.ZERO;
        BigDecimal negativeCount = BigDecimal.ZERO;
        BigDecimal zeroCount = BigDecimal.ZERO;
        for (int value : arr) {
            if (value < 0) {
                negativeCount = negativeCount.add(BigDecimal.ONE);
            } else if (value > 0) {
                positiveCount = positiveCount.add(BigDecimal.ONE);
            } else {
                zeroCount = zeroCount.add(BigDecimal.ONE);
            }
        }
        System.out.println(positiveCount.divide(BigDecimal.valueOf(arr.length), 5, RoundingMode.HALF_UP));
        System.out.println(negativeCount.divide(BigDecimal.valueOf(arr.length), 5, RoundingMode.HALF_UP));
        System.out.println(zeroCount.divide(BigDecimal.valueOf(arr.length), 5, RoundingMode.HALF_UP));
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }
        plusMinus(arr);
        scanner.close();
    }
}
