package com.ex.offer;

public class Ex_17_AddTwoBigNumber {

    /**
     * 大数相加问题：
     * 大数相加不能直接使用基本的int类型，因为int可以表示的整数有限，不能满足大数的要求。
     * 可以使用字符串来表示大数，模拟大数相加的过程。
     *
     * 思路：
     * 1. 反转字符串，便于从低位到高位的相加；
     * 2. 对齐字符串，短字符串的高位用 ‘0’ 补齐，便于相加；
     * 3. 相加。
     * @param n1
     * @param n2
     * @return
     */
    public static String add(StringBuffer n1, StringBuffer n2) {
        StringBuffer result = new StringBuffer();

        n1.reverse();
        n2.reverse();

        int len1 = n1.length();
        int len2 = n2.length();

        int len = len1 > len2 ? len1 : len2;



        boolean nOverFlow = false;
        int nTakeOver = 0;

        if (len1 < len2) {
            for (int i = len1; i < len2; i++) {
                n1.append('0');
            }
        } else {
            for (int i = len2; i < len1; i++) {
                n2.append('0');
            }
        }

        for (int i = 0; i < len; i++) {
            int nSum = Integer.parseInt(n1.charAt(i)+"") + (n2.charAt(i) - '0');
            nSum += nTakeOver;

            if (nSum >= 10) {
                if (i == len - 1) {
                    nOverFlow = true;
                }

                nTakeOver = 1;
                result.append(nSum - 10);
            } else {
                nTakeOver = 0;
                result.append(nSum);
            }
        }

        if (nOverFlow) {
            result.append(nTakeOver);
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        StringBuffer s1 = new StringBuffer("-999");
        StringBuffer s2 = new StringBuffer("99");
        System.out.println(add(s1, s2));

    }
}
