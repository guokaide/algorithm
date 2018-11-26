package com.ex.offer;

import org.junit.Test;

public class Ex_33_VerifySequenceOfBST {
    public boolean VerifySequenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length <= 0) {
            return false;
        }

        return verifySequence(sequence, 0, sequence.length-1);
    }

    public boolean verifySequence(int[] sequence, int start, int end) {
        if (sequence == null || start > end) {
            return false;
        }

        // 若数组区间[start, end]元素为0则停止递归,其实可以去掉这个判断
        if (start == end) {
            return true;
        }

        int root = sequence[end];

        // 找到左右子树的分界点[i-1,i]
        // 小于root: [start, i-1]
        int i = start;
        for ( ; i < end; i++) {
            if (sequence[i] > root) {
                break;
            }
        }

        // 大于root: [i, end-1]
        int j = i;
        for ( ; j < end; j++) {
            if (sequence[j] < root) {
                return false;
            }
        }

        // 判断左子树
        boolean left = true; // 若左子树为空，则左子树为后序遍历序列
        if (i > start) {
            left = verifySequence(sequence, start, i-1);
        }

        // 判断右子树
        boolean right = true; // 若右子树为空，则右子树为后序遍历序列
        if (i < end) {
            right = verifySequence(sequence, i, end-1);
        }

        return left && right;
    }

    @Test
    public void test() {
        int[] arr = new int[] {5, 7, 6, 9, 11, 10, 8};
        boolean result = VerifySequenceOfBST(arr);
        System.out.println(result);
    }

}
