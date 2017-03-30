/**
 * Created by ssadasivan on 28-12-2016.
 */
class MissingNumber {

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6};

        int missingNumber = findMissingNumber(arr);

        System.out.println("Missing number : " + missingNumber);
    }

    private static int findMissingNumber(int[] arr) {
        int total = calculateTotal(arr.length);
        int sum = calculateSum(arr);
        return Math.abs(total - sum);
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
