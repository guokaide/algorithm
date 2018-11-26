package com.ex.offer;

import org.junit.Test;

/**
 * String -> Another String
 */
public class Ex_46_TranslationFromIntToString {
    // 动态规划：从下而上（从后往前）
    public int translation(int num) {
        if (num < 0) {
            return -1;
        }

        String str = String.valueOf(num);
        int len = str.length();
        int counts[] = new int[len];

        counts[len-1] = 1;

        for (int i = len-2; i>=0; i--) {
            int count = 0;
            count = counts[i+1];

            int d1 = str.charAt(i) - '0';
            int d2 = str.charAt(i+1) - '0';
            int convertedNum = d1 * 10 + d2;
            if (convertedNum >= 10 && convertedNum <=25) {
                if (i < len-2) {
                    count += counts[i+2];
                } else {
                    count += 1;
                }
            }
            counts[i] = count;
        }

        return counts[0];
    }

    // 递归：自上而下（从前到后）
    public int translation1(int num) {
        if (num < 0) {
            return -1;
        }

        String str = String.valueOf(num);
        char[] chars = str.toCharArray();

        return translationCore(chars, 0);
    }

    private int translationCore(char[] chars, int start) {
        if (start == chars.length) {
            return 1;
        }

        int res = 0;

        res += translationCore(chars, start + 1);

        if (chars[start] == '0') {
            return res;
        }

        if (start + 1 < chars.length) {
            int sum = (chars[start] - '0') * 10 + (chars[start+1] - '0');
            if (sum < 26) {
                res += translationCore(chars, start + 2);
            }
        }

        return res;
    }

    @Test
    public void test() {
        System.out.println(translation(1234));
        System.out.println(translation(12258));
    }
}
