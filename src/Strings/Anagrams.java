package Strings;

import java.util.Scanner;

/**
 * Created by Syril on 06-04-2016.
 * An anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once. For example, the word anagram can be
 * rearranged into "naga ram"
 */
public class Anagrams {

    /**
     * 1. Create an array of size 256 initialized with 0′s.
     * 2. For first string increment count of character in count array.
     * 3. For second string decrement the count of character from count array.
     * 4. Repeat steps 2 and 3 till we reach end of any string.
     * 5. Check if array contains only zero then strings are anagram otherwise not.
     * @param stringOne
     * @param stringTwo
     * @return
     */
    static boolean isAnagram(String stringOne, String stringTwo) {

        char allChars[] = new char[256];

        stringOne = stringOne.toLowerCase();
        stringTwo = stringTwo.toLowerCase();

        for (int i = 0; i < stringOne.length(); i++) {
            allChars[stringOne.charAt(i)]++;
        }

        for (int j = 0; j < stringTwo.length(); j++) {
            allChars[stringTwo.charAt(j)]--;
        }

        for (int k = 0; k < 256; k++) {
            if (allChars[k] != 0)
                return false;
        }
        return true;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        boolean ret = isAnagram(A, B);
        if (ret) System.out.println("Given Strings are Anagrams");
        else System.out.println("Given Strings are Not Anagrams");

    }
}
