package com.ex.offer;

import org.junit.Test;

public class Ex_67_StringToInt {
    /**
     * 说明：当输入不合法时，返回0。但是由于正常输出也可能有0，
     * 因此需要设置全局变量isValid标记返回的0是因为输入不合法返回
     *
     * @param str
     * @return
     */
    public int StrToInt(String str) {
        boolean isValid = true;
        // 边界1：str = null
        // 边界2：str = ""
        if (str == null || str == "") {
            isValid = false;
            return 0;
        }

        int number = 0;
        boolean minus = false;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (i == 0) {
                if (c == '+') continue;
                if (c == '-') {
                    minus = true;
                    continue;
                }
            }

            // 边界3：输入存在非法字符
            // [0,1,2,...,9]的ASII码[48,49,...,57]
            // a = 97
            // A = 65
            // x = (char)x - '0' (char -> int)
            if (c < 48 || c > 57) {
                isValid = false;
                return 0;
            }
            number = number * 10 + (c - '0');
        }

        return minus ? -1 * number : number;
    }

    @Test
    public void test() {
        String str1 = null;
        String str2 = "";  // str2 = "         ";
        String str3 = "1234";
        String str4 = "+1234";
        String str5 = "-1234";
        String str6 = "123a5";

        System.out.println(StrToInt(str1));
        System.out.println(StrToInt(str2));
        System.out.println(StrToInt(str3));
        System.out.println(StrToInt(str4));
        System.out.println(StrToInt(str5));
        System.out.println(StrToInt(str6));
    }
}
