package com.ex.offer;

public class Ex_15_CountDifferInMN {

    /**
     * 计算需要改变m的二进制表示中的多少位才能得到n.
     * @param m
     * @param n
     * @return
     */
    public static int countDiffBetweenMN(int m, int n) {
        int x = m ^ n;   // 1. m ^ n : x中1的个数表示m和n中不同的位数个数
        int count = 0;

        while (x != 0) {
            count++;
            x = (x-1) & x;
        }
        return count;
    }

    public static void main(String[] args) {
        int m = 10;
        int n = 13;

        System.out.println(countDiffBetweenMN(10, 13));
    }
}
