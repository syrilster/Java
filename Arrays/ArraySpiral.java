package Arrays;

/**
 * Created by syrils on 5/31/16.
 */
public class ArraySpiral {

    public static void main(String[] args) {
        int array[][] = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        printSpiral(array, 3, 3);
    }

    private static void printSpiral(int[][] array, int row, int column) {
        int top = 0, bottom = row - 1, left = 0, right = column - 1;
        int direction = 0;
        while (top <= bottom && left <= right) {
            if (direction == 0) {
                for (int i = left; i <= right; i++)
                    System.out.print(array[top][i] + " ");
                top++;
            } else if (direction == 1) {
                for (int i = top; i <= bottom; i++)
                    System.out.print(array[i][right] + " ");
                right--;
            } else if (direction == 2) {
                for (int i = right; i >= left; i--)
                    System.out.print(array[bottom][i] + " ");
                bottom--;
            } else {
                for (int i = bottom; i >= top; i--)
                    System.out.print(array[i][left] + " ");
                left++;
            }
            direction = (direction + 1) % 4;

        }
    }
}
