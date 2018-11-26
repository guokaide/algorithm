package com.ex.offer;

public class Ex_55_DepthOfBT {
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftTreeDepth = TreeDepth(root.left);
        int rightTreeDepth = TreeDepth(root.right);

        return leftTreeDepth > rightTreeDepth ? (leftTreeDepth + 1) : (rightTreeDepth + 1);
    }
}
