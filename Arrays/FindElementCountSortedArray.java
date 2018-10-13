package Arrays;

public class FindElementCountSortedArray {
    public static void main(String[] args) {
        int[] inputArray = new int[]{1, 2, 2, 3, 3, 4, 5, 5, 5, 5, 5, 6};
        int elementToSearch = 4;
        findElementCount(inputArray, elementToSearch);
    }

    public static void findElementCount(int[] inputArray, int elementToSearch) {
        int firstIndex = findElementBinarySearch(inputArray, elementToSearch, true);
        if (firstIndex == -1)
            System.out.println("Occurance count is zero");
        else {
            int lastIndex = findElementBinarySearch(inputArray, elementToSearch, false);
            System.out.println("Occurance count is " + (lastIndex - firstIndex + 1));
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
