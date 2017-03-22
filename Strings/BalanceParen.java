package Strings;

import java.util.Stack;

/**
 *Given an expression string exp ,
 * write a program to examine whether the pairs and the orders of “{“,”}”,”(“,”)”,”[“,”]” are correct in exp. For example, the program should print true for exp = “[()]{}{[()()]()}” and false for exp = “[(])”
 *
 * @author ssadasivan
 * @since 3/22/2017.
 */
public class BalanceParen {
	public static void main(String[] args) {
		String str = "[()]{}{[()()]()}";
		System.out.println("isValid: " + isValid(str));
	}

	private static boolean isValid(String str) {
		Stack<Character> stack = new Stack<>();
		char[] charArray = str.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			char character = charArray[i];
			switch (character) {
				case '(':
				case '[':
				case '{':
					stack.push(character);
					break;
			}
			if (character == ')' || character == ']' || character == '}') {
				if (stack.isEmpty())
					return false;
				else if (!isMatchingPair(stack.pop(), character)) {
					return false;
				}
			}
		}
		//To check for extra paren like ())
		if(!stack.isEmpty())
			return false;
		return true;
	}

	private static boolean isMatchingPair(char character1, Character character2) {
		if (character1 == '(' && character2 == ')')
			return true;
		else if (character1 == '[' && character2 == ']')
			return true;
		else if (character1 == '{' && character2 == '}')
			return true;
		else
			return false;
	}
}
