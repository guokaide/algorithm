package com.ex.offer;

import org.junit.Test;

public class Ex_21_ReOrderArray {

    public void reOrderArray(int [] array) {
        if (array == null || array.length == 0) {
            return;
        }

        int i = 0;

        while (i < array.length) {
            while (i < array.length && (array[i] & 1) == 1) {
                i++;
            }

            int j = i+1;

            while (j < array.length && (array[j] & 1) != 1) {
                j++;
            }

            if (j < array.length) {
                int tmp = array[j];
                for (int k = j-1; k >= i; k--) {
                    array[k+1] = array[k];
                }
                array[i] = tmp;
                i++;
            } else {
                break;
            }
        }
    }

    public void reOrderArray1(int [] array) {
        if (array == null || array.length == 0) {
            return;
        }

        int i = 0;
        int j = array.length-1;
        while (i < j) {
            while ((array[i] & 1) != 0) {
                i++;
            }

            while ((array[j] & 1) == 0) {
                j--;
            }

            if (i > j) break;

            swap(array, i, j);
        }
    }

    public void reOrderArray2(int [] array) {
        if(array == null || array.length == 0) {
            return;
        }

        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-1-i; j++) {
                if (array[j] % 2 == 0 && array[j+1] % 2 == 1) {
                    swap(array, j, j+1);
                }
            }
        }
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }


    @Test
    public void test() {
        int[] array = new int[] {1,2,3,4,5,6,7};
        reOrderArray1(array);
        TestUtils.printArray(array);
    }
}
