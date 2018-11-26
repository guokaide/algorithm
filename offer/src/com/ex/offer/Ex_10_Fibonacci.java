package com.ex.offer;

public class Ex_10_Fibonacci {

    public static int fib1(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return  fib1(n-1) + fib1(n-2);
    }

    /**
     * |Fn+1  Fn   |   |1 1|^n
     * |Fn    Fn-1 |   |1 0|
     * @param n
     * @return
     */
    public static int fib2(int n) {
        return -1;
    }

    public static int Fibonacci(int n) {
        if (n <= 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        int fib1 = 0;
        int fib2 = 1;

        int fibN = 0;

        for (int i = 2; i <= n; i++) {
            fibN = fib1 + fib2;

            fib1 = fib2;
            fib2 = fibN;
        }
        return fibN;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(fib1(n));
        System.out.println(Fibonacci(n));
    }
}
