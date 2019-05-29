package Arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Syril on 04-04-2016.
 */
public class pairExistsInArrayOptimal {

    public static void main(String[] args) {
        int[] inputArray = new int[]{1, 2, 8, 4, 4};
        int sumDiff = 8;

        if (inputArray.length <= 2) {
            System.out.println("The sum pair is not present");
            return;
        }
        //Required if the input is not sorted.
        //Arrays.sort(inputArray);
        String message = hasPairWithSum(inputArray, sumDiff) ? "is present in input." : "is not present in input";
        System.out.println("The sum pair " + message);
    }

    /**
     * The idea is to store the compliment value at each iteration and check if the compliment has already seen previously.
     * Ex: At one store (8-1) = 7 in set and use this in later iterations.
     * @param inputArray
     * @param sum
     * @return
     */
    private static boolean hasPairWithSum(int[] inputArray, int sum) {
        Set<Integer> complimentsSet = new HashSet<>();
        for (int inputNumber : inputArray) {
            int value = sum - inputNumber;
            if (complimentsSet.contains(value))
                return true;
            complimentsSet.add(sum - value);
        }
        return false;
    }
}
