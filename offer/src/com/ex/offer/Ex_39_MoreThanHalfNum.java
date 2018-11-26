package com.ex.offer;

public class Ex_39_MoreThanHalfNum {

    public static int moreThanHalfNum(int[] array) {
        if (array == null || array.length <= 0) {
            return 0;
        }

        if (array.length == 1) {
            return array[0];
        }

        int low = 0;
        int high = array.length-1;
        int mid = low + (high - low) / 2;

        int p = partition(array, low, high);

        while (p != mid) {
            if (p < mid) {
                p = partition(array, p+1, high);
            } else {
                p = partition(array, low, p-1);
            }
        }
        int result = array[mid];

        if (!checkMoreThanHalf(array, result)) {
            result = 0;
        }

        return result;
    }

    public static boolean checkMoreThanHalf(int[] arr, int result) {
        int times = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == result) {
                times++;
            }
        }

        if (times * 2 <= arr.length) {
            return false;
        }

        return true;
    }

    public static int partition(int[] arr, int low, int high) {
        if (low == high) {
            return low;
        }
        int pIndex = low + (int) (Math.random() *(high - low));
        swap(arr, low, pIndex);

        int pivot = arr[low];

        int i = low;
        int j = high + 1;

        while (i < j) {
            while (arr[++i] < pivot) {
                if (i == high) {
                    break;
                }
            }

            while (arr[--j] > pivot) {
                if (j == low) {
                    break;
                }
            }

            if (i > j) {
                break;
            }

            swap(arr, i, j);
        }
        swap(arr, j, low);

        return j;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static int moreThanHalfNumWithoutChangeArray(int[] array) {
        if (array == null || array.length <= 0) {
            return 0;
        }

        int result = array[0];
        int times = 1;

        for (int i = 1; i < array.length; i++) {
            if (times == 0) {
                result = array[i];
                times = 1;
            } else if (array[i] == result) {
                times++;
            } else {
                times--;
            }
        }

        if (!checkMoreThanHalf(array, result)) {
            result = 0;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,2,2,2,5,4,2};
        System.out.println(moreThanHalfNumWithoutChangeArray(arr));
        System.out.println(moreThanHalfNumWithoutChangeArray(new int[]{1}));
        System.out.println("=============================");
        TestUtils.printArray(arr);
        System.out.println(moreThanHalfNum(arr));
        TestUtils.printArray(arr);
    }
}
