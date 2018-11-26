package com.ex.offer;

public class Ex_66_ConstructMultiplyArray {
    public int[] multiply(int[] A) {
        int[] res = new int[A.length];
        if (A == null || A.length < 2) {
            return res;
        }

        int[] C = new int[A.length];
        int[] D = new int[A.length];
        C[0] = 1;
        D[D.length-1] = 1;

        for (int i = 1; i < C.length; i++) {
            C[i] = C[i-1] * A[i-1];
        }

        for (int i = D.length-2; i >= 0; i--) {
            D[i] = D[i+1] * A[i+1];
        }

        for (int i = 0; i < res.length; i++) {
            res[i] = C[i] * D[i];
        }

        return res;
    }
}
