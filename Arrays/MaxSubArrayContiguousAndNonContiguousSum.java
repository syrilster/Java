package Arrays;

/**
 * @author ssadasivan
 * @since 4/5/2017.
 */
public class MaxSubArrayContiguousAndNonContiguousSum {
    public static void main(String[] args) {
        int[] array = {2, -1, 2, 3, 4, -5};
        System.out.println("Max sum contiguous : " + findMaxSumContiguous(array));
        System.out.println("Max sum non contiguous : " + findMaximumSum(array));
    }

    private static int findMaxSumContiguous(int[] array) {
        int sum = 0, finalSum = 0;
        for (int i = 0; i < array.length; i++) {
            if (sum + array[i] > 0) {
                sum += array[i];
            } else {
                sum = 0;
            }
            finalSum = Math.max(finalSum, sum);
        }
        return finalSum;
    }

    private static int findMaximumSum(int[] array) {
        int nonContiguousSum = array[0];
        for (int i = 1; i < array.length; i++) {
            //If sum is already negative and array[i] is a positive number then replace sum with array[i]
            if (nonContiguousSum < 0 && array[i] >= 0) {
                nonContiguousSum = array[i];
            }
            // If sum + current element is greater case
            else if (nonContiguousSum + array[i] > nonContiguousSum) {
                nonContiguousSum += array[i];
            } //sum is already negative and array[i] is also a negative number higher than sum
            else if (nonContiguousSum < array[i] && nonContiguousSum + array[i] < nonContiguousSum) {
                nonContiguousSum = array[i];
            }
        }
        return nonContiguousSum;
    }
}
