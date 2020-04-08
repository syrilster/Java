package HackerRankTests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class OddNumbersInRange {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        int r = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> result = oddNumbers(l, r);
        result.forEach(System.out::println);
        bufferedReader.close();

    }

    private static List<Integer> oddNumbers(int l, int r) {
        List<Integer> oddNumbers = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            if (i % 2 == 1) {
                oddNumbers.add(i);
            }
        }
        return oddNumbers;
    }
}
