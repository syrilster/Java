package Strings;

import java.io.IOException;
import java.util.Stack;

/**
 * Created by Syril on 04-04-2016.
 */
public class ParenBalancer {

    public static void main(String[] args) throws IOException {
        String[] res = Braces(new String[]{"()", ")"});
    }

    static String[] Braces(String[] values) {
        String[] output = new String[100];
        int k = 0;
        for (int i = 0; i < values.length - 1; i++) {
            Stack<Character> stack = new Stack();
            String input = values[i];
            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(j) == '(' || input.charAt(j) == '[' || input.charAt(j) == '{')
                    stack.push(input.charAt(j));
                else if (input.charAt(j) == ')' || input.charAt(j) == ']' || input.charAt(j) == '}') {
                    if (!stack.isEmpty()) {
                        switch (input.charAt(j)) {
                            case ')':
                                if (stack.pop() == '(') {
                                    output[k++] = "YES";
                                }
                                break;
                            case ']':
                                if (stack.pop() == '[') {
                                    output[k++] = "YES";
                                }
                                break;
                            case '}':
                                if (stack.pop() == '{') {
                                    output[k++] = "YES";
                                }

                                break;
                        }
                    }
                }
            }
            if (stack.isEmpty())
                output[k++] = "NO";
        }
        return output;
    }
}

