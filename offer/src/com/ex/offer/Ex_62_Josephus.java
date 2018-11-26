package com.ex.offer;

import org.junit.Test;

import java.util.ArrayList;

// 约瑟夫问题其实是一个环型链表
// 假设 n > m, 则第一个要删除的位置是 index = m-1, 第二个是 (index + m) % size
// 每次要删除的位置是 (lastIndex + m) % size;
public class Ex_62_Josephus {
    public int LastRemaining_Solution(int n, int m) {
        if (n <= 0 || m <= 0) {
            return -1;
        }

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int index = -1;

        while (list.size() > 1) {
            index = (index + m) % list.size();
            list.remove(index);
            index--;
        }

        return list.get(0);
    }

    /**
     * f(n, m) = [f(n-1, m) + m] % n (n > 1)
     *
     * @param n
     * @param m
     * @return
     */
    public int LastRemaining_Solution1(int n, int m) {
        if (n <= 0 || m <= 0) {
            return -1;
        }

        int lastRemain = 0;
        for (int i = 2; i <= n; i++) {
            lastRemain = (lastRemain + m) % i;
        }
        return lastRemain;
    }
    @Test
    public void test() {
        System.out.println(LastRemaining_Solution(5, 3));
        System.out.println(LastRemaining_Solution1(5, 3));
    }
}
