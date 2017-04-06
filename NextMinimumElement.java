import java.util.Stack;

/**
 * Created by ssadasivan on 31-01-2017.
 */
public class NextMinimumElement {
    public static void main(String[] args) {
        int a[] = {10, 7, 9, 8, 3, 5};
        getNextMinimumElement(a);
    }

    public static void getNextMinimumElement(int[] a) {
        Stack<Integer> s = new Stack<>();
        s.push(a[0]);
        for (int i = 1; i < a.length; i++) {
            while (!s.isEmpty() && s.peek() > a[i]) {
                System.out.println("Next minimum element for "
                        + s.pop() + "\t = " + a[i]);
            }
            s.push(a[i]);
        }
        while (!s.isEmpty() && s.peek() != null) {
            System.out.println("Next minimum element for " + s.pop() + "\t = " + -1);
        }
    }
}
