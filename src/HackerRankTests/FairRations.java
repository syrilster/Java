package HackerRankTests;

import java.util.Scanner;

public class FairRations {
    static String fairRations(int[] B) {
        int count = 0;
        int sum = 0;
        for (int elem : B) {
            sum += elem;
            if (elem % 2 == 1)
                count++;
        }
        return (sum % 2 == 0) ? String.valueOf(count * 2) : "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] B = new int[N];

        String[] BItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < N; i++) {
            int BItem = Integer.parseInt(BItems[i]);
            B[i] = BItem;
        }
        System.out.println(fairRations(B));
        scanner.close();
    }
}
