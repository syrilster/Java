package Arrays;

/**
 * Anyone who bribed member (X) cannot get to higher than
 * one position in front if X's original position,
 * so we need to look from one position in front
 * of X's original position to one in front of X's
 * current position, and see how many of those
 * positions in Q contain a number large than X.
 * i.e. look from X-1 to i-1 range to find greater elements.
 */
public class NewYearChaos {

    public static void main(String[] args) {
        int[] queue = {1, 2, 5, 3, 7, 8, 6, 4};
        minimumBribes(queue);
    }

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int bribeCount = 0;
        for (int currentIndex = q.length - 1; currentIndex >= 0; currentIndex--) {
            int memberOriginalIndex = q[currentIndex] - 1;
            int currentMember = q[currentIndex];
            if ((memberOriginalIndex - currentIndex) > 2) {
                System.out.println("Too chaotic");
                return;
            }

            for (int bribeCheckIndex = Math.max(0, (currentMember - 2)); bribeCheckIndex < (currentIndex); bribeCheckIndex++) {
                if (q[bribeCheckIndex] > currentMember)
                    bribeCount++;
            }
        }
        System.out.println(bribeCount);
    }
}
