package Arrays;

/**
 * Created by Syril on 25-05-2016.
 */
public class SearchElementCircularSortedArray {

    public static void main(String[] args) {
        int array[] = {3, 4, 5, 6, 1, 2};
        findElementInSortedRotatedArrayTest(array, 1);
    }

    private static void findElementInSortedRotatedArrayTest(int[] array, int elementToSearch) {
        int index = findElementInSortedRotatedArray(array, elementToSearch);
        System.out.println("Element " + elementToSearch + (index >= 0 ? (" found at index " + index) : " not found!"));
    }

    private static int findElementInSortedRotatedArray(int[] inputArray, int elementToSearch) {

        if (inputArray == null || inputArray.length == 0) {
            return -1;
        }

        int pivot = findPivot(inputArray);

        // Find the pivot first and search only in the half where the number might exist. since this is sorted.
        if (pivot > 0 && elementToSearch >= inputArray[0] && elementToSearch <= inputArray[pivot - 1]) {
            return binarySearch(inputArray, 0, pivot - 1, elementToSearch);
        } else {
            return binarySearch(inputArray, pivot, inputArray.length - 1, elementToSearch);
        }
    }


    private static int binarySearch(int[] array, int startIndex, int endIndex, int elementToSearch) {

        if (array == null || array.length == 0) {
            return -1;
        }

        if (startIndex > endIndex || startIndex < 0 || endIndex >= array.length) {
            throw new IllegalArgumentException("Invalid values for start and end! start = " + startIndex + ", end = " + endIndex);
        }

        if (elementToSearch < array[startIndex] || elementToSearch > array[endIndex]) {
            return -1;
        }

        while (startIndex <= endIndex) {
            int mid = (startIndex + endIndex) / 2;
            if (array[mid] == elementToSearch) {
                return mid;
            } else if (elementToSearch < array[mid]) {
                endIndex = mid - 1;
            } else {
                startIndex = mid + 1;
            }
        }

        return -1;
    }


    /**
     * Algorithm Insights
     * case 1: inputArray[lowIndex] < inputArray[highIndex]
     * return lowIndex; As the array is already sorted.
     * case 2: Pivot is a element where the prev and next number is greater than itself
     * next = (mid + 1) % arrayLength; Modulo to avoid overflow
     * prev = (mid + arraylength -1) % arrayLength; adding arrayLength so that it wont be a negative number.
     * inputArray[midIndex] <= inputArray[next] && inputArray[midIndex] <= inputArray[prev]
     * return midIndex;
     * case 3: Discard the right segment
     * inputArray[midIndex] <= inputArray[highIndex]
     * highIndex = midIndex - 1;
     * case 4: Discard the left segment and search in right.
     * inputArray[midIndex] >= inputArray[lowIndex];
     * lowIndex = midIndex + 1;
     *
     * @param inputArray
     * @return
     */
    private static int findPivot(int[] inputArray) {
        int length = inputArray.length;
        int lowIndex = 0, highIndex = length - 1;
        while (lowIndex <= highIndex) {
            if (inputArray[lowIndex] < inputArray[highIndex]) {
                return lowIndex;
            }
            int midIndex = (lowIndex + highIndex) / 2;
            int next = (midIndex + 1) % length;
            int prev = (midIndex + length - 1) % length;
            if (inputArray[midIndex] <= inputArray[next] && inputArray[midIndex] <= inputArray[prev])
                return midIndex;

            if (inputArray[midIndex] <= inputArray[highIndex])
                highIndex = midIndex - 1;

            else if (inputArray[midIndex] >= inputArray[lowIndex])
                lowIndex = midIndex + 1;

        }
        return -1;
    }
}
