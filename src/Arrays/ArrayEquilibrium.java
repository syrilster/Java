package Arrays;

/**
 * Created by Syril on 21-05-2016.
 */
public class ArrayEquilibrium {
    public static void main(String[] args) {
        int arr[] = {1, 1, 2};
        System.out.println("Equilibrium index is " + equilibrium(arr));

    }

    static int equilibrium(int[] array) {
        int leftSum = 0;
        int sum = 0;
        for (int loopValue : array) {
            sum += loopValue;
        }

        for (int j = 0; j < array.length; j++) {
            sum -= array[j];
            if (leftSum == sum)
                return j;
            leftSum += array[j];
        }

        return -1;
    }
}
