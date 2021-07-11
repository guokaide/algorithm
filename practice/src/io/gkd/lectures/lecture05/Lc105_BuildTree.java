package io.gkd.lectures.lecture05;

import io.gkd.TreeNode;

/**
 * Medium
 * 105. https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * preorder [3 | 9 ｜ 20 15 7] 找到了 root, 但是不确定左右子树的大小 [l1, r1]
 * inorder  [9 | 3 ｜ 15 20 7] 知道 root，自然知道了左右子树的大小   [l2, r2]. 左子树大小 = mid - l2
 *           l2  mid        r2
 *
 *          3
 *         / \
 *       [9] [20 15 7]  preorer
 *       [9] [15 20 7]  inorer
 *      left   right
 */
public class Lc105_BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int l1, int r1, int[] inorder, int l2, int r2) {
        if (l1 > r1) return null;
        TreeNode root = new TreeNode(preorder[l1]);
        // 通过找到 root 在 inorder 中的位置，确定左右子树的大小
        int mid = l2;
        while (inorder[mid] != root.val) mid++;
        int leftSize = mid - l2;
        root.left = build(preorder, l1 + 1, l1 + leftSize, inorder, l2, mid - 1);
        root.right = build(preorder, l1 + leftSize + 1, r1, inorder, mid + 1, r2);
        return root;
    }
}

