package com.ex.offer;

import org.junit.Test;

public class Ex_53_GetNumberOfK {
    public int GetNumberOfK(int [] array , int k) {
        if (array == null || array.length <= 0) {
            return 0;
        }

        int left = getFirstIndexOfK(array, k, 0, array.length-1);
        int right = getLastIndexOfK(array, k, 0, array.length-1);

        if (left != -1 && right != -1) {
            return right - left + 1;
        }

        return 0;
    }

    private int getFirstIndexOfK(int[] array, int k, int low, int high) {
        if (low > high) {
            return -1;
        }

        int midIndex = low + ((high-low) >> 1);
        int midData  = array[midIndex];
        if (midData == k) {
            if (midIndex > 0 && array[midIndex-1] != midData || midIndex == 0) {
                return midIndex;
            } else {
                high = midIndex-1;
            }
        } else if (midData > k) {
            high = midIndex - 1;
        } else {
            low = midIndex + 1;
        }

        return getFirstIndexOfK(array, k, low, high);
    }

    private int getLastIndexOfK(int[] array, int k, int low, int high) {
        if (low > high) {
            return -1;
        }

        int midIndex = low + ((high-low) >> 1);
        int midData  = array[midIndex];
        if (midData == k) {
            if (midIndex < array.length-1 && array[midIndex+1] != k || midIndex == array.length-1) {
                return midIndex;
            } else {
                low =  midIndex + 1;
            }
        } else if (midData > k) {
            high = midIndex - 1;
        } else {
            low = midIndex + 1;
        }

        return getLastIndexOfK(array, k, low, high);
    }

    @Test
    public void test() {
        int[] array = new int[]{1,3,3,3,3,3,4,5};
        System.out.println(getFirstIndexOfK(array, 2, 0, array.length-1));
        System.out.println(getLastIndexOfK(array, 2, 0, array.length-1));
        System.out.println(GetNumberOfK(array, 2));
    }
}
