package com.ex.offer;

import org.junit.Test;

public class Ex_56_AppearanceOnce_Continued {
    public int FindNumAppearOnce(int[] array) {
        if (array == null || array.length < 1) {
            return -1;
        }

        int[] bitSum = new int[8 * 4];// 所有元素的各个bit分别相加

        for (int i = 0; i < array.length; i++) {
            int bitFlag = 1;  // bit & 1 = bit 如：xxx & 010 = 0x0
            for (int j = 31; j >= 0; j--) {
                int bit = array[i] & bitFlag;  // 每一位都是0x0...或者000...
                bitSum[j] += bit == 0 ? 0 : 1; // 但是这里只能加1或者0
                bitFlag = bitFlag << 1;
            }
        }

        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1;
            result += bitSum[i] % 3;
        }

        return result;
    }

    @Test
    public void test() {
        int[] array = new int[] {4, 5,5,5,9,9,9,8,8,8, 20, 4,4};
        System.out.println(FindNumAppearOnce(array));
    }
}
