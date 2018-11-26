package com.ex.offer;

import java.util.HashMap;

/**
 * problem 3: 数组中重复的数字
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
public class Ex_03_FindDuplicatedNumInArray {

    public boolean duplicate(int numbers[], int [] duplication) {
        if (numbers == null || numbers.length < 2) {
            return false;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (!map.containsKey(numbers[i])) {
                map.put(numbers[i], 1);
            } else {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }

    /**
     * 由于numbers数组中的元素[0,n-1]
     * 若没有重复元素，排序之后i位置为i
     * 若有重复元素，则i位置为i，但是其他位置也可能有i
     * 思路：
     * 遍历数组
     * 若i位置为i,i++
     * 若i位置不是i
     * （1）m = numbers[i], 则m的正确位置为numbers[m], 若numbers[m] = m,则重复元素就是m,否则
     *  (2) 交换m到正确的位置上。
     * @param numbers
     * @param duplication
     * @return
     */
    public boolean duplicateImprove(int numbers[], int [] duplication) {
        if (numbers == null || numbers.length < 2) {
            return false;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == i) {
                i++;
            } else {
                int m = numbers[i];
                if (numbers[m] == m) {
                    duplication[0] = m;
                    return true;
                } else {
                    swap(numbers, i, m);
                }
            }
        }
        return false;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
