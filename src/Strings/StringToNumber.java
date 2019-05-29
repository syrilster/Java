package Strings;

/**
 * Created by Syril on 24-04-2016.
 */
public class StringToNumber {

    public static void main(String[] args) {
        System.out.print(getNumberFromString("-123"));
    }

    /**
     * This works primarily because the characters 0-9 have consecutive ascii values, so subtracting '0' from
     * any of them gives you the offset from the character '0', which is of course the numeric equivalent of the character.
     * The multiplication by 10 and addition is just building up the number as you go.
     **/

    static int getNumberFromString(String s) {
        if (s == null) {
            throw new NumberFormatException("null");
        }
        int result = 0;
        int startIndex = 0;
        int length = s.length();
        boolean negative = false;
        char firstChar = s.charAt(0);
        if (firstChar == '-') {
            negative = true;
            startIndex = 1;
        }

        for (int i = startIndex; i < length; i++) {
            char num = s.charAt(i);
            result = result * 10 + num - '0';
        }

        return negative ? -result : result;
    }
}
