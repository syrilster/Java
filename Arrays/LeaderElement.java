package Arrays;

/**
 * @author ssadasivan
 * @since 4/1/2017.
 */
public class LeaderElement {
	public static void main(String[] args) {
		int[] input = { 98, 23, 54, 12, 20, 7, 27 };
		printLeaders(input);
	}

	private static void printLeaders(int[] input) {
		int currentLeader = 0;
		for (int i = input.length - 1; i >= 0; i--) {
			if (input[i] > currentLeader) {
				currentLeader = input[i];
				System.out.print(input[i] + " ");
			}
		}
	}
}
