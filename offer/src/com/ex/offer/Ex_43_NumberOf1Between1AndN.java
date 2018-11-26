package com.ex.offer;

//https://www.cnblogs.com/xuanxufeng/p/6854105.html
public class Ex_43_NumberOf1Between1AndN {
    public int NumberOf1Between1AndN_Solution1(int n) {
        if (n < 1) {
            return 0;
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            count += numberOf1(i);
        }

        return count;
    }

    private int numberOf1(int num) {
        int count = 0;
        while (num != 0) {
            if (num % 10 == 1) {
                count++;
            }
            num = num / 10;
        }

        return count;
    }

    public int NumberOf1Between1AndN_Solution(int n) {
        int ones = 0; // ones:1的个数
        // m:分别指的是个位，十位，百位...，即：10 100 1000 ... m是在以10倍增长，因此可能超过int型，变成long
        // 分别按照个位十位百位统计各个位子上的个数
        for (long m = 1; m <= n; m *= 10) {
            //a = n / m;   // n的高位
            //b = n % m;   // n的低位
            ones += (n/m + 8) / 10 * m + (n/m % 10 == 1 ? n%m + 1 : 0);
        }

        return ones;
    }


}
