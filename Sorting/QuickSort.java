package Sorting;

import java.util.stream.IntStream;

/**
 * Algorithm Insights
 * https://www.youtube.com/watch?v=COk73cpQbFQ
 */
public class QuickSort {
    public static void main(String[] args) {
        int unsortedArray[] = new int[]{10, 6, 7, 3, 1, 5, 4, 8, 9, 2};
        quickSort(unsortedArray, 0, unsortedArray.length - 1);
        IntStream.of(unsortedArray).forEach(System.out::println);
    }

    static int partition(int[] inputArray, int startIndex, int endIndex) {
        int pivot = inputArray[endIndex];
        int partitionIndex = startIndex;
        for (int loopIndex = startIndex; loopIndex < endIndex; loopIndex++) {
            if (inputArray[loopIndex] <= pivot) {
                //Swap if element is lesser than pivot. The objective here is to place element lesser than pivot on one side
                swap(inputArray, loopIndex, partitionIndex);
                partitionIndex++;
            }
        }
        //Now all elements are in place and hence swap the pivot and partition index itself.
        swap(inputArray, partitionIndex, endIndex);
        return partitionIndex;
    }

    private static void quickSort(int[] inputArray, int start, int end) {
        if (start < end) {
            int partitionIndex = partition(inputArray, start, end);
            quickSort(inputArray, start, partitionIndex - 1);
            quickSort(inputArray, partitionIndex + 1, end);
        }
    }

    private  static void swap(int[] inputArray, int startIndex, int endIndex) {
        int temp = inputArray[startIndex];
        inputArray[startIndex] = inputArray[endIndex];
        inputArray[endIndex] = temp;
    }
}
