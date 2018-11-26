package com.ex.offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

public class Ex_59_MaxNumOfSlidingWindow {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> res = new ArrayList<>();

        if (num == null || num.length <= 0 || size <= 0 || size > num.length) {
            return res;
        }

        LinkedList<Integer> qMax = new LinkedList<>();  // 双端队列：左端更新max,右端添加数据

        int left = 0;

        for (int right = 0; right < num.length; right++) {
            // 更新右端数据
            while (!qMax.isEmpty() && num[qMax.peekLast()] <= num[right]) {
                qMax.pollLast();
            }

            qMax.addLast(right);

            // 更新max：如果max的索引不在窗口内,则更新
            if (qMax.peekFirst() == right - size) {
                qMax.pollFirst();
            }

            // 待窗口达到size，输出max
            if (right >= size-1) {
                res.add(num[qMax.peekFirst()]);
                left++;
            }
        }

        return res;
    }

    @Test
    public void test() {
        int[] num = new int[] {2,3,4,2,6,2,5,1};
        int size = 3;
        ArrayList<Integer> list = maxInWindows(num, size);
        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }

}
