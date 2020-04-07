package HackerRankTests;

import java.util.Scanner;

public class FindDigits {
    // Complete the findDigits function below.
    static int findDigits(int n) {
        int count = 0;
        int num = n;
        while (n > 0) {
            // For number 1024 this will give rem = 4
            int rem = n % 10;
            if (rem != 0 && num % rem == 0) {
                count++;
            }
            // For number 1024 this will give n = 102
            n = n / 10;
        }

        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int result = findDigits(n);
            System.out.println(result);
        }

        scanner.close();
    }
}
