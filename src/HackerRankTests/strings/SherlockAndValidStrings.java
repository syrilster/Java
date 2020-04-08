package HackerRankTests.strings;

import java.util.HashMap;
import java.util.Map;

public class SherlockAndValidStrings {
    public static void main(String[] args) {
        System.out.println(isValid("abccc"));
    }

    static String isValid(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (int loopIndex = 0; loopIndex < s.length(); loopIndex++) {
            Character inputChar = s.charAt(loopIndex);
            if (charMap.get(inputChar) != null) {
                int charFrequency = charMap.get(inputChar) + 1;
                charMap.put(inputChar, charFrequency);
            } else {
                charMap.put(inputChar, 1);
            }
        }

        int invalidFrequencyCount = (int) charMap.entrySet()
                .stream()
                .filter(x -> x.getValue() % 2 != 0)
                .count();
        return invalidFrequencyCount == 1 ? "YES" : "NO";
    }
}
