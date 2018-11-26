package com.ex.offer;

public class Ex_12_HasPathInMatrix {

    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || matrix.length <= 0 || str == null || str.length <= 0 ||
                rows <= 0 || cols <= 0 || matrix.length != rows * cols || matrix.length < str.length) {
            return false;
        }

        boolean[] visited = new boolean[rows * cols];
        int pathLength = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasPathCore(matrix, rows, cols,str, i, j, visited, pathLength)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean hasPathCore(char[] matrix, int rows, int cols, char[] str, int rowStart, int colStart,
                               boolean[] visited, int pathLength) {
        boolean flag = false;

        if (rowStart >= 0 && rowStart < rows && colStart >= 0 && colStart < cols &&
                !visited[rowStart*cols+colStart] && matrix[rowStart*cols+colStart] == str[pathLength]) {
            pathLength++;
            visited[rowStart*cols+colStart] = true;

            if (pathLength == str.length) {
                return true;
            }

            flag = hasPathCore(matrix, rows, cols, str, rowStart, colStart+1, visited, pathLength) ||
                    hasPathCore(matrix, rows, cols, str, rowStart+1, colStart, visited, pathLength) ||
                    hasPathCore(matrix, rows, cols, str, rowStart, colStart-1, visited, pathLength) ||
                    hasPathCore(matrix, rows, cols, str, rowStart-1, colStart, visited, pathLength);

            if (!flag) {
                pathLength--;
                visited[rowStart*cols+colStart] = false;
            }
        }

        return flag;
    }

    public static void main(String[] args) {
        String m = "ABCESFCSADEE";
        String s = "ABCCED";

        char[] matrix = m.toCharArray();
        char[] str = s.toCharArray();

        System.out.println(hasPath(matrix, 3, 4, str));
    }
}
