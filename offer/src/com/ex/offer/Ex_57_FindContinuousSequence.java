package com.ex.offer;

import org.junit.Test;

import java.util.ArrayList;

public class Ex_57_FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (sum < 3) {
            return res;
        }

        int small = 1;
        int big = 2;
        int mid = (sum + 1) / 2;
        int curSum = small+big;

        while (small < mid) {
            if (curSum == sum) {
                res.add(new ArrayList<>(full(small, big))); // 一定要注意这里，要拷贝构造，不能直接传入引用
            }

            while (curSum > sum && small < mid) {
                curSum -= small;
                small++;
                if (curSum == sum) {
                    res.add(new ArrayList<>(full(small, big)));
                }
            }
            big++;
            curSum+=big;
        }
        return res;
    }

    private ArrayList<Integer> full(int small, int big) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = small; i <= big; i++) {
            list.add(i);
        }
        return list;
    }

    @Test
    public void test() {
        ArrayList<ArrayList<Integer>> list = FindContinuousSequence(15);
        for (ArrayList<Integer> x : list) {
            for (Integer i : x) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
