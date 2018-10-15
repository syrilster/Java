package Arrays;

/**
 * Efficient Solution: Using Array Reversal
 * 1. Reverse the array elements from 0 to numRotations - 1.
 * 2. Reverse the array elements from numRotations to array.length-1.
 * 3. Reverse the whole array.
 * Example:
 * 1 2 3 4 5
 * numRotations = 3
 * Step 1. Reverse the array elements from 0 to 2: 3 2 1 4 5
 * Step 2. Reverse the array elements from 3 to 4: 3 2 1 5 4
 * Step 3. Reverse the whole array: 4 5 1 2 3
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class RotateArrayNumOfTimes {
    public static void main(String[] args) {
        int numberOfRotations = 2;
        int[] array = {1, 2, 3, 4, 5};
        rotateArray(array, numberOfRotations);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    public static void rotateArray(int[] array, int numberOfRotations) {
        if (numberOfRotations < 0) {
            throw new IllegalArgumentException("Number of rotations cannot be less than zero");
        }

        if (array == null || array.length < 2)
            return;
        int length = array.length;
        // This is required to limit the number of rotations. Ex: numberOfRotations = 20 and inputArray length is 4
        if (numberOfRotations > length)
            numberOfRotations = numberOfRotations % length;
        reverse(array, 0, numberOfRotations - 1);
        reverse(array, numberOfRotations, length - 1);
        reverse(array, 0, length - 1);
    }

    public static void reverse(int[] array, int start, int end) {
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

}
