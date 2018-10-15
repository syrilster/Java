package Arrays;

import java.util.*;

/**
 * Created by Syril on 04-04-2016.
 */
public class FindPairCountForGivenInput {

    public static void main(String[] args) {
        int[] inputArray = new int[]{2, 1, 3, 4, 6, 3};
        int sum = 6;

        if (inputArray.length > 2) {
            getPairAndCount(inputArray, sum);
        }
    }

    private static void getPairAndCount(int[] inputArray, int sumDiff) {
        Arrays.sort(inputArray);

        int lowIndex = 0;
        int highIndex = inputArray.length - 1;
        int pairCount = 0;

        while (lowIndex < highIndex) {

            int diff = inputArray[highIndex] + inputArray[lowIndex];
            if (diff > sumDiff) {
                highIndex--;
            } else if (diff < sumDiff) {
                lowIndex++;
            } else if (diff == sumDiff) {
                System.out.printf("(%d, %d) %n", inputArray[lowIndex], inputArray[highIndex]);
                pairCount++;
                lowIndex++;
                highIndex--;
            }
        }

        System.out.println("The pair count found is " + pairCount);
    }
}
