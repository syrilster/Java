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

	private static int getPeakElement(int[] inputArray) {
		int startIndex = 0;
		int endIndex = inputArray.length - 1;
		while (startIndex <= endIndex) {
			int midIndex = (startIndex + endIndex) / 2;
			if ((midIndex == 0 || inputArray[midIndex - 1] <= inputArray[midIndex]) && (inputArray[midIndex] >= inputArray[midIndex + 1])) {
				return inputArray[midIndex];
			} else if (midIndex > 0 && inputArray[midIndex - 1] > inputArray[midIndex]) {
				endIndex = midIndex - 1;
			} else {
				startIndex = midIndex + 1;
			}
		}
		return 0;
	}
}
