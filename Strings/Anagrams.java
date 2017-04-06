package Strings;

import com.sun.prism.shader.Solid_TextureYV12_Loader;

import java.util.Scanner;

/**
 * Created by Syril on 06-04-2016.
 */
public class Anagrams {

    static boolean isAnagram(String s1, String s2) {

        char allChars[] = new char[256];

        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        for (int i = 0; i < s1.length(); i++) {
            allChars[s1.charAt(i)]++;
        }

        for (int j = 0; j < s2.length(); j++) {
            allChars[s2.charAt(j)]--;
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
        if (ret) System.out.println("Strings.Anagrams");
        else System.out.println("Not Strings.Anagrams");

    }
}
