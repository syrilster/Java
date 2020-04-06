package Arrays;

public class MaximumSumPath2Arrays {
    // Utility function to find maximum of two integers
    int max(int x, int y) {
        return Math.max(x, y);
    }

    // This function returns the sum of elements on maximum path
    // from beginning to end
    int maxPathSum(int[] arrayOne, int[] arrayTwo, int m, int n) {
        // initialize indexes for arrayOne[] and arrayTwo[]
        int i = 0, j = 0;

        // Initialize result and current sum through arrayOne[] and arrayTwo[].
        int result = 0, sum1 = 0, sum2 = 0;

        // Below 3 loops are similar to merge in merge sort
        while (i < m && j < n) {
            // Add elements of arrayOne[] to sum1
            if (arrayOne[i] < arrayTwo[j])
                sum1 += arrayOne[i++];

                // Add elements of arrayTwo[] to sum2
            else if (arrayOne[i] > arrayTwo[j])
                sum2 += arrayTwo[j++];

                // we reached a common point
            else {
                // Take the maximum of two sums and add to result
                result += max(sum1, sum2);

                // Update sum1 and sum2 for elements after this
                // intersection point
                sum1 = 0;
                sum2 = 0;

                // Keep updating result while there are more common
                // elements
                while (i < m && j < n && arrayOne[i] == arrayTwo[j]) {
                    result = result + arrayOne[i++];
                    j++;
                }
            }
        }

        // Add remaining elements of arrayOne[]
        while (i < m)
            sum1 += arrayOne[i++];

        // Add remaining elements of arrayTwo[]
        while (j < n)
            sum2 += arrayTwo[j++];

        // Add maximum of two sums of remaining elements
        result += max(sum1, sum2);

        return result;
    }


    // Driver program to test above functions
    public static void main(String[] args) {
        MaximumSumPath2Arrays sumPath = new MaximumSumPath2Arrays();
        int[] ar1 = {2, 3, 7, 10, 12};
        int[] ar2 = {1, 5, 7, 8};
        int m = ar1.length;
        int n = ar2.length;
        System.out.println("Maximum sum path is :" +
                sumPath.maxPathSum(ar1, ar2, m, n));
    }
}
