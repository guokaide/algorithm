package com.ex.offer;

import org.junit.Test;

import java.util.ArrayList;

public class Ex_57_FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if (array == null || array.length <= 1) return res;

        int left = 0;
        int right = array.length-1;
        int curSum = 0;
        ArrayList<Integer> leftList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();
        boolean isFound = false;
        while (left < right) {
            curSum = array[left] + array[right];
            if (curSum == sum) {
                leftList.add(left);
                rightList.add(right);
                left++;
                right--;
                isFound = true;
            } else if (curSum < sum) {
                left++;
            } else {
                right--;
            }
        }
        if (!isFound) return res;

        int min = Integer.MAX_VALUE;
        int minLeft = -1;
        int minRight = -1;
        for (int i = 0; i < leftList.size(); i++) {
            int tmp = array[leftList.get(i)] * array[rightList.get(i)];
            if (tmp < min) {
                min = tmp; // 注意修改min的值
                minLeft = leftList.get(i);
                minRight = rightList.get(i);
            }
        }

        if (minLeft != -1) {
            res.add(array[minLeft]);
            res.add(array[minRight]);
        }

        return res;
    }

    @Test
    public void test() {
        int[] array = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        ArrayList<Integer> res = FindNumbersWithSum(array, -1);
        for (Integer i : res) {
            System.out.println(i);
        }
    }
}
