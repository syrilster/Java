package Arrays;

import java.io.IOException;
import java.util.Scanner;

public class ValleyCount {
    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int valleyCount = 0;
        int temp = 0;
        int prevTemp;
        for (int loopIndex = 0; loopIndex < s.length(); loopIndex++) {
            prevTemp = temp;
            if (s.charAt(loopIndex) == 'U')
                temp++;
            else
                temp--;
            if (temp == 0 && prevTemp < 0)
                valleyCount++;
        }
        return valleyCount;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        System.out.println(result);

        scanner.close();
    }
}
