package com.ex.offer;

import org.junit.Test;

public class Ex_47_MaxGiftValue {
    public int getMaxValue(int[][] matrix) {
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) {
            return -1;
        }

        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        int[][] result = new int[rowSize][colSize];

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                int left = 0;
                int up = 0;
                if (i > 0) {
                    left = result[i-1][j];
                }
                if (j > 0) {
                    up = result[i][j-1];
                }

                result[i][j] = Math.max(left, up) + matrix[i][j];
            }
        }

        return result[rowSize-1][colSize-1];
    }

    public int getMaxValue1(int[][] matrix) {
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) {
            return -1;
        }

        return process(matrix, 0, 0);
    }

    private int process(int[][] matrix, int startRow, int startCol) {
        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        int curValue = matrix[startRow][startCol];

        if (startRow == rowSize && startCol == colSize) {
            return matrix[startRow][startCol];
        }


        int down = 0;
        int right = 0;
        if (startRow + 1 < rowSize) {
            down = process(matrix, startRow + 1, startCol);
        }

        if (startCol + 1 < colSize) {
            right = process(matrix, startRow, startCol + 1);
        }

        return  curValue + Math.max(down, right);
    }

    @Test
    public void test() {
        int[][] matrix = new int[][] {
                {1 , 10, 3 , 8 },
                {12, 2 , 9 , 6 },
                {5 , 7 , 4 , 11},
                {3,  7 , 16, 5 }
        };
        System.out.println(getMaxValue(matrix));
        System.out.println(getMaxValue1(matrix));
    }
}
