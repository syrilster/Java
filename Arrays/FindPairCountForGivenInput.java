package Arrays;

import java.util.*;

/**
 * Created by Syril on 04-04-2016.
 */
public class FindPairCountForGivenInput {

    public static void main(String[] args) {
        int[] inputArray = new int[]{1, 5, 3, 4, 2};
        int sum = 2;

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

            int sumOfLowAndHigh = inputArray[highIndex] + inputArray[lowIndex];
            if (sumOfLowAndHigh > sumDiff) {
                highIndex--;
            } else if (sumOfLowAndHigh < sumDiff) {
                lowIndex++;
            } else if (sumOfLowAndHigh == sumDiff) {
                System.out.printf("(%d, %d) %n", inputArray[lowIndex], inputArray[highIndex]);
                pairCount++;
                lowIndex++;
                highIndex--;
            }
        }

        System.out.println("The pair count found is " + pairCount);
    }
}
