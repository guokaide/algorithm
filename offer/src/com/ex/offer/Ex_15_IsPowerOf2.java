package com.ex.offer;

public class Ex_15_IsPowerOf2 {

    /**
     * 判断1个数是否是2的整数次幂，例如2 4 8 ...
     * 特点：若一个数是2的整数此幂，则这个数的二进制只有一个1
     * (n-1) & n 将n中最右边的一个1变成了0
     * @param n
     * @return
     */
    public static boolean isPowerOf2(int n) {
        if (n < 2) {
            return false;
        }

        n = (n - 1) & n;

        if (n == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int n = 100;
        for (int i = 0; i <= n; i++) {
            if (isPowerOf2(i))
                System.out.println(i);
        }
    }
}
