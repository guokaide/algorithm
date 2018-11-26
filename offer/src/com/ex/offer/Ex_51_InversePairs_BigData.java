package com.ex.offer;

import java.util.Arrays;

public class Ex_51_InversePairs_BigData {
    public int InversePairs(int [] array) {
        if (array == null || array.length < 2) {
            return 0;
        }

        int count = mergeSort(array, 0, array.length-1);

        return count;
    }

    private int mergeSort(int[] array, int low, int high) {
        if (low == high) {
            return 0;
        }

        int mid = low + ((high-low) >> 1);
        int left = mergeSort(array, low, mid);
        int right = mergeSort(array, mid+1, high);
        int merge = merge(array, low, mid, high);

        return (left + right + merge) % 1000000007 ;
    }

    private int merge(int[] array, int low, int mid, int high) {
        int[] help = new int[high-low+1];
        int i = 0;
        int p1 = low;
        int p2 = mid+1;
        int res = 0;

        while (p1 <= mid && p2 <= high) {
            res += array[p1] > array[p2] ? (high-p2+1): 0;
            res = res >= 1000000007? res % 1000000007 : res;   // 数据过大，会溢出
            help[i++] = array[p1] > array[p2] ? array[p1++] : array[p2++];
        }

        while (p1 <= mid) {
            help[i++] = array[p1++];
        }

        while (p2 <= high) {
            help[i++] = array[p2++];
        }

        for (i = 0; i < help.length; i++) {
            array[low + i] = help[i];
        }

        return res;
    }
}
