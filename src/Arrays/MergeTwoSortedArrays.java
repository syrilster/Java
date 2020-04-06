package Arrays;

/**
 * @author ssadasivan
 * @since 3/31/2017.
 * Idea is to copy all valid elements towards the end of the array and work with the same array to place the elements correctly.
 */
public class MergeTwoSortedArrays {
	private static final int INVALID_NUM = 0;

	public static void main(String[] args) {
		int[] arrayA = { -3, 5, INVALID_NUM, 7, INVALID_NUM, 10, INVALID_NUM, 11, INVALID_NUM };
		int[] arrayB = { -1, 2, 6, 12 };
		inPlaceMergeArrays(arrayA, arrayB);
		for (int value : arrayA) {
			System.out.print(value + ", ");
		}
	}

	private static void inPlaceMergeArrays(int[] arrayA, int[] arrayB) {
		int visitedIndex = arrayA.length - 1;
		// Move all non INVALID_NUM values to end of array.
		for (int i = arrayA.length - 1; i >= 0; i--) {
			if (arrayA[i] != INVALID_NUM) {
				arrayA[visitedIndex] = arrayA[i];
				visitedIndex--;
			}
		}
		int i = visitedIndex + 1;
		int j = 0, k = 0;
		while (i < arrayA.length && j < arrayB.length) {
			if (arrayA[i] < arrayB[j]) {
				arrayA[k++] = arrayA[i++];
			} else {
				arrayA[k++] = arrayB[j++];
			}
		}
		// copy any remaining elements of smaller array into larger one
		while (j < arrayB.length) {
			arrayA[k++] = arrayB[j++];
		}
	}
}
