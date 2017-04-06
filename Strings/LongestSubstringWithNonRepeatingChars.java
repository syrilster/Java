package Strings;

/**
 * @author ssadasivan
 * @since 3/17/2017.
 */
public class LongestSubstringWithNonRepeatingChars {
	public static String getLongestSubstringNonRepeatingChars(String str) {
		if (str == null) {
			return null;
		}
		int n = str.length();
		if (n < 2) {
			return str;
		}
		// array to store last index of string characters seen in the string, initialized to -1
		int[] visited = new int[256];
		for (int i = 0; i < 256; i++) {
			visited[i] = -1;
		}
		// Set index of first character
		visited[str.charAt(0)] = 0;
		int prev_index = 0;
		int cur_len = 1;
		int max_len = 1;
		int startIndex = 0;
		for (int i = 1; i < n; i++) {
			prev_index = visited[str.charAt(i)];
			if (prev_index == -1 || i - cur_len > prev_index) {
				cur_len++;
			} else {
				if (cur_len > max_len) {
					max_len = cur_len;
					startIndex = i - max_len;
				}
				cur_len = i - prev_index;
			}
			visited[str.charAt(i)] = i;
		}

		// Check if longest substring with non repeating characters ends at end of the string
		if(cur_len > max_len) {
			cur_len = max_len;
			startIndex = n - max_len;
		}
		return str.substring(startIndex, startIndex + max_len);
	}

	public static void main(String[] args) {
		String str = "AAAABCD";
		/*String longestSubstring = getLongestSubstringNonRepeatingCharsNaive(str);
		System.out.println("Longest substring non repeating chars by Naive method:\t\t" + longestSubstring);*/
		String longestSubstring = getLongestSubstringNonRepeatingChars(str);
		System.out.println("Longest substring non repeating chars by linear time method:\t" + longestSubstring);
	}
}
