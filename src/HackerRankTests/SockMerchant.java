package HackerRankTests;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SockMerchant {
    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        if (ar.length == 1)
            return 0;
        Set<Integer> pairSet = new HashSet<>();
        int pairCount = 0;
        for (int elem : ar) {
            if (pairSet.contains(elem)) {
                pairSet.remove(elem);
                pairCount++;
            } else {
                pairSet.add(elem);
            }
        }
        return pairCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);
        System.out.println(result);

        scanner.close();
    }
}
