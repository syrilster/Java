package Arrays;

import java.util.Stack;

/**
 * @author ssadasivan
 * @since 4/6/2017.
 */
public class NextMaximumElement {
	public static void main(String[] args) {
		int[] array = {10, 7, 9, 8, 3, 5};
		getNextMaximumElement(array);
	}

	private static void getNextMaximumElement(int[] array) {
		Stack<Integer> stack = new Stack<>();
		stack.push(array[0]);
		for (int loopIndex = 1; loopIndex < array.length; loopIndex++) {
			// If item on stack is already lesser than the current element then it needs to be popped
			int currentElement = array[loopIndex];
			while (!stack.isEmpty() && (currentElement > stack.peek())) {
				System.out.println("Next Max for " + stack.pop() + " is " + currentElement);
			}
			stack.push(currentElement);
		}
		while (!stack.isEmpty() && stack.peek() != null) {
			System.out.println("Next Max for " + stack.pop() + " is " + -1);
		}
	}
}
