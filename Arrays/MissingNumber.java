package Arrays;

import java.util.stream.IntStream;

/**
 * Algorithm:
 * 1. Get the sum of all the numbers
 * 2. Apply formula total = n*(n+1)/2
 * 3. Subtract the total from sum and you will get the missing number.
 */
public class MissingNumber {

    public static void main(String[] args) {
        int[] inputArray = {1, 2, 4, 6, 3, 7, 5};
        System.out.println("Missing number : " + findMissingNumber(inputArray));
    }

    private static int findMissingNumber(int[] arr) {
        int total = calculateTotal(arr.length + 1);
        int sum = calculateSum(arr);
        return Math.abs(total - sum);
    }

    private static int calculateSum(int[] arr) {
        return IntStream.of(arr).sum();
    }

    private static int calculateTotal(int n) {
        return n * (n + 1) / 2;
    }

}
