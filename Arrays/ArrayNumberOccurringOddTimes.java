package Arrays;

public class ArrayNumberOccurringOddTimes {
    public static void main(String[] args) {
        int[] input = {2, 3, 4, 3, 1, 4, 5, 1, 4, 2, 5};
        System.out.println("Number occurring odd number of times is = " + printNumberOccurringOddNumberOfTimes(input));
    }

    private static int printNumberOccurringOddNumberOfTimes(int[] numbers) {
        int result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result = result ^ numbers[i];
        }
        return result;
    }
}
