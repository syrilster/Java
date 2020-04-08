package HackerRankTests.strings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TwoStrings {
    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        boolean shareSubString = false;
        Set<Character> stringOne = new HashSet<>();
        for (int i = 0; i < s1.length(); i++) {
            stringOne.add(s1.charAt(i));
        }

        for (int j = 0; j < s2.length(); j++) {
            if (stringOne.contains(s2.charAt(j))) {
                shareSubString = true;
                break;
            }
        }

        return shareSubString ? "YES" : "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);
            System.out.println(result);
        }


        scanner.close();
    }
}
