package com.ex.offer;

public class Ex_15_Count1 {

    public static int NumberOf1(int n) {
        int count = 0;
        int flag = 1;

        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }

        return count;
    }

    public static int NumberOf1Optimal(int n) {
        int count = 0;

        while (n != 0) {
            count++;
            n = (n-1) & n;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1(10));
        System.out.println(NumberOf1Optimal(10));
    }
}
