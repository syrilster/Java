package Arrays;

/**
 * Write a function which return true if the given input array can be modified once(and only once) to make it sorted in ascending order.
 * Ex: [1, 2, 3, 1] return true as modifying the last element 1 to 5 will make it sorted.
 * [1, 2, 4, 4, 1, 2] return false as this array requires more than one modification to make it sorted.
 */
public class FindIfInputCanBeSortedWithOneModification {
    public static void main(String[] args) {
        int[] inputArray = new int[]{1, 2, 4, 4, -1, 4, 6};
        String outcome = canArrayBeSortedWithOneModification(inputArray) ? "can" : "can't";
        System.out.println("The Given input array " + outcome + " be sorted with one modification");
    }

    private static boolean canArrayBeSortedWithOneModification(int[] inputArray) {
        int greatestSeen = inputArray[0];
        int modCount = 1;
        for (int loopIndex = 1; loopIndex <= inputArray.length - 1; loopIndex++) {
            if (modCount >= 0) {
                if (inputArray[loopIndex] >= greatestSeen) {
                    greatestSeen = inputArray[loopIndex];
                } else {
                    modCount--;
                }
            } else {
                return false;
            }
        }
        return modCount >= 0;
    }
}
