package com.ex.offer;

public class Ex_11_SortAges {

    // counting sort
    public static void sortAges(int[] ages) {
        if (ages == null || ages.length <= 0) {
            return;
        }

        int maxAge = 99;
        int[] countAge = new int[maxAge + 1];  // 0~99

        for (int i = 0; i < ages.length; i++) {
            countAge[ages[i]]++;
        }

        int index = 0;
        for (int i = 0; i <= maxAge; i++) {                  // i:年龄
            for (int j = 0; j < countAge[i]; j++) {          // j:年龄的个数
                ages[index++] = i;
            }
        }

    }


    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] ages = new int[]{2, 8, 99, 6, 20, 99, 88, 77 ,99, 44, 55, 55, 77, 23, 18};
        printArray(ages);
        sortAges(ages);
        printArray(ages);
    }
}
