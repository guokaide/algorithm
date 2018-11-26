package com.ex.offer;

import org.junit.Test;

public class Ex_58_ReverseSentence {
    public String ReverseSentence(String str) {
        // 边界条件1：str == null or str = ""
        if (str == null || str.length() <= 0) {
            return "";
        }

        // 注意这里：String是不可变的，因此我们需要将String转换为char[]
        char[] chars = str.toCharArray();
        reverse(chars, 0, chars.length-1);

        int start = 0; // 指向单词的开头
        while (start < chars.length && chars[start] == ' ') {
            start++;  // 排除开头的' '
        }

        // 边界条件2：str = "                   " (全部都是' ')
        if (start == chars.length) {
            return str;
        }

        // start 和 end像是在接力
        for (int end = start; end < chars.length; end++) {
            if (chars[end] == ' ') {
                reverse(chars, start, --end);
                end += 2;
                start = end;
            }
        }

        reverse(chars, start, chars.length-1);

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
        String str = "I am a student.";
        String str1 = " ";
        System.out.println(ReverseSentence(str));
        //System.out.println(ReverseSentence(str1));
        System.out.println(str1.length());
    }
}
