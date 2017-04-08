package Arrays;

/**
 * Created by Syril on 25-05-2016.
 */
public class FindElementSortedRoatedArray {

    public static void main(String[] args) {
        int array[] = { 3, 4, 5, 6, 1, 2 };
        findElementInSortedRotatedArrayTest(array, 5);
    }

    private static void findElementInSortedRotatedArrayTest(int[] array, int num) {
        int index = findElementInSortedRotatedArray(array, num);
        System.out.println("Element " + num + (index >= 0 ? (" found at index " + index) : " not found!"));
    }

    public static int findElementInSortedRotatedArray(int array[], int num) {

        if (array == null || array.length == 0) {
            return -1;
        }

        int pivot = findPivot(array);

        if (pivot > 0 && num >= array[0] && num <= array[pivot - 1]) {
            return binarySearch(array, 0, pivot - 1, num);
        } else {
            return binarySearch(array, pivot, array.length - 1, num);
        }
    }


    public static int binarySearch(int[] array, int start, int end, int num) {

        if (array == null || array.length == 0) {
            return -1;
        }

        if(start > end || start < 0 || end >= array.length) {
            throw new IllegalArgumentException("Invalid values for start and end! start = " + start + ", end = " + end);
        }

        if(num < array[start] || num > array[end]) {
            return -1;
        }

        while (start <= end) {

            int mid = (start + end) / 2;
            if (array[mid] == num) {
                return mid;
            } else if (num < array[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }



    public static int findPivot(int arr[]) {
        int length = arr.length;
        int start = 0, end = length - 1;
        while (start <= end) {
            if (arr[start] < arr[end]) {
                return start;
            }
            int mid = (start + end) / 2;
            int next = (mid + 1) % length;
            int prev = (mid + length - 1) % length;
            if (arr[mid] <= arr[next] && arr[mid] <= arr[prev])
                return mid;

            if (arr[mid] <= arr[end])
                end = mid - 1;

            else if (arr[mid] >= arr[start])
                start = mid + 1;

        }
        return -1;
    }
}
