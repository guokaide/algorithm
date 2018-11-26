package com.ex.offer;

/**
 * problem 3: 不修改数组找出重复的数字。 [binary search]
 *
 * 特性：若数组中没有重复元素，则[x,y]范围内的数字个数为y-x+1,若超出这个个数,则说明有重复的数字。
 */
public class Ex_03_FindDuplicatedNumInWithoutChangeArray {

    public static int duplicate(int numbers[]) {
        if (numbers == null || numbers.length < 2) {
            return -1;
        }

        int start = 1;
        int end = numbers.length - 1;

        while(start <= end) {
            int mid = start + ((end - start) >> 1);  // 这里 >> 一定要放在括号内
            int count = countRange(numbers, start, mid);

            if (start == end) {
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }

            if (count > (mid - start + 1)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    private static int countRange(int[] numbers, int start, int end) {
        if (numbers == null) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] <= end && numbers[i] >= start) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{2, 3, 5, 4, 3, 2, 6, 7};
        int duplicate = duplicate(numbers);
        System.out.println(duplicate);
    }
}
