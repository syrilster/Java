package Strings;

import java.util.*;

/**
 * Created by Syril on 21-05-2016.
 */
public class StringCompression {
    public static void main(String[] args) {
        System.out.println(compress("!!!3333"));
    }

    static String compress(String input) {
        if (input.isEmpty()) {
            return "";
        }

        char[] chars = input.toCharArray();
        StringBuilder outputBuilder = new StringBuilder();

        int count = 1;
        char previous = chars[0];
        for (int i = 1; i < chars.length; i++) {
            char current = chars[i];
            if (current == previous) {
                count++;
            } else {
                appendOutputBasedOnCount(count, previous, outputBuilder);
                count = 1;
            }
            previous = current;
        }

        return appendOutputBasedOnCount(count, previous, outputBuilder);

    }

    private static String appendOutputBasedOnCount(int count, char input, StringBuilder outputBuilder) {
        if (count == 1) {
            outputBuilder.append(input);
        } else {
            outputBuilder.append(count).append(input);
        }
        return outputBuilder.toString();
    }

}




