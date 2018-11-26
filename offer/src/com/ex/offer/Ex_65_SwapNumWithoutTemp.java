package com.ex.offer;

public class Ex_65_SwapNumWithoutTemp {
    public int[] swap1 (int a, int b) {
        int[] res = new int[2];
        //=================================
        a = a + b;
        b = a - b;  // b = (a + b) - b
        a = a - b;  // a = (a + b) - a
        //=================================
        res[0] = a;
        res[1] = b;
        return res;
    }

    public int[] swap2 (int a, int b) {
        int[] res = new int[2];

        //=================================
        a = a ^ b;
        b = a ^ b;   // b = (a ^ b) ^ b = a ^ (b ^ b) = a ^ 0 = a
        a = a ^ b;
        //=================================
        res[0] = a;
        res[1] = b;
        return res;
    }

}
