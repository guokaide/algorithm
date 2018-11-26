package com.ex.offer;

public class Ex_14_MaxProductionAfterCutting {

    public static int maxProduction(int n) {
        if (n == 1) {
            return 0;
        }

        if (n == 2) {
            return 1;
        }

        if (n == 3) {
            return 2;
        }

        int[] products = new int[n+1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        int max = 0;
        for (int i = 4; i <= n; i++) {
            max = 0;
            for (int j = 0; j <= i/2; j++) {
                int product = products[j] * products[i-j];
                if (product > max) {
                    max = product;
                }
                products[i] = max;
            }
        }
        max = products[n];

        return max;
    }

    public static int maxProductionWithGreedy(int n) {
        if (n == 1) {
            return 0;
        }

        if (n == 2) {
            return 1;
        }

        if (n == 3) {
            return 2;
        }

        int timesOf3 = n/3;  // 此时 n < 3

        if (n - timesOf3 * 3 == 1) {
            timesOf3--;      // 此时 n > 5
        }

        int timesOf2 = (n - timesOf3 * 3) / 2;  // 此时 n < 2

        return (int) (Math.pow(2, timesOf2) * Math.pow(3, timesOf3));
    }

    public static void main(String[] args) {
        int n = 8;
        System.out.println(maxProduction(n));
        System.out.println(maxProductionWithGreedy(n));
    }
}
