package com.ex.offer;

import java.util.ArrayList;

public class Ex_40_GetLeastKNumbers {

    public static ArrayList<Integer> getLeastKNumbers(int[] input, int k) {
        if (input == null || k <= 0 || input.length < k || input.length <= 0) {
            return null;
        }

        int low = 0;
        int high = input.length - 1;
        int p = partition(input, low, high);

        while (p != k-1) {
            if (p > k-1) {
                p = partition(input, low, p-1);
            } else {
                p = partition(input, p+1, high);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(input[i]);
        }
        return res;
    }

    // 找到第k小的数（那其左边就是比arr[k]小的k个数）
    public static int kthNum(int[] input, int k) {
        if (input == null || k <= 0 || input.length < k || input.length <= 0) {
            return -1;
        }

        int low = 0;
        int high = input.length - 1;
        int p = partition(input, low, high);

        while (p != k-1) {
            if (p > k-1) {
                p = partition(input, low, p-1);
            } else {
                p = partition(input, p+1, high);
            }
        }

        return input[p];
    }

    public static int partition(int[] arr, int low, int high) {
        if (low == high) {
            return low;
        }

        int pivotIndex = low + (int) (Math.random() * (high - low));
        swap(arr, low, pivotIndex);

        int pivot = arr[low];
        int i = low;
        int j = high + 1;
        while (i < j) {
            while (arr[++i] < pivot) {
                if (i == high) break;
            }

            while (arr[--j] > pivot) {
                if (j == low) break;
            }

            if (i > j) break;

            swap(arr, i, j);
        }

        swap(arr, j, low);

        return j;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j]= tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {4,5,1,6,2,7,3,8};
        for (int i : getLeastKNumbers(arr, 8)) {
            System.out.println(i);
        }

        System.out.println(kthNum(arr, 5));
    }
}
