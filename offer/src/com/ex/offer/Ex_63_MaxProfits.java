package com.ex.offer;

import org.junit.Test;

// 此题目类似于Ex_42_MaxSumOfSubArray
public class Ex_63_MaxProfits {
    public int maxProfits(int[] prices) {
        if (prices == null || prices.length < 2) {
            return -1;
        }

        int minPrice = prices[0]; // i之前[0,i-1]的最小值，控制左侧
        int maxDiff = prices[1] - minPrice; // 控制右侧，遍历了所有可能最大差值

        for (int i = 2; i < prices.length; i++) {
            int curDiff = prices[i] - minPrice;

            if (curDiff > maxDiff) {
                maxDiff = curDiff;
            }

            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
        }

        return maxDiff;
    }

    @Test
    public void test() {
        int[] prices = new int[] {9,11,8,5,7,12,16,14};
        System.out.println(maxProfits(prices));
    }
}
