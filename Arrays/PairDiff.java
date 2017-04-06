package Arrays;

import java.util.*;

/**
 * Created by Syril on 04-04-2016.
 */
class pairDiff {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sumDiff = sc.nextInt();
        int[] intVal = new int[n];
        for (int t = 0; t < n; t++) {
            intVal[t] = sc.nextInt();
        }

        if(intVal.length < 2){
            return;
        }

        Arrays.sort(intVal);

        int left = 0;
        int right = intVal.length - 1;
        int pairCount = 0;

        while (left < right) {

            int diff = intVal[right] + intVal[left];
            if (diff > sumDiff) {
                right--;
            } else if (diff < sumDiff) {
                left++;
            } else if (diff == sumDiff) {
                System.out.printf("(%d, %d) %n", intVal[left], intVal[right]);
                pairCount++;
                left++;
                right--;
            }
        }

        System.out.println(pairCount);

    }
}
