package com.ex.offer;

import org.junit.Test;

public class Ex_44_ANumInArray {
    public int digitAt(int index) {
        if (index < 0) {
            return -1;
        }

        int digits = 1;

        while (true) {
            int numbers = countNumbersOf(digits);
            if (index < numbers * digits) {
                return digitAt(index, digits);
            }

            index -= numbers * digits;
            digits++;
        }
    }

    private int countNumbersOf(int digits) {
        if (digits == 1) {
            return 10;
        }

        return 9 * (int)Math.pow(10, digits-1);
    }

    private int digitAt(int index, int digits) {
        int startNumber = digits == 1 ? 0 : (int)Math.pow(10, digits-1);
        int endNumber = startNumber + index / digits;
        index = digits - index % digits;
        for (int i = 1; i < index; i++) {
            endNumber /= 10;
        }

        return endNumber % 10;
    }

    @Test
    public void test() {
        System.out.println(digitAt(1001));
    }
}
