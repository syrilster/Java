package HackerRankTests.strings;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * Input: string = “azjskfzts”, pattern = “sz”
 * Output: Minimum window is “zjs” i.e 3
 * Algo insights:
 * 1. Start with two pointers, left and right initially pointing to the first element of the string inputString.
 * 2. Use the right pointer to expand the window until we get a desirable window i.e. a window that contains all of the characters of pattern.
 * 3. Once we have a window with all the characters, we can move the left pointer ahead one by one. If the window is still a desirable one we keep on updating the minimum window size.
 * 4. If the window is not desirable any more, we repeat step 2 onwards.
 */
public class MinimumWindowSubString {
    public static void main(String[] args) { ;
        Assert.assertEquals(minimumWindowSubString("this is a test string", "tist"), "t stri");
        Assert.assertEquals(minimumWindowSubString("geeksforgeeks", "ork"), "ksfor");
        Assert.assertEquals(minimumWindowSubString("azjskfzts", "sz"), "zjs");
        Assert.assertEquals(minimumWindowSubString("aaaaaaaaaaaabbbbbcdd", "abcdd"), "abbbbbcdd");
        Assert.assertEquals(minimumWindowSubString("aaaaaaaaaaaabbbbbcdd", "sz"), "");
    }

    static String minimumWindowSubString(String input, String pattern) {
        Map<Character, Integer> hashPattern = new HashMap<>();
        for(char c : pattern.toCharArray()) {
            hashPattern.compute(c, (key, value) -> value == null ? 1 : ++value);
        }

        Map<Character, Integer> hashInput = new HashMap<>();
        String windowSubString = "";
        String minSubString = "";
        int leftPtr = 0;
        int rightPtr = 0;
        int matched = 0;

        while(leftPtr < input.length()) {
            Character currentChar;
            while(rightPtr < input.length() && matched < hashPattern.size()) {
                currentChar = input.charAt(rightPtr++);
                hashInput.compute(currentChar, (key, value) -> value == null ? 1 : ++value);
                windowSubString += currentChar;

                if (hashPattern.containsKey(currentChar) && hashPattern.get(currentChar).equals(hashInput.get(currentChar))) matched++;
            }

            if (matched == hashPattern.size() && (minSubString.equals("") || windowSubString.length() < minSubString.length())){
                minSubString = windowSubString;
            }

            currentChar = windowSubString.charAt(0);
            hashInput.compute(currentChar, (key, value) -> --value);
            if (hashPattern.containsKey(currentChar) && hashPattern.get(currentChar) > hashInput.get(currentChar)) matched--;
            windowSubString = windowSubString.substring(1);
            leftPtr++;
        }

        return minSubString;
    }
}
