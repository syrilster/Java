package Strings;

import java.util.Arrays;

/**
 * @author ssadasivan
 * @since 3/17/2017.
 */
public class RemoveSpaces {
	public static String removeSpaces(String str) {
		int numSpaces = 0;
		char[] charArray = str.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			//Keep counting the number of spaces
			if (charArray[i] == ' ') {
				numSpaces++;
			} else {
				// Put the ith character in the correct position after removing spaces
				charArray[i - numSpaces] = charArray[i];
			}
		}
		// all the spaces are moved towards the end of the string.
		// Create new string by using non-space characters
		charArray = Arrays.copyOf(charArray, charArray.length - numSpaces);
		return new String(charArray);
	}

	public static void main(String[] args) {
		String strWithSpaces = "       Hi there, how    are you       doing?       ";
		String strWithoutSpaces = removeSpaces(strWithSpaces);
		System.out.println(strWithoutSpaces);
	}
}
