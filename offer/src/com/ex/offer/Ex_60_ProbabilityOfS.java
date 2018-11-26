package com.ex.offer;

import org.junit.Test;

// https://www.cnblogs.com/keedor/p/4474471.html
// https://www.cnblogs.com/AndyJee/p/4686208.html
public class Ex_60_ProbabilityOfS {
    private static final int MAX_VALUE = 6; // 骰子的最大点数

    // probability(n, currentLeft, currentSum, sum)
    public void printProbability_1(int number) {
        if (number < 1) {
            return;
        }

        int maxSum = number * MAX_VALUE;
        int[] sums = new int[maxSum-number + 1];

        for (int i = 0; i < sums.length; i++) {
            sums[i] = 0;
        }

        probability(number, sums);

        double total = Math.pow(MAX_VALUE, number);
        for (int i = 0; i < sums.length; i++) {
            System.out.println(sums[i]/total);
        }
    }

    private void probability(int number, int[] sums) {
        for(int i = 1; i <= MAX_VALUE; i++) {
            probability(number, number - 1, i, sums);
        }
    }

    /**
     * @param number : 总共几个骰子
     * @param current：现在剩下几个骰子
     * @param sum：现在已有的和
     * @param sums
     */
    private void probability(int number, int current, int sum, int[] sums) {
        if (current == 0) {
            sums[sum - number]++;
            return;
        }
        for (int i = 1; i <= MAX_VALUE; i++) {
            probability(number, current-1, sum + i, sums);
        }
    }

    /**
     *
     * k:骰子个数
     * n:点数和
     * f(k, n) = f(k-1, n-1) + f(k-1, n-2) + f(k-1, n-3) + f(k-1, n-4) + f(k-1, n-5) + f(k-1, n-6);
     * f(k-1, n-1):表示第k-1个骰子投了n-1点，则第k个骰子投1个点就可以得到n
     * f(n) = f(n-1) + f(n-2) + f(n-3) + f(n-4) + f(n-5) + f(n-6)
     * @param number
     */
    public void printProbability_2(int number) {
        if (number < 1) {
            return;
        }

        /**
         * 我们需要将中间值存起来以减少递归过程中的重复计算问题，可以考虑我们用两个数组AB，
         * A在B之上得到，B又在A之上再次得到，这样AB互相作为对方的中间值，
         * 其实这个思想跟斐波拉契迭代算法中用中间变量保存n-1，n-2的值有异曲同工之妙
         */
        int[][] sums = new int[2][MAX_VALUE * number + 1]; // [1,number]

        int flag = 0;
        // 抛掷第一枚骰子 [1,2,3,...,MAX_VALUE]
        for (int i = 1; i <= MAX_VALUE; i++) {
            sums[flag][i] = 1;
        }

        // 第二次抛掷骰子开始
        for (int k = 2; k <= number; k++) {
            // 第k次掷色子,和最小为k,和最大为MAX_VALUE * k
            for (int i = k; i <= MAX_VALUE * k; i++) {
                int temp = 0;
                for (int j = 1; j <= i && j <= MAX_VALUE; j++) { // j<=i,防止数组越界
                    temp += sums[flag][i-j];
                }
                sums[1-flag][i] = temp;
            }
            flag = 1- flag;
        }

        double total = Math.pow(MAX_VALUE, number);
        for (int i = number; i < sums[flag].length; i++) {
            System.out.println(sums[flag][i]/total);
        }
    }

    @Test
    public void test1() {
        printProbability_1(2);
        System.out.println();
    }

    @Test
    public void test2() {
        printProbability_2(2);
    }

}
