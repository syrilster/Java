/**
 * Algorithm/Insights
 * <p>
 * We use sliding window strategy for solving this.
 * Step 1: Find sum of first k elements in the input array. Initialize maxSum to the calculated sum and maxSumStartIndex = 0.
 * Step 2: Add next element to the sum and subtract first element from the sum. Check if this sum is greater than previous sum and update maxSum and maxSumStartIndex.
 * Step 3: Keep adding next element to the sum and removing first element from the sum to get sum of current sub array of size k and update maxSum and maxSumStartIndex whenever a greater sum is seen.
 * Step 4: Finally print k elements starting from maxSumStartIndex.
 * Example : Sum of (1-3) = sum of elements (0-2) + array[3] - array[0]
 *           Sum of (2-4) = sum of elements (1-3) + array[4] - array[2]
 */
public class MaxAvgSubArray {
    public static void printMaxAvgSubarray(int[] input, int k) {
        System.out.print("Maximum average subarray of length " + k + " is:  ");
        int index = getMaxAvgSubarrayStartIndex(input, k);
        for (int i = 0; i < k; i++) {
            System.out.print(input[index++] + " ");
        }
    }

    public static void main(String[] args) {
        int[] input = {11, -8, 16, -7, 24, -2, 3};
        int k = 3;
        printMaxAvgSubarray(input, k);
    }

    private static int getMaxAvgSubarrayStartIndex(int[] input, int subArraySize) {
        if (subArraySize > input.length) {
            throw new IllegalArgumentException("Size of k cannot be greater than array");
        }
        int sum = input[0];
        for (int i = 1; i < subArraySize; i++) {
            sum += input[i];
        }

        int maxSum = sum;
        int maxSumIndex = 0;

        for (int i = subArraySize; i < input.length; i++) {
            sum = sum + input[i] - input[i - subArraySize];
            if (sum > maxSum) {
                maxSum = sum;
                maxSumIndex = i - subArraySize;
            }
        }
        return maxSumIndex + 1;
    }
}
