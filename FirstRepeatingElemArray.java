import java.util.HashSet;
import java.util.Set;

/**
 * Created by Syril on 07-04-2016.
 */
public class FirstRepeatingElemArray {
    public static void main(String[] args) throws java.lang.Exception {
        int arr[] = {10, 5, 10, 4, 3, 5, 6};
        printFirstRepeating(arr);
    }

    static void printFirstRepeating(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int min = -1;

        for (int i = arr.length - 1; i >= 0; i--) {
            if (set.contains(arr[i])) {
                min = i;
            } else {
                set.add(arr[i]);
            }
        }

        if (min != -1) {
            System.out.println("First repeating element in array is " + arr[min]);
        }
    }
}
