package io.gkd.week01;

/**
 * Easy
 * 66. https://leetcode-cn.com/problems/plus-one/submissions/
 */
public class Lc066_PlusOne {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = (digits[i] + 1) % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }

}
