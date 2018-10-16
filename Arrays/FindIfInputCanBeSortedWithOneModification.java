package Arrays;

public class FindIfInputCanBeSortedWithOneModification {
    public static void main(String[] args) {
        int[] inputArray = new int[]{1, 2, 4, 1, 7};
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
