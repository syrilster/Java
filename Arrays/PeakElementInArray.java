package Arrays;

/**
 * @author ssadasivan
 * @since 4/1/2017.
 */
public class PeakElementInArray {
	public static void main(String[] args) {
		int[] array = { 5, 10, 15, 25, 30, 45, 65, 50, 35, 1 };
		Integer peak = getPeakElement(array);
		System.out.println(peak != null ? "Peak Element is " + peak : "No peak element!");
	}

	private static int getPeakElement(int[] array) {
		int start = 0;
		int end = array.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if ((mid == 0 || array[mid - 1] <= array[mid]) && (array[mid] >= array[mid + 1])) {
				return array[mid];
			} else if (mid > 0 && array[mid - 1] > array[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return 0;
	}
}
