package Arrays;

/**
 * Find missing number in the duplicate array.
 * XOR operation with itself is 0. So initialize the first element as result and perform XOR operation with other elements of array.
 */
public class FindMissingElementFromArrays {
	public static void main(String[] args) {
		int[] array1 = { 9, 7, 8, 5, 4, 6, 2, 3, 1 };
		int[] array2 = { 2, 3, 4, 9, 1, 8, 5, 6, 7, 10 };
		missingNumberInDuplicateArray(array1, array2);
	}

	private static void missingNumberInDuplicateArray(int[] array1, int[] array2) {
		if (array1 == null || array1.length == 0)
			throw new IllegalArgumentException("array1 cannot be empty");
		if (array2 == null || array2.length == 0)
			throw new IllegalArgumentException("array2 cannot be empty");
		int len1 = array1.length;
		int len2 = array2.length;
		if (Math.abs(len1 - len2) != 1) {
			System.out.println("Input is not valid!");
			return;
		}
		if (len1 > len2) {
			findMissingNumber(array1, array2);
		} else {
			findMissingNumber(array2, array1);
		}
	}

	private static void findMissingNumber(int[] arrayOne, int[] arrayTwo) {
		int result = arrayOne[0];
		for (int i = 1; i < arrayOne.length; i++) {
			result = result ^ arrayOne[i];
		}
		for (int i = 0; i < arrayTwo.length; i++) {
			result = result ^ arrayTwo[i];
		}
		System.out.println("Missing element = " + result);
	}
}
