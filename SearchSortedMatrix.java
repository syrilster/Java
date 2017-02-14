/**
 * Time Complexity is O(n)
   Space Complexity is O(1)
   Using Stair Search approach
 */
public class SearchSortedMatrix {
	public static void main(String args[]) {
		int[][] mat = { { 2, 6, 7, 11 },
				{ 3, 8, 10, 12 },
				{ 4, 9, 11, 13 },
				{ 5, 15, 16, 18 }
		};
		System.out.println(stairSearch(mat, 4, 5));
	}

	private static boolean stairSearch(int[][] mat, int n, int element) {
		if (element < mat[0][0] || element > mat[n - 1][n - 1])
			return false;
		int row = 0;
		int column = n - 1;
		while (row <= n - 1 && column > 0) {
			if (element < mat[row][column])
				column--;
			if (element > mat[row][column])
				row++;
			return true;
		}
		return false;
	}
}
