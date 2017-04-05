package Arrays;

/**
 * @author ssadasivan
 * @since 4/5/2017.
 */
public class MaxSubArraySum {
    public static void main(String[] args) {
        int[] array = {2, -1, 2, 3, 4, -5};
        System.out.println("Max sum contiguous : " + findMaxSumContiguous(array));
        System.out.println("Max sum non contiguous : " + findMaximumSum(array));
    }

    private static int findMaxSumContiguous(int[] array) {
        int sum = 0, ans = 0;
        for (int i = 0; i < array.length; i++) {
            if (sum + array[i] > 0) {
                sum += array[i];
            } else {
                sum = 0;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    private static int findMaximumSum(int[] array) {
        int result = 0;
        int nonContSum = array[0];
        for (int i = 1; i < array.length; i++) {
            //If sum is already negative and array[i] is a positive number then replace sum with array[i]
            if (nonContSum < 0 && array[i] >= 0) {
                nonContSum = array[i];
            }
            // If sum + current element is greater case
            else if (nonContSum + array[i] > nonContSum) {
                nonContSum += array[i];
            } //sum is already negative and array[i] is also a negative number higher than sum
            else if (nonContSum < array[i] && nonContSum + array[i] < nonContSum) {
                nonContSum = array[i];
            }
        }
        result = nonContSum;
        return result;
    }
}
