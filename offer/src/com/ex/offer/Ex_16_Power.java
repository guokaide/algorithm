package com.ex.offer;

public class Ex_16_Power {

    /**
     * f(n) = a ^ n
     * 1. a != 0
     * 2. n < 0 时， f(n) = 1 / a ^ abs(-n)
     * 3. n > 0 时， f(n) = a ^ n
     * @param base
     * @param exponent
     * @return
     */
    public static double Power(double base, int exponent) {
        boolean InvalidInput_flag = false;  // 全局变量标识是否为非法输入

        if (base == 0) {
            InvalidInput_flag = true;
            return 0.0;
        }

        int absExp = Math.abs(exponent);

        double result = PowerWithUnsignedExponent(base, absExp);

        if (exponent < 0) {
            return 1 / result;
        } else {
            return result;
        }
    }

    public static double PowerWithUnsignedExponent(double base, int exponent) {
        double result = 1.0;

        for (int i = 1; i <= exponent; i++) {
            result *= base;
        }

        return result;
    }

    public static double PowerWithUnsignedExponentOptimal(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }

        if (exponent == 1) {
            return base;
        }

        double result = PowerWithUnsignedExponentOptimal(base, exponent >> 1);

        result *= result;

        if ((exponent & 0x1) == 1) {
            result *= base;
        }

        return result;
    }
}
