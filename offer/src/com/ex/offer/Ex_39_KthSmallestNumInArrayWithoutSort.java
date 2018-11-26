package com.ex.offer;

public class Ex_39_KthSmallestNumInArrayWithoutSort {

    /**
     * 找到第K个最小的数字，同时RAND-PARTITION之后，K个数(包含第K个数)左侧为最小的K个数
     * @param arr
     * @param K
     * @return
     */
    public static int kthNumIte(int[] arr, int K) {
        if (arr == null || arr.length < K || K <= 0 || arr.length <= 0) {
            return -1;
        }

        int low = 0;
        int high = arr.length - 1;
        int p = partition(arr, low, high);

        while (p != K-1) {
            if (p > K - 1) {
                p = partition(arr, low, p-1);
            } else {
                p = partition(arr, p+1, high);
            }
        }

        return arr[p];
    }


    public static int kthNum(int[] arr, int K) {
        if (arr == null || arr.length < K || K <= 0 || arr.length <= 0) {
            return -1;
        }

        return kthNum(arr, K, 0, arr.length-1);
    }

    /**
     * RAND-SELECT(array, K, low, high)
     * 1. if low == high, RETURN array[low]   // 递归结束的条件
     * 2. p = RAND-PARTITION(arr, low, high)  // [low, high]中，pivot元素在数组中的index
     * 3. count = p - low + 1;                // [low, high]中, pivot元素是第几个元素
     * 4. if count > k       RETURN RAND-SELECT(array, K, low, p-1)
     *    else if count < K  RETURN RAND-SELECT(array, K-count, p+1, high)
     *    else               RETURN arr[p];
     *
     * @param arr
     * @param K
     * @param low
     * @param high
     * @return
     */
    public static int kthNum(int[] arr, int K, int low, int high) {
        if (low == high) {
            return arr[low];
        } else{
            int p = partition(arr, low, high);
            int count = p - low + 1;  // count:从low开始第count个值

            if (count > K) {
                return kthNum(arr, K, low, p-1);
            } else if (count < K) {
                return kthNum(arr, K-count, p+1, high);
            } else {
                return arr[p];
            }
        }

    }

    /**
     * RAND-PARTITION(array, low, high)
     *
     * 1. 随机挑选一个元素作为主元pivot，将该元素换到low位置；
     * 2. 指定2个指针:
     * 2.1 i:指向low,若arr[i] < pivot,则i++;
     * 2.2 j:指向high,若arr[j] > pivot, 则j--;
     * 不断重复2.1 2.2,此时，arr[i] >= pivot, arr[j] <= pivot, 交换arr[i], arr[j]
     * 3. 重复步骤2，直到 i < j条件不满足
     * 4. 交换 arr[low] 和 arr[j]
     *   low       i  j
     * [pivot,  <= x, >= x]
     *
     * @param arr
     * @param low
     * @param high
     * @return
     */
    public static int partition(int[] arr, int low, int high) {
        if (low == high) {
            return low;
        }

        int pIndex = low + (int)(Math.random() * (high - low));
        swap(arr, pIndex, low);

        int pivot = arr[low];  // pivot始终选择第一个元素

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

    public static void main(String[] args) {
        int[] arr = new int[] {6, 4, 7, -2, 9, 6, 8, 2, -5, 5};
//        ArrayUtils.printArray(arr);
//        int p = partition(arr, 0, arr.length-1);
//        System.out.println(p + " : " + arr[p]);
//        ArrayUtils.printArray(arr);

        System.out.println("======================================");
        TestUtils.printArray(arr);
        for (int K = 1; K <= arr.length; K++) {
            int kth = kthNum(arr, K);
            System.out.print(kth + " ");
        }

        int kth = kthNum(arr, 0);
        System.out.print(kth + " ");
        System.out.println();

        System.out.println("======================================");
        int[] arr1 = new int[] {6, 4, 7, -2, 9, 6, 8, 2, -5, 5};
        TestUtils.printArray(arr1);
        for (int K = 1; K <= arr1.length; K++) {
            int kth1 = kthNumIte(arr1, K);
            System.out.print(kth1 + " ");
        }

        int kth1 = kthNumIte(arr1, 0);
        System.out.print(kth1 + " ");
        System.out.println();

        System.out.println("======================================");
        int[] arr2 = new int[] {6, 4, 7, -2, 9, 6, 8, 2, -5, 5};
        int K = 5;
        TestUtils.printArray(arr2);
        int kth2 = kthNumIte(arr2, K);
        System.out.println(K + ":" + arr2[K-1]);
        TestUtils.printArray(arr2);

    }


}
