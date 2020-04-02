package HackerRankTests;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/***
 * Sample Input 0
 *
 * 4
 * 3 2 1 3
 * Sample Output 0
 *
 * 2
 * Explanation 0
 *
 * We have one candle of height 1, one candle of height 2, and two candles of height 3.
 * Your niece only blows out the tallest candles, meaning the candles where height=3. Because there are 2 such candles, we print 2 on a new line.
 */
public class BirthdayCakeCandles {
    // Complete the birthdayCakeCandles function below.
    static int birthdayCakeCandles(int[] ar) {
        Map<Integer, Integer> valMap = new HashMap<>();
        int maxSeen = 0;
        for (int elem : ar) {
            if (elem > maxSeen) {
                maxSeen = elem;
            }
            valMap.merge(elem, 1, Integer::sum);
        }

        return valMap.get(maxSeen);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int arCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[arCount];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arCount; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = birthdayCakeCandles(ar);
        System.out.println(result);

        scanner.close();
    }
}
