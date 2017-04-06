package Arrays;

/**
 * Created by Syril on 21-05-2016.
 */
public class DutchNationalFlagProblem {

    /*Driver function to check for above functions*/
    public static void main(String[] args) {
        int arr[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        int arr_size = arr.length;
        sort012(arr, arr_size);
        System.out.println("Array after seggregation ");
        printArray(arr, arr_size);
    }

    /* Utility function to print array arr[] */
    static void printArray(int arr[], int arr_size) {
        int i;
        for (i = 0; i < arr_size; i++)
            System.out.print(arr[i] + " ");
        System.out.println("");
    }


    static void sort012(int a[], int arr_size) {
        int low = 0;
        int high = arr_size - 1;
        int mid = 0;
        int temp = 0;
        while (mid <= high) {
            switch (a[mid]) {
                case 0:
                    temp = a[low];
                    a[low] = a[mid];
                    a[mid] = temp;
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    temp = a[high];
                    a[high] = a[mid];
                    a[mid] = temp;
                    high--;
                    break;

            }
        }
    }
}
