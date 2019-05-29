package Arrays;

/**
 * @author ssadasivan
 * @since 2/15/2017.
 */
public class BuySellStocks {
	public static void main(String args[]) {
		int[] stockPrices = { 100, 125, 120, 130, 70, 60, 10, 8 };
		System.out.println("maximum profit that could be obtained is: " + maximumProfit(stockPrices));
	}

	private static int maximumProfit(int[] input) {
		int profit = 0;
		int minElement = input[0];
		for (int i = 1; i < input.length; i++) {
			profit = Math.max((input[i] - minElement), profit);
			minElement = Math.min(minElement, input[i]);
		}
		return profit;
	}
}
