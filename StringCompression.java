import java.util.*;

/**
 * Created by Syril on 21-05-2016.
 */
public class StringCompression {
    public static void main(String[] args) {
        System.out.println(compress("aabbbccaaa"));
    }

    static String compress(String str) {
        if (str.isEmpty()) {
            return "";
        }

        char[] chars = str.toCharArray();
        StringBuilder builder = new StringBuilder();

        int count = 1;
        char prev = chars[0];
        for (int i = 1; i < chars.length; i++) {
            char current = chars[i];
            if (current == prev) {
                count++;
            } else {
                builder.append(prev).append(count);
                count = 1;
            }
            prev = current;
        }

        String compressedString = builder.append(prev).append(count).toString();

        return compressedString.length() > str.length() ? str : compressedString;

    }

}




