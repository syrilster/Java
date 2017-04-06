package Arrays;

import java.util.Stack;

/**
 * @author ssadasivan
 * @since 4/6/2017.
 */
public class NextMaximumElement {
	public static void main(String[] args) {
		int array[] = { 10, 7, 9, 8, 3, 5 };
		getNextMaximumElement(array);
	}

	private static void getNextMaximumElement(int[] array) {
		Stack<Integer> stack = new Stack();
		stack.push(array[0]);
		for (int i = 1; i < array.length; i++) {
			// If item on stack is already lesser than the current element then it needs to be popped
			while (!stack.isEmpty() && stack.peek() < array[i]) {
				System.out.println("Next Max for " + stack.pop() + " is " + array[i]);
			}
			stack.push(array[i]);
		}
		while (!stack.isEmpty() && stack.peek() != null) {
			System.out.println("Next Max for " + stack.pop() + " is " + -1);
		}
	}
}
