package Arrays;

/**
 * XOR operation on a number with itself even number of times will result in 0.
 * XOR operation on a number with itself odd number of times will result in the number itself.
 */
public class SwapTwoNumbersWithoutTemp {
    public static void main(String[] args) {
        int x = 12; // Binary is 1100
        int y = 15; // Binary is 1111

        System.out.println("Before swapping the numbers are: x = " + x + " and y = " + y);

        x = x ^ y; // This will give 3 i.e 0011
        y = x ^ y; // 3(0011) and 15(1111) will give 1100 which is 12
        x = x ^ y; // 3(0011) and 12(1100) will give 15(1111)

        System.out.println("After swapping the numbers are: x = " + x + " and y = " + y);
    }
}
