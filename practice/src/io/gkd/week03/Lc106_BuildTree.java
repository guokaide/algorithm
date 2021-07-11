package io.gkd.week03;

import io.gkd.TreeNode;

/**
 * Medium
 * 106. https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 *
 * postorder   [9 | 15 7 20 | 3]
 * inorder     [9 | 3 | 15 20 7]
 *              l1  mid       r1
 *             3
 *            / \
 *          [9] [15 7 20]
 *          [9] [15 20 7]
 */
public class Lc106_BuildTree {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int l1, int r1, int[] postorder, int l2, int r2) {
        if (l2 > r2) return null;
        TreeNode root = new TreeNode(postorder[r2]);
        int mid = l1;
        while (inorder[mid] != root.val) mid++;
        int leftSize = mid - l1;
        root.left = build(inorder, l1, mid - 1, postorder, l2, l2 + leftSize - 1);
        root.right = build(inorder, mid + 1, r1, postorder, l2 + leftSize, r2 - 1);
        return root;
    }
}
