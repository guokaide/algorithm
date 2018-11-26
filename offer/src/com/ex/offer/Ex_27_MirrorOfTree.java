package com.ex.offer;

public class Ex_27_MirrorOfTree {

    public void Mirror(TreeNode root) {
        if (root == null) return;

        if (root.left == null && root.right == null) return;

        swapLeftAndRight(root);

        Mirror(root.left);
        Mirror(root.right);

    }

    public void swapLeftAndRight(TreeNode root) {
        if (root == null) return;

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right =tmp;
    }
}
