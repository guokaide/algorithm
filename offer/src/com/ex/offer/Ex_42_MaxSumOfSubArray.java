package com.ex.offer;

// 此题目类似于：Ex_63_MaxProfits
public class Ex_42_MaxSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length < 1) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int curSum = 0;

        for (int i = 0; i < array.length; i++) {
            curSum += array[i];
            max = Math.max(max, curSum);
            curSum = curSum < 0 ? 0 : curSum;
        }

        return max;
    }
}
