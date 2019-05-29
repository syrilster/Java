package JavaOptimization;

/**
 * Created by Syril on 13-05-2018.
 */
public class MicroBenchmarking {
    public static void main(String[] args) {
        double l;
        long then = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            l = fibImpl(10);
        }
        long now = System.currentTimeMillis();
        System.out.println("Elapsed Time: " + (now - then));
    }

    private static double fibImpl(int n) {
        if (n < 0) throw new IllegalArgumentException("Must be > 0");
        if (n == 1) return 0;
        if (n == 2) return 1;
        double fibonacciResult = fibImpl(n - 2) + fibImpl(n - 1);
        if (Double.isInfinite(fibonacciResult)) throw new ArithmeticException("Overflow");
        return fibonacciResult;
    }
}
