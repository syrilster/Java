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

    public static void printSpiral(int[][] array, int row, int col) {
        int t = 0, b = row - 1, l = 0, r = col - 1;
        int dir = 0;
        while (t <= b && l <= r) {
            if (dir == 0) {
                for (int i = l; i <= r; i++)
                    System.out.print(array[t][i] + " ");
                t++;
            } else if (dir == 1) {
                for (int i = t; i <= b; i++)
                    System.out.print(array[i][r] + " ");
                r--;
            } else if (dir == 2) {
                for (int i = r; i >= l; i--)
                    System.out.print(array[b][i] + " ");
                b--;
            } else {
                for (int i = b; i >= t; i--)
                    System.out.print(array[i][l] + " ");
                l++;
            }
            dir = (dir + 1) % 4;

        }
    }
}
