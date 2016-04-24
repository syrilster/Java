import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Syril on 30-03-2016.
 */
public class URLShorterTest {

    static String hash62BaseEncoding(int number) {
        int remainder = 0;
        int hashCount = 0;
        int i = 0;
        String hashString = "";
        List<Integer> digits = new ArrayList<>();
        String[] base62String = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q",
                "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P",
                "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

        while (number > 0) {
            remainder = number % 62;
            digits.add(remainder);
            number = number / 62;
        }

        Collections.reverse(digits);
        hashCount = digits.size();

        while (hashCount > i) {
            hashString += base62String[digits.get(i)];
            i++;
        }

        return hashString;
    }

    public static void main(String[] args) {
        System.out.println(hash62BaseEncoding(125));
    }
}
