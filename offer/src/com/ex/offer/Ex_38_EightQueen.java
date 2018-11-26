package com.ex.offer;

import org.junit.Test;

// 8皇后问题与回溯法：https://www.cnblogs.com/bigmoyan/p/4521683.html
//
// 回溯法
// 引例：设想将你放在迷宫之中，要想走出迷宫，最直接的办法是什么？试！先选择一条路开始走，
// 走不通就退回去尝试别的路，走不通接着回退，直到走通为止。
// 本质: 暴力破解。只不过是在暴力破解之前，利用了一些条件减少了暴力破解的一些步骤。

public class Ex_38_EightQueen {

    private static final int QUEEN_NUMBER = 8;      // 皇后个数
    private int[] columns = new int[QUEEN_NUMBER];  // 每个皇后存储的列 (row, col), row天然不相等
    private int total = 0;

    public int solution() {
        queen(0);
        return total;
    }

    private void queen(int row) {
        if (row == QUEEN_NUMBER) {
            total++;
        } else {
            for (int col = 0; col != QUEEN_NUMBER; col++) {
                columns[row] = col;
                if (isPut(row)) {
                    queen(row+1);
                }
            }
        }
    }

    private boolean isPut(int row) {
         for (int i = 0; i != row; i++) {
             if (columns[row] == columns[i] || row - i == Math.abs(columns[row]-columns[i])) {
                 return false;
             }
         }
         return true;
    }

    @Test
    public void test() {
        System.out.println(solution()); //92
    }
}
