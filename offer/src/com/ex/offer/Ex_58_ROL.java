package com.ex.offer;

import org.junit.Test;

public class Ex_58_ROL {
    public String LeftRotateString(String str,int n) {
        if (str == null || str.length() <= 0 || n < 0 || n > str.length()) {
            return "";
        }

        char[] chars = str.toCharArray();

        reverse(chars, 0, n-1);
        reverse(chars, n, chars.length-1);
        reverse(chars, 0, chars.length-1);

        return String.valueOf(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        for (int i = start, j = end; i <= j; i++, j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
    }

    @Test
    public void test() {
        String str = "abcXYZdef";
        System.out.println(LeftRotateString(str, 3));
    }
}
