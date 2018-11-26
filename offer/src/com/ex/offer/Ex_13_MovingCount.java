package com.ex.offer;

public class Ex_13_MovingCount {

    public int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows <= 0 || cols <= 0) {
            return 0;
        }

        boolean[] visited = new boolean[rows * cols];

        int count = helper(threshold, rows, cols, 0, 0, visited);

        return count;
    }

    public int helper(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        int count = 0;

        if (check(threshold, rows, cols, row, col, visited)) {
            visited[row * cols + col] = true;

            count = 1 + helper(threshold, rows, cols, row, col+1, visited)
                    + helper(threshold, rows, cols, row+1, col, visited)
                    + helper(threshold, rows, cols, row, col-1, visited)
                    + helper(threshold, rows, cols, row-1, col, visited);
        }

        return count;
    }

    public boolean check(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        if (row >= 0 && row < rows && col >= 0 && col < cols
                && !visited[row * cols + col]
                && getDigitSum(row) + getDigitSum(col) <= threshold) {
            return true;
        }

        return false;
    }

    public int getDigitSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x = x / 10;
        }
        return sum;
    }
}
