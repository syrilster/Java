/**
 * Created by Syril on 09-04-2016.
 */
public class FindMissingNumber {

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 6, 2};

        int missingNumber = findMissingNumber(arr);

        System.out.println("Missing number : " + missingNumber);
    }

    private static int findMissingNumber(int[] arr) {
        int total = calculateTotal(arr.length + 1);
        int sum = calculateSum(arr);
        return total - sum;
    }

    private static int calculateSum(int[] arr) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        return sum;
    }

    private static int calculateTotal(int n) {
        return n * (n + 1) / 2;
    }
}
