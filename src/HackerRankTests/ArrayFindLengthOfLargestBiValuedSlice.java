package HackerRankTests;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array [5, 4, 4, 5, 0, 12] find the length of the largest bi-valued slice. A bi-valued slice is one having only 2 distinct
 * numbers. In the above example it is [5, 4, 4, 5], [0, 12], [5, 4, 4]. The longest length is 4
 */
public class ArrayFindLengthOfLargestBiValuedSlice {
    public static void main(String[] args) {
        int[] input = new int[]{5, 4, 4, 5, 0, 12};
        System.out.println(solution(input));
    }

    private static int solution(int[] A) {
        Map<Integer, Integer> sliceHashMap = new HashMap<>();
        int biValueNumberCount = 0;
        int biValueSliceIndex = 0;
        int largestBiValueSliceLength = 0;
        boolean firstChunk = true;
        for (int i = 0; i < A.length; i++) {

            if (sliceHashMap.containsKey(A[i])) {
                sliceHashMap.put(A[i], sliceHashMap.get(A[i]) + 1);
            } else {
                biValueNumberCount++;
                sliceHashMap.put(A[i], 1);
            }

            if (biValueNumberCount > 2 || (biValueNumberCount == 2 && i == A.length - 1)) {
                if (i == A.length - 1)
                    firstChunk = false;
                biValueSliceIndex = firstChunk ? (i - biValueSliceIndex) : (i - biValueSliceIndex) + 1;
                largestBiValueSliceLength = Math.max(biValueSliceIndex, largestBiValueSliceLength);
                biValueNumberCount = 1;
                firstChunk = false;

            }

        }
        return largestBiValueSliceLength;
    }
}
