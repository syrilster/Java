package Strings;

/**
 * @author ssadasivan
 * @since 3/16/2017.
 * Step 1. Reverse each word.
 * Step 2. Reverse the whole string.
 */
public class ReverseWords {
	public static void main(String[] args) {
		char[] str = "This is a string".toCharArray();
		getReverse(str);
		System.out.println(str);
	}

	private static void getReverse(char[] str) {
		int length = str.length;
		int start = 0;
		for (int i = 0; i < length; i++) {
			//Skip the char until a space occurs. Once you get the space send the whole word for reverse and then update the start counter
			if (str[i] == ' ' && i > 0) {
				reverse(str, start, i - 1);
				start = i + 1;
			} else if (i == length - 1) {
				//This is to handle the last word
				reverse(str, start, i);
			}
		}
		//Reverse the whole string
		reverse(str, 0, length - 1);
	}

	private static void reverse(char[] str, int start, int end) {
		while (start < end) {
			swap(str, start, end);
			start++;
			end--;
		}
	}

	private static void swap(char[] str, int start, int end) {
		char temp = str[start];
		str[start] = str[end];
		str[end] = temp;
	}
}
