/**
 * Created by Syril on 22-04-2016.
 */
public class Array0And1 {

    public static void main(String[] args) {
        int[] array = {0, 1, 0, 1, 1, 1, 0, 0};
        segregate0And1(array);
        for (int i : array) {
            System.out.print(" " + i);
        }
    }

    public static void segregate0And1(int[] array) {
        int left = 0, right = array.length - 1;
        while (left < right) {
            while (array[left] == 0 && left < right)
                left++;
            while (array[right] == 1 && left < right)
                right--;

            /* If left is smaller than right then there is a 1 at left
          and a 0 at right.  Exchange arr[left] and arr[right]*/
            if (left < right) {
                array[left] = 0;
                array[right] = 1;
                left++;
                right--;
            }
        }
    }
}
