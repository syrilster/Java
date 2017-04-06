/**
 * @author ssadasivan
 * @since 3/23/2017.
 */
public class MaxMoney {
	static int maxMoney(int n, long k) {
		int totalSum = 0;
		for (int i = 1; i <= n; i++) {
			totalSum += i;
		}
		return totalSum;
	}

	public static void main(String[] args) {
		System.out.println(maxMoney(3, 3));
	}
}
