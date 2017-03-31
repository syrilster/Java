package Arrays;

/**
 * Created by Syril on 30-03-2017.
 */
public class MergeSortedArray {
    final static int INVALID_NUM = 0;

    public static void main(String[] args) {

        int[] arrayA = {-3, 5, INVALID_NUM, 7, INVALID_NUM, 10, INVALID_NUM, 11, INVALID_NUM};
        int[] arrayB = {-1, 2, 6, 12};

        inPlaceMergeArrays(arrayA, arrayB);
        for (int i = 0; i < arrayA.length; i++) {
            System.out.print(arrayA[i] + ", ");
        }
    }

    private static void inPlaceMergeArrays(int[] arrayA, int[] arrayB) {
    }
}
