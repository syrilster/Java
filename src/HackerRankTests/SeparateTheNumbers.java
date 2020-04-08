package HackerRankTests;

import java.util.Scanner;

/**
 * 1. Iterate the input string till half way. No point going above this as we cannot create a substring of equal length
 * 2. Start with a substring of length 1 and then increment and build a substring equal to length of the given string
 * 3. If the newly built substring and the original input string is equal then return YES
 */
public class SeparateTheNumbers {
    static void separateNumbers(String s) {
        String subString = "";
        boolean isValid = false;
        for (int i = 1; i <= s.length() / 2; i++) {
            subString = s.substring(0, i);
            long number = Long.parseLong(subString);
            StringBuilder validString = new StringBuilder(subString);
            while (validString.length() < s.length()) {
                validString.append(++number);
            }
            if (s.equals(validString.toString())) {
                isValid = true;
                break;
            }
        }

        System.out.println(isValid ? "YES " + subString : "NO");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            separateNumbers(s);
        }

        scanner.close();
    }
}
