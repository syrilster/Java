package Arrays;

/**
 * Created by Syril on 25-05-2016.
 */
public class FindPivotInRotatedArray {
    public static void main(String[] args) {
        int arr1[] = {3, 4, 5, 6, 1, 2};
        int n1 = arr1.length;
        System.out.println("The minimum element is " + findMin(arr1, n1));

    }

    public static int findMin(int arr[], int n) {
        int low = 0, high = n - 1;
        while (low <= high) {
            if (arr[low] < arr[high]) {
                return arr[low];
            }
            int mid = (low + high) / 2;
            int next = (mid + 1) % n;
            int prev = (mid + n - 1) % n;
            if (arr[mid] <= arr[next] && arr[mid] <= arr[prev])
                return arr[mid];

            if (arr[mid] <= arr[high])
                high = mid - 1;
            else if (arr[mid] >= arr[low])
                low = mid + 1;

        }
        return -1;
    }
}
