package com.ex.offer;

public class Ex_28_SymmetricalTree {
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return true;

        return isSymmetrical(pRoot, pRoot);
    }

    // 树的前序遍历和对称前序遍历
    boolean isSymmetrical(TreeNode pRoot1, TreeNode pRoot2) {
        // 递归结束条件
        if (pRoot1 == null && pRoot2 == null) return true;

        if (pRoot1 == null || pRoot2 == null) return false;

        if (pRoot1.val != pRoot2.val) {
            return false;
        }

        return isSymmetrical(pRoot1.left, pRoot2.right) && isSymmetrical(pRoot1.right, pRoot2.left);
    }

    // 树的前序遍历
    public boolean doesTree1HasTree2(TreeNode root1, TreeNode root2) {
        // 递归结束条件
        if (root2 == null) {
            return true;
        }

        if (root1 == null) {
            return false;
        }

        if (root1.val != root2.val) {
            return false;
        }

        return doesTree1HasTree2(root1.left, root2.left) && doesTree1HasTree2(root1.right, root2.right);
    }
}
