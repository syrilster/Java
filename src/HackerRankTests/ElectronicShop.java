package HackerRankTests;

import java.util.Scanner;

/**
 * Sample Input 0
 *
 * 10 2 3
 * 3 1
 * 5 2 8
 * Sample Output 0
 *
 * 9
 * Explanation 0
 *
 * She can buy the 2nd keyboard and the 3rd USB drive for a total cost of 8 + 1 = 9.
 *
 * compare all pairs if they are <= budget and
 * are > max then set the new max appropriately.
 */
public class ElectronicShop {
    /*
     * Complete the getMoneySpent function below.
     */
    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        if (keyboards.length == 1 && drives.length == 1) {
            return (keyboards[0] + drives[0]) > b ? -1 : (keyboards[0] + drives[0]);
        }

        int max = -1;

        for (int keyboard : keyboards) {
            for (int drive : drives) {
                if (keyboard + drive <= b && keyboard + drive > max)
                    max = keyboard + drive;
            }
        }
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String[] bnm = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int b = Integer.parseInt(bnm[0]);

        int n = Integer.parseInt(bnm[1]);

        int m = Integer.parseInt(bnm[2]);

        int[] keyboards = new int[n];

        String[] keyboardsItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        for (int keyboardsItr = 0; keyboardsItr < n; keyboardsItr++) {
            int keyboardsItem = Integer.parseInt(keyboardsItems[keyboardsItr]);
            keyboards[keyboardsItr] = keyboardsItem;
        }

        int[] drives = new int[m];

        String[] drivesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        for (int drivesItr = 0; drivesItr < m; drivesItr++) {
            int drivesItem = Integer.parseInt(drivesItems[drivesItr]);
            drives[drivesItr] = drivesItem;
        }

        /*
         * The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
         */

        int moneySpent = getMoneySpent(keyboards, drives, b);
        System.out.println(moneySpent);

        scanner.close();
    }
}
