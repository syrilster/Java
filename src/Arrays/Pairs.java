package Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://www.hackerrank.com/challenges/pairs/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=search
 */
public class Pairs {
    public static void main(String[] args) {
        int[] input = new int[]{1, 5, 3, 4, 2};
        int target = 3;
        System.out.println("Pair count is " + pairs(target, input));
    }

    static int pairs(int targetPairDiff, int[] arr) {
        Set<Integer> inputSeenSoFar = new HashSet<>();
        Arrays.sort(arr);
        int pairCount = 0;
        for (int loopIndex = 0; loopIndex < arr.length; loopIndex++) {
            int currentElement = arr[loopIndex];
            int diff = Math.abs(currentElement - targetPairDiff);
            if (currentElement > targetPairDiff) {
                if (inputSeenSoFar.contains(diff))
                    pairCount++;
            }
            inputSeenSoFar.add(arr[loopIndex]);

        }
        return pairCount;
    }
}
