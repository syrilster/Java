package Arrays;

/**
 * @author ssadasivan
 * @since 4/5/2017.
 *
For maximum non contiguous elements sum
1) Make sum equal to first element in arrays, a[0].
2) If sum is less than 0 and next element, say N is greater than or equal to 0, make sum =N, else,
3) If sum + N > sum, make sum = sum + N, else,
4) If (sum + N < sum) and (sum < N), make sum = N.
5) Repeat step 2, 3 and 4 for each element in the array.
 */
public class MaxSumArray {
	public static void main(String[] args) {
		int[] array = { 2, -1, 2, 3, 4, -5 };
		long[] test = findMaximumSum(array, array.length);
		for(long l : test){
			System.out.println(l);
		}
	}

	private static long[] findMaximumSum(int[] array, int length) {
		long[] result = new long[2];
		long contSum = array[0];
		long prevContSum = array[0];
		long nonContSum = array[0];
		for (int i = 1; i < length; i++) {
			if (contSum < 0 && array[i] >= 0) {
				contSum = array[i];
			} else {
				contSum += array[i];
			}
			if (nonContSum < 0 && array[i] >= 0) {
				nonContSum = array[i];
			} else if (nonContSum + array[i] > nonContSum) {
				nonContSum += array[i];
			} else if (nonContSum < array[i] && nonContSum + array[i] < nonContSum) {
				nonContSum = array[i];
			}
			if (contSum >= prevContSum) {
				prevContSum = contSum;
			} else if (contSum < 0) {
				contSum = array[i];
			}
		}
		result[0] = contSum > prevContSum ? contSum : prevContSum;
		result[1] = nonContSum;
		return result;
	}
}
