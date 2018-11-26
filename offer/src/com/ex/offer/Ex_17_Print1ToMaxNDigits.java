package com.ex.offer;

public class Ex_17_Print1ToMaxNDigits {

    /**
     * 1. 实现基本功能，但是当n很大时，count会出现int范围不够的问题，改成long，仍然会有相同的问题
     * @param n
     */
    public static void print1ToMaxNDigits_1 (int n) {
        int count = 1;
        int i = 0;

        while (i < n) {
            count *= 10;
            i++;
        }


        for (int k = 1; k < count; k++) {
            System.out.print(k + " ");
            if (k % 10 == 0) {
                System.out.println();
            }
        }

    }

    /**
     * 2. 字符串存储数字
     *
     * @param n
     */
    public static void print1ToMaxNDigits_2 (int n) {
        if (n <= 0) {
            return;
        }

        StringBuffer number = new StringBuffer();

        for (int i = 0; i < n; i++) {
            number.append('0');
        }

        while (!Increment(number)) {
            printNumber(number);
        }
    }

    /**
     * n位所有的十进制数：n个0~9的全排列
     * @param n
     */
    public static void print1ToMaxNDigits_3 (int n) {
        if (n <= 0) {
            return;
        }

        StringBuffer s = new StringBuffer();
        for (int i = 0; i < n; i++) {
            s.append('0');
        }

        for (int i = 0; i < 10; i++) {
            s.setCharAt(0, (char)(i+'0')); //“xx” x:0~9
            print1ToMaxNDigits_3_Recur(s, n, 0);
        }
    }

    /**
     * index 数字已经确定，要确定index + 1位的数字 可选范围[0,9]
     * @param s
     * @param n
     * @param index
     */
    public static void print1ToMaxNDigits_3_Recur(StringBuffer s, int n, int index) {
        if (index == n-1) {
            printNumber(s);
            return;
        }

        for (int i = 0; i < 10; i++) {
            s.setCharAt(index + 1, (char)(i+'0'));
            print1ToMaxNDigits_3_Recur(s, n, index + 1);
        }
    }

    public static boolean Increment(StringBuffer s) {
        boolean isOverflow = false;
        int nTakeOver = 0; //进位
        int len = s.length();

        for (int i = len-1; i >= 0; i--) {
            int nSum = s.charAt(i) - '0' + nTakeOver;

            // 若是最后1位，加1
            if (i == len-1) {
                nSum++;
            }

            // 若高位第一位之后的某位nSum >= 10, 则需要执行进位操作
            // 若高位第一位nSum >= 10, 则直接返回true,说明已经执行到了最高位，且最高位进位了
            if (nSum >= 10) {
                if (i == 0) {
                    isOverflow = true;
                } else {
                    nSum -= 10;
                    nTakeOver = 1;
                    s.setCharAt(i, (char)(nSum + '0'));
                }
            } else { // 若高位第一位之后的任何一位的nSum < 10, 则直接退出
                s.setCharAt(i, (char)(nSum + '0'));
                break;
            }

        }
        return isOverflow;
    }

    // 有效位前面的0不打印
    public static void printNumber(StringBuffer s) {
        boolean isBeginWith0 = true;

        for (int i = 0; i < s.length(); i++) {
            if (isBeginWith0 && s.charAt(i) != '0') {
                isBeginWith0 = false;
            }

            if (!isBeginWith0) {
                System.out.print(s.charAt(i));
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
//        print1ToMaxNDigits_1(2);
//        System.out.println();
//        print1ToMaxNDigits_2(2);
//        System.out.println();
        print1ToMaxNDigits_3(2);

    }
}
