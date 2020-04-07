package Strings;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class StringDecoding {
    static Map<Character, String> lookupMap = populateLookupMap();

    public static void main(String[] args) {
        Assert.assertEquals(decodeString("aabccc"), "1[2]23[3]");
        Assert.assertEquals(decodeString("abzx"), "1226&24&");
        Assert.assertEquals(decodeString("bajj"), "210#[2]");
        Assert.assertEquals(decodeString("wwxyzwww"), "23&[2]24&25&26&23&[3]");
    }

    static String decodeString(String input) {
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
            outputBuilder.append(lookupMap.get(input));
        } else {
            outputBuilder.append(lookupMap.get(input)).append("[").append(count).append("]");
        }
        return outputBuilder.toString();
    }

    static Map<Character, String> populateLookupMap() {
        HashMap<Character, String> lookupMap = new HashMap<>();
        lookupMap.put('a', "1");
        lookupMap.put('b', "2");
        lookupMap.put('c', "3");
        lookupMap.put('d', "4");
        lookupMap.put('e', "5");
        lookupMap.put('f', "6");
        lookupMap.put('g', "7");
        lookupMap.put('h', "8");
        lookupMap.put('i', "9");
        lookupMap.put('j', "0#");
        lookupMap.put('k', "1#");
        lookupMap.put('l', "2#");
        lookupMap.put('m', "3#");
        lookupMap.put('n', "4#");
        lookupMap.put('o', "5#");
        lookupMap.put('p', "6#");
        lookupMap.put('q', "7#");
        lookupMap.put('r', "8#");
        lookupMap.put('s', "9#");
        lookupMap.put('t', "20&");
        lookupMap.put('u', "21&");
        lookupMap.put('v', "22&");
        lookupMap.put('w', "23&");
        lookupMap.put('x', "24&");
        lookupMap.put('y', "25&");
        lookupMap.put('z', "26&");
        return lookupMap;
    }
}
