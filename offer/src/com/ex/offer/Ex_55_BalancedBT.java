package com.ex.offer;

public class Ex_55_BalancedBT {

    // Java没有引用和指针，可以使用全局变量，也可以使用数组引用
    int depth = 0;

    public boolean IsBalanced_Solution(TreeNode root) {
        return isBalance(root);
    }

    private boolean isBalance(TreeNode root) {
        if (root == null) {
            depth = 0;  // 深度为0
            return true;
        }

        boolean left = isBalance(root.left);
        int leftDepth = depth;  // 左子树深度

        boolean right = isBalance(root.right);
        int rightDepth = depth; // 右子树深度

        depth = Math.max(leftDepth + 1, rightDepth + 1); // root深度（后序遍历）

        if (left && right && Math.abs(leftDepth - rightDepth) <= 1) {
            return true;
        }

        return false;
    }

    //pos-order遍历，使用辅助数组depth来保存每一步遍历的深度，同时返回该节点是否是平衡的
    public boolean IsBalanced_Solution1(TreeNode root) {
        return isBalance(root, new int[1]);
    }

    public boolean isBalance(TreeNode root, int[] depth) {
        if (root == null) {
            depth[0] = 0;
            return true;
        }
        boolean left = isBalance(root.left, depth);
        int leftdepth = depth[0];

        boolean right = isBalance(root.right, depth);
        int rightdepth = depth[0];

        depth[0] = Math.max(leftdepth + 1, rightdepth + 1);

        if (left && right && Math.abs(leftdepth - rightdepth) <= 1) return true;
        return false;
    }

    // 从上到下遍历: 遍历每个结点，借助一个获取树深度的递归函数，
    // 根据该结点的左右子树高度差判断是否平衡，然后递归地对左右子树进行判断。
    public boolean IsBalanced_Solution2(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftDepth = TreeDepth(root.left);
        int rightDepth = TreeDepth(root.right);
        int diff = leftDepth - rightDepth;

        if (diff > 1 || diff < -1) {
            return false;
        }

        return IsBalanced_Solution2(root.left) && IsBalanced_Solution2(root.right);
    }

    private int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftTreeDepth = TreeDepth(root.left);
        int rightTreeDepth = TreeDepth(root.right);

        return leftTreeDepth > rightTreeDepth ? (leftTreeDepth + 1) : (rightTreeDepth + 1);
    }

    // 从下到上遍历:
    // 从上到下遍历在判断上层结点的时候，会多次重复遍历下层结点，增加了不必要的开销。
    // 如果改为从下往上遍历，如果子树是平衡二叉树，则返回子树的高度；
    // 如果发现子树不是平衡二叉树，则直接停止遍历，这样至多只对每个结点访问一次。
    public boolean IsBalanced_Solution3(TreeNode root) {
        return getDepth(root) != -1;
    }

    // 若左右子树高度差大于1，则返回-1（不是平衡二叉树）
    // 若左右子树高度差不大于1，则返回子树的高度
    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = getDepth(root.left);
        if (leftDepth == -1) return -1;

        int rightDepth = getDepth(root.right);
        if (rightDepth == -1) return -1;

        return Math.abs(leftDepth - rightDepth) > 1 ? -1 : (Math.max(leftDepth, rightDepth) + 1);
    }


}
