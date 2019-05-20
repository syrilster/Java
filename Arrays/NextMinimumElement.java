package Arrays;

import java.util.Stack;

/**
 * Created by ssadasivan on 31-01-2017.
 */
public class NextMinimumElement {
    public static void main(String[] args) {
        int a[] = {10, 7, 9, 8, 3, 5};
        getNextMinimumElement(a);
    }

    private static void getNextMinimumElement(int[] inputArray) {
        Stack<Integer> stack = new Stack<>();
        stack.push(inputArray[0]);
        for (int loopIndex = 1; loopIndex < inputArray.length; loopIndex++) {
            int currentElement = inputArray[loopIndex];
            while (!stack.isEmpty() && (currentElement < stack.peek())) {
                System.out.println("Next minimum element for "
                        + stack.pop() + "\t = " + currentElement);
            }
            stack.push(currentElement);
        }
        while (!stack.isEmpty() && stack.peek() != null) {
            System.out.println("Next minimum element for " + stack.pop() + "\t = " + -1);
        }
    }
}
