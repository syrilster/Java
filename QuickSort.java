/**
 * Created by Syril on 16-06-2016.
 */
public class QuickSort {
    public static void main(String[] args) {
        int a[] = new int[]{2, 6, 7, 3, 1, 5, 4, 8, 9, 10};
        quickSort(a, 0, 9);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    static int partition(int[] a, int start, int end) {
        int pivot = a[end];
        int pIndex = start;
        for (int i = start; i < end; i++) {
            if (a[i] <= pivot) {
                swap(a, i, pIndex);
                pIndex++;
            }
        }
        swap(a, pIndex, end);
        return pIndex;
    }

    static void quickSort(int[] a, int start, int end) {
        if (start < end) {
            int pIndex = partition(a, start, end);
            quickSort(a, start, pIndex - 1);
            quickSort(a, pIndex + 1, end);
        }
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
