package com.github.arrays;

import Arrays.Array0And1;
import org.junit.Test;

public class TestArray0And1 {

    @Test
    public void testArrayContentsInOrder() {
        int[] inputArray = {0, 1, 0, 1, 1, 1, 0, 0};
        Array0And1.segregate0And1(inputArray);
        assert inputArray[1] == 0;
    }

    @Test
    public void testLeftGreaterThanRight() {
        int[] inputArray = {1, 1, 0, 1, 1, 1, 0, 0};
        Array0And1.segregate0And1(inputArray);
        assert inputArray[1] == 0;
    }

    @Test
    public void testLeftEqualToRight() {
        int[] inputArray = {0};
        Array0And1.segregate0And1(inputArray);
        assert inputArray[0] == 0;
    }

    @Test
    public void testAlreadySorted() {
        int[] inputArray = {0, 1};
        Array0And1.segregate0And1(inputArray);
        assert inputArray[0] == 0;
    }
}
