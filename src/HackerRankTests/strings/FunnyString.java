package HackerRankTests.strings;

import java.util.Scanner;

/**
 * No need to reverse the String as comparing first 2 elems and last 2 elems are sufficient
 */
public class FunnyString {
    static String funnyString(String s) {
        String result = "Funny";
        int j = s.length() - 1;
        for (int i = 1; i < s.length(); i++) {
            int prevElemAscii = s.charAt(i - 1);
            int currentElemAscii = s.charAt(i);
            int reverseElemAscii = s.charAt(j);
            int reversePrevElemAscii = s.charAt(j - 1);
            if (Math.abs(currentElemAscii - prevElemAscii) == Math.abs(reverseElemAscii - reversePrevElemAscii)) {
                j--;
            } else {
                result = "Not Funny";
                break;
            }
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            String result = funnyString(s);
            System.out.println(result);
        }

        scanner.close();
    }
}
