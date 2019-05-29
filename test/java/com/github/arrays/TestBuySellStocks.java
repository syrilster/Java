package com.github.arrays;

import Arrays.BuySellStocks;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestBuySellStocks {

    @Test
    public void testBasicBuySellScenario() {
        int[] stockPrices = {100, 125, 120, 130, 70, 60, 10, 8};
        int maxProfit = BuySellStocks.maximumProfit(stockPrices);
        assertEquals(30, maxProfit);
    }
}
