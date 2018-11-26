package com.ex.offer;

import org.junit.Test;

public class Ex_53_GetNumberSameAsIndex {

    public int getNumberSameAsIndex(int[] array) {
        if (array == null || array.length <= 0) {
            return -1;
        }

        int low = 0;
        int high = array.length-1;

        while (low <= high) {
            int midIndex = low + ((high - low) >> 1);
            int midData  = array[midIndex];

            if (midData == midIndex) {
                return midData;
            } else if (midData > midIndex) {
                high = midIndex-1;
            } else {
                low = midIndex + 1;
            }
        }

        return -1;
    }

    @Test
    public void test() {
        int[] array = new int[] {-3,-1,1,3,5};
        System.out.println(getNumberSameAsIndex(array));
    }
}
