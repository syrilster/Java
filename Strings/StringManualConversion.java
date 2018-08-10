package Strings;

import static java.lang.Character.toUpperCase;

/**
 * Have the function LetterChanges(String str) take the str parameter being passed and modify it using the following algorithm.
 * Replace every letter in the string with the letter following it in the alphabet (ie. c becomes d, z becomes a).
 * Then capitalize every vowel in this new string (a, e, i, o, u) and finally return this modified string.
 * <p>
 * Sample Test Cases
 * <p>
 * Input:"hello*3"
 * Output:"Ifmmp*3"
 * <p>
 * Input:"fun times!"
 * Output:"gvO Ujnft!"
 */
public class StringManualConversion {
    public static void main(String[] args) {
        System.out.println(stringChanges("hello*3"));
        System.out.println(stringChanges("fun times!"));
    }

    private static String stringChanges(String inputString) {
        String finalString = "";

        for (int i = 0; i < inputString.length(); i++) {
            char character = inputString.charAt(i);
            int ascii = (int) character;
            //Check if this is char or not. Ignore Special chars
            if ((ascii >= 65 && ascii <= 117) || (ascii >= 97 && ascii <= 122)) {
                character++;
                if (character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u') {
                    character = toUpperCase(character);
                }
            }
            finalString += character;
        }
        return finalString;
    }
}

