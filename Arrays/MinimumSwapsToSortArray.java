package Arrays;

/**
 * You are given an unordered array consisting of consecutive integers  [1, 2, 3, ..., n] without any duplicates. You are allowed to swap
 * any two elements. You need to find the minimum number of swaps required to sort the array in ascending order.
 * <p>
 * For example, given the array  we perform the following steps:
 * <p>
 * i   arr                     swap (indices)
 * 0   [7, 1, 3, 2, 4, 5, 6]   swap (0,3)
 * 1   [2, 1, 3, 7, 4, 5, 6]   swap (0,1)
 * 2   [1, 2, 3, 7, 4, 5, 6]   swap (3,4)
 * 3   [1, 2, 3, 4, 7, 5, 6]   swap (4,5)
 * 4   [1, 2, 3, 4, 5, 7, 6]   swap (5,6)
 * 5   [1, 2, 3, 4, 5, 6, 7]
 * It took  5 swaps to sort the array.
 */
public class MinimumSwapsToSortArray {

    // Complete the minimumSwaps function below.
     static int minimumSwaps(int[] inputArray) {

        int swapCount = 0;
        int lowIndex = 0;
        int highIndex = inputArray.length - 1;
        while (lowIndex < highIndex) {
            int elementAtLowIndex = inputArray[lowIndex];
            int elementAtHighIndex = inputArray[highIndex];
            if (elementAtLowIndex > elementAtHighIndex) {
                swapCount++;
                swap(inputArray, lowIndex, highIndex);
                highIndex--;
            } else {
                lowIndex++;
            }
        }
        return swapCount;
    }

    private static void swap(int[] inputArray, int start, int end) {
        int temp = inputArray[start];
        inputArray[start] = inputArray[end];
        inputArray[end] = temp;
    }

    public static void main(String[] args) {
        int[] inputArray = new int[]{7, 1, 3, 2, 4, 5, 6};
        int res = minimumSwaps(inputArray);
        System.out.println("Minimum Swaps required is: " + res);
    }

}
