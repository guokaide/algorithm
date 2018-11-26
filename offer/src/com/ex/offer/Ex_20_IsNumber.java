package com.ex.offer;

import org.junit.Test;

public class Ex_20_IsNumber {
    /**
     * A.B[E|e]C
     * A.B: A B任意有其一即可
     * XEC: X C 缺一不可
     */
    private int index = 0;

    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) {
            return false;
        }

        boolean flag = scanInteger(str);

        if (index < str.length && str[index] == '.') {
            index++;
            flag = scanUnsignedInteger(str) || flag; //若是||的话，必须先执行scan函数，否则index无法更新
        }

        if (index < str.length && (str[index] == 'E' || str[index] == 'e')) {
            index++;
            flag = flag && scanInteger(str);
        }

        return flag && index == str.length;
    }

    private boolean scanInteger(char[] str) {
        if (index < str.length && (str[index] == '+' || str[index] == '-')) {
            index++;
        }

        return scanUnsignedInteger(str);
    }

    private boolean scanUnsignedInteger(char[] str) {
        int start = index;
        while (index < str.length && str[index] >= '0' && str[index] <= '9') {
            index++;
        }

        return start < index;
    }

    /**
     以下对正则进行解释:
     [\\+\\-]?            -> 正或负符号出现与否
     \\d*                 -> 整数部分是否出现，如-.34 或 +3.34均符合
     (\\.\\d+)?           -> 如果出现小数点，那么小数点后面必须有数字,否则一起不出现
     ([eE][\\+\\-]?\\d+)? -> 如果存在指数部分，那么e或E肯定出现，+或-可以不出现，
                             紧接着必须跟着整数；或者整个部分都不出现
     */
    public boolean isNumberic1(char[] str) {
        String string = String.valueOf(str);
        return string.matches("[\\+\\-]?\\d*(\\.\\d+)?([eE][\\+\\-]?\\d+)?");
    }

    @Test
    public void test() {
        String str = "123.45e+6";
        char[] chars = str.toCharArray();
        System.out.println(isNumeric(chars));
        System.out.println(isNumberic1(chars));
    }
}
