package Arrays;

public class FindElementCountSortedArray {
    public static void main(String[] args) {
        int[] arrayOne = {1, 1, 2, 4, 5, 6, 7, 8, 9, 9, 9, 9, 10};  // x = 9, ans = 4
        int[] arrayTwo = {1, 1, 2, 2, 2, 2, 3};  // x = 3, ans = 1

        System.out.println("Given Element occurs " + findElementCount(arrayOne, 9) + " time(s)");
        System.out.println("Given Element occurs " + findElementCount(arrayTwo, 3) + " time(s)");
    }

    private static int findElementCount(int[] inputArray, int elementToSearch) {
        int firstIndex = findElementBinarySearch(inputArray, elementToSearch, true);
        if (firstIndex == -1)
            return 0;
        else {
            int lastIndex = findElementBinarySearch(inputArray, elementToSearch, false);
            return (lastIndex - firstIndex + 1);
        }
    }

    private static int findElementBinarySearch(int[] inputArray, int elementToSearch, boolean firstElement) {
        int low = 0;
        int high = inputArray.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (inputArray[mid] == elementToSearch) {
                result = mid;
                if (firstElement)
                    high = mid - 1;
                else
                    low = mid + 1;
            } else if (inputArray[mid] < elementToSearch) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }
}
