package Arrays;

/**
 * Created by syrils on 5/26/16.
 */
public class ArrayDiagonal {
    public static void main(String[] args) {
        int array[][] = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        printMatrixDiagonally(array);
    }

    public static void printMatrixDiagonally(int[][] matrix) {
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        int row, col;

        for (int k = 0; k < rowCount; k++) {
            for (row = k, col = 0; row >= 0 && col < colCount; row--, col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

        for (int k = 1; k < colCount; k++) {
            for (row = rowCount - 1, col = k; row >= 0 && col < colCount; row--, col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
