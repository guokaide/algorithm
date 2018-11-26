package com.ex.offer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class Ex_11_MinNumOfRotatingArray {

    public static int minNumberInRotateArray(int [] array) {
        if (array == null || array.length <= 0) {
            return 0;
        }

        int low = 0;
        int high = array.length - 1;
        int mid = low;  // 若是旋转数组本身，则第一个元素是最小值，直接不进入循环

        // 在这里，假设前面的递增数组第一个元素 > 后面的递增数组最后一个元素
        while (array[low] >= array[high]) {
            if (high - low == 1) {
                mid = high;
                break;
            }

            mid = low + (high - low) / 2;

            // 如果arr[low] == array[mid] == array[high],
            // 则无法用中间和两边比较的方式判断mid属于左边的递增序列还是右边的递增序列
            if (array[low] == array[high] && array[low] == array[mid]) {
                return minInOrder(array, low, high);
            }

            if (array[mid] >= array[low]) {  // 此时，mid位于第一个递增数组中，因此min位于第二个递增数组中
                low = mid;
            } else if (array[mid] <= array[high]){
                high = mid;
            }
        }

        return array[mid];
    }

    private static int minInOrder(int[] array, int low, int high) {
        int min = array[low];
        for (int i = low + 1; i <= high; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] array = new int[]{3,4,5,1,2};
        int[] array1 = new int[]{1,2,3,4,5};
        System.out.println(minNumberInRotateArray(array));
        System.out.println(minNumberInRotateArray(array1));

        int[] array2 = new int[]{1, 0, 1, 1, 1};
        int[] array3 = new int[]{1, 1, 1, 0, 1};
        System.out.println(minNumberInRotateArray(array2));
        System.out.println(minNumberInRotateArray(array3));

    }
}
