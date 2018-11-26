package com.ex.offer;

public class Ex_54_KthNodeInBST {

    int count = 0; // 递归全局变量

    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if (pRoot != null) {
            TreeNode node = KthNode(pRoot.left, k);
            if (node != null) {
                return node;
            }

            count++;
            if (count == k) {
                return pRoot;
            }

            node = KthNode(pRoot.right, k);
            if (node != null) {
                return node;
            }
        }

        return null;
    }

}
