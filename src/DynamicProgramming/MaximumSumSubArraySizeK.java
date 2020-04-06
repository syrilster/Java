package DynamicProgramming;

/**
 * Given [1, 9, -1, -2, 7, 3, -1, 2] and a size of sub array k=4. Find the maximum sum of sub array of size k.
 * Output: 13 [9, -1, -2, 7]
 * Algorithm insights: Using the sliding window technique for brute force and optimal solution using DP to exclude one elem and include last elem
 * Time Complexity: O(n)
 * https://www.youtube.com/watch?v=__guhvzO540&list=PLSIpQf0NbcCk2O05hkxHPtVqGRGtnClh8&index=11
 */
public class MaximumSumSubArraySizeK {
    public static void main(String[] args) {
        int[] input = {1, 9, -1, -2, 7, 3, -1, 2};
        int k = 4;
        System.out.println("Max Sum: " + maximumSumSubArraySizeK(input, k));
    }

    static int maximumSumSubArraySizeK(int[] input, int k) {
        int maxSum = Integer.MIN_VALUE;
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += input[i];
        }

        for (int end = k; end < input.length; end++) {
            windowSum += input[end] - input[end-k];
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }
}
