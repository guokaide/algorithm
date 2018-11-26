package com.ex.offer;

import java.util.Arrays;

public class TestUtils {
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void sort(int[] arr) {
        Arrays.sort(arr);
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

    // cal
    public static int getDigitSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x =  x / 10;
        }

        return sum;
    }

    /**
     * 判断x的奇偶性
     * if x is odd, then x & 1 == 1   3 & 1 = 0011 & 0001 = 0001
     * if x is even, then x & 1 == 0  2 & 1 = 0010 & 0001 = 0000
     *
     * @param x
     * @return
     */
    public static boolean isOdd(int x) {
        if ((x & 0x1) == 1) {
            return true;
        }

        return false;
    }

    public static void printStingToInt(StringBuffer s) {
        System.out.println(s.toString());
        for (int i = 0; i < s.length(); i++) {
            int num1 = s.charAt(i);           // 返回s中各个字符的ASII码
            int num2 = s.charAt(i) - '0';     // 返回s中各个字符的ASII码 - ‘0’的ASII码
            System.out.print("s.charAt(i) = " + s.charAt(i) + "; int(s.charAt(i)) = "
                    + num1 + "; int(s.charAt(i) - '0') = " + num2);
            System.out.println();
        }
    }

    /**
     * 大数问题：字符串模拟加法
     *
     * @param s
     * @return
     */
    public static boolean Increment(StringBuffer s) {
        boolean isOverflow = false;
        int nTakeOver = 0; // 进位
        int nLength = s.length();

        for (int i = nLength - 1; i >= 0; i--) {
            int nSum = s.charAt(i) - '0' + nTakeOver;
            // 加1操作：如果是最后一位，增加1
            if (i == nLength - 1) {
                nSum++;
            }

            if (nSum >= 10) {
                if (i == 0) {
                    isOverflow = true;
                } else {
                    nSum -= 10;
                    nTakeOver = 1;
                    s.setCharAt(i, (char)('0' + nSum));
                }
            } else {  // 若有一位的nSum < 10，则该可以直接退出，不满足 999...99
                s.setCharAt(i, (char)('0' + nSum));
                break;
            }
        }

        return isOverflow;
    }

    public static void printList(Node head) {
        System.out.print("Single Linked List: ");
        if (head == null) {
            System.out.print("empty list.");
        }

        for (Node node = head; node != null; node = node.next) {
            System.out.print(node.val + " ");
        }

        System.out.println();
    }

    public static void printList_ListNode(ListNode head) {
        System.out.print("Single Linked List: ");
        if (head == null) {
            System.out.print("empty list.");
        }

        for (ListNode node = head; node != null; node = node.next) {
            System.out.print(node.val + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            System.out.println(i + ":" + isOdd(i));
//        }

        StringBuffer s = new StringBuffer();
        s.append('9');
        s.append('9');
        s.append('9');
        s.append('9');
        s.append('9'); //98765
        //printStingToInt(s);

        Increment(s);
        System.out.println(s.toString());

    }


}
