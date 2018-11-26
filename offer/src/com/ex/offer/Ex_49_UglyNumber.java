package com.ex.offer;

import org.junit.Test;

public class Ex_49_UglyNumber {
    // 保存所有丑数，同时只检查丑数，不检查非丑数
    public int getUglyNumber(int index) {
        if (index <= 0) {
            return 0;
        }

        int[] uglyNumbers = new int[index];
        uglyNumbers[0] = 1;
        int nextIndex = 1;
        int indexOf2 = 0; // nextIndex之前（包括）最小的索引（*2得到的丑数）
        int indexOf3 = 0;
        int indexOf5 = 0;

        while (nextIndex < index) {
            int nextUgly = min(uglyNumbers[indexOf2] * 2, uglyNumbers[indexOf3] * 3, uglyNumbers[indexOf5] * 5);
            uglyNumbers[nextIndex] = nextUgly;

            while (uglyNumbers[indexOf2] * 2 <= nextUgly) {
                indexOf2++;
            }

            while (uglyNumbers[indexOf3] * 3 <= nextUgly) {
                indexOf3++;
            }

            while (uglyNumbers[indexOf5] * 5 <= nextUgly) {
                indexOf5++;
            }

            nextIndex++;
        }

        return uglyNumbers[index-1];
    }

    private int min(int x, int y, int z) {
        int min = x < y ? x : y;

        return min < z ? min : z;
    }
    // sol 1: 暴力解法
    public int getUglyNumber1(int index) {
        if (index <= 0) {
            return -1;
        }

        int number = 0;
        int uglyCount = 0;

        while (uglyCount < index) {
            number++;
            if (isUgly(number)) {
                uglyCount++;
            }
        }

        return number;
    }
    // 丑数的性质：
    // 若一个数仅能被2, 3, 5整除，那么除去所有的2 3 5 因子，之后应该是1
    // 若一个数是丑数，则这个数的2，3， 5倍都是丑数。
    public boolean isUgly(int number) {
        if (number == 1) {
            return true;
        }

        while (number % 2 == 0) {
            number /= 2;
        }

        while (number % 3 == 0) {
            number /= 3;
        }

        while (number % 5 == 0) {
            number /= 5;
        }

        return number == 1 ? true : false;
    }

    @Test
    public void test() {
        int number = 14;
        System.out.println(getUglyNumber(1500));
        System.out.println(getUglyNumber1(1500));
    }
}
