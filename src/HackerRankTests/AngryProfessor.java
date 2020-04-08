package HackerRankTests;

import java.util.Scanner;

public class AngryProfessor {
    // Complete the angryProfessor function below.
    static String angryProfessor(int k, int[] a) {
        String result = "YES";
        int entryCount = 0;
        for (int elem : a) {
            if (elem <= 0) {
                entryCount++;
            }
            if (entryCount == k) {
                result = "NO";
                break;
            }
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

            int[] a = new int[n];

            String[] aItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int aItem = Integer.parseInt(aItems[i]);
                a[i] = aItem;
            }

            String result = angryProfessor(k, a);
            System.out.println(result);
        }
        scanner.close();
    }
}
