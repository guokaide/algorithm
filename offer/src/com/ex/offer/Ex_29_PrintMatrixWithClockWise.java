package com.ex.offer;

import java.util.ArrayList;

public class Ex_29_PrintMatrixWithClockWise {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if (matrix == null || matrix.length <= 0) {
            return new ArrayList<>();
        }

        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();

        int r1 = 0;
        int c1 = 0;
        int r2 = matrix.length-1;
        int c2 = matrix[r2].length-1;

        while (r1 <= r2 && c1 <= c2) {
            temp = printMatrixWithCircle(matrix, r1++, c1++, r2--, c2--);
            for (Integer i : temp) {
                result.add(i);
            }
        }
        return result;
    }

    public ArrayList<Integer> printMatrixWithCircle(int[][] matrix, int r1, int c1, int r2, int c2) {
        ArrayList<Integer> result = new ArrayList<>();

        if (r1 == r2) {
            for (int i = c1; i <= c2; i++) {
                result.add(matrix[r1][i]);
            }
            return result;
        }

        if (c1 == c2) {
            for (int i = r1; i <= r2; i++) {
                result.add(matrix[i][c1]);
            }
            return result;
        }

        for (int i = c1; i < c2; i++) {
            result.add(matrix[r1][i]);
        }

        for (int i = r1; i < r2; i++) {
            result.add(matrix[i][c2]);
        }

        for (int i = c2; i > c1; i--)  {
            result.add(matrix[r2][i]);
        }

        for (int i = r2; i > r1; i--) {
            result.add(matrix[i][c1]);
        }

        return result;
    }
}
