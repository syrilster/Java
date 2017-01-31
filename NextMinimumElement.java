import java.util.Stack;

/**
 * Created by ssadasivan on 31-01-2017.
 */
public class NextMinimumElement {
    public static void main(String[] args) {
        int a[] = {4,2,1,5,3};
        getNGE(a);
    }
    public static void getNGE(int[] a) {
        Stack<Integer> s = new Stack<>();
        s.push(a[0]);
        for (int i = 1; i < a.length; i++) {
            if (s.peek() != null) {
                while (true) {
                    if (s.isEmpty() || s.peek() < a[i]) {
                        break;
                    }
                    if (!s.isEmpty()) System.out.println(s.pop() + ":" + a[i]);
                }
            }
            s.push(a[i]);
        }
        while (!s.isEmpty() && s.peek() != null) {
            System.out.println(s.pop() + ":" + -1);
        }
    }
}
