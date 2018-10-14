package Arrays;

import java.util.Arrays;

/**
 * 1. Create a low pointer at the beginning of the array and a high pointer at the end of the array.
 * 2. Create a mid pointer that starts at the beginning of the array and iterates through each element.
 * 3. If the element at arr[mid] is a 2, then swap arr[mid] and arr[high] and decrease the high pointer by 1.
 * 4. If the element at arr[mid] is a 0, then swap arr[mid] and arr[low] and increase the low and mid pointers by 1.
 * 5. If the element at arr[mid] is a 1, don't swap anything and just increase the mid pointer by 1.
 */
public class DutchNationalFlagProblem {

    public static void main(String[] args) {
        int[] inputArray = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        sortNumbers(inputArray);
        System.out.println("Array sorting: ");
        Arrays.stream(inputArray).forEach(System.out::print);
    }

    static void sortNumbers(int[] inputArray) {
        int low = 0, mid = 0;
        int high = inputArray.length - 1;
        while (mid <= high) {
            switch (inputArray[mid]) {
                case 0:
                    swap(inputArray, low, mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(inputArray, high, mid);
                    high--;
                    break;

            }
        }
    }

    private static void swap(int[] inputArray, int indexOne, int indexTwo) {
        int temp = inputArray[indexOne];
        inputArray[indexOne] = inputArray[indexTwo];
        inputArray[indexTwo] = temp;
    }
}
