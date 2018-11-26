package com.ex.offer;

public class Ex_53_GetMissingNumber {
    public int getMissingNumber(int[] array) {
        if (array == null || array.length < 1) {
            return -1;
        }

        int low = 0;
        int high = array.length-1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (array[mid] != mid) {
                if (mid == 0 || array[mid-1] == mid-1) {
                    return mid;
                }
                high = mid-1;
            } else {
                low = mid + 1;
            }
        }

        if (low == array.length-1) {
            return array.length;
        }
        return -1;
    }
}
