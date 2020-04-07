package Strings;

/**
 * Created by Syril on 08-04-2016.
 */
public class PermutationElem {

    public static void main(String[] args) {
        permutation(new int[]{1, 2, 3}, 0);
    }

    static void permutation(int[] a, int k) {
        if (k == a.length) {
            String number = "";
            for (int num : a) {
                number += num;
            }

            System.out.println(number);

        } else {
            for (int i = k; i < a.length; i++) {
                int temp = a[k];
                a[k] = a[i];
                a[i] = temp;

                permutation(a, k + 1);

                temp = a[k];
                a[k] = a[i];
                a[i] = temp;

            }
        }
    }
}
