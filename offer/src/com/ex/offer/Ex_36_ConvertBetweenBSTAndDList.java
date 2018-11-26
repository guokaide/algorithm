package com.ex.offer;

import java.util.Stack;

public class Ex_36_ConvertBetweenBSTAndDList {
    TreeNode head = null;
    TreeNode tail = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        convert(pRootOfTree);
        return head;
    }

    public void convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return;

        convert(pRootOfTree.left);

        if (head == null) { // 第一次，标记head节点
            head = pRootOfTree;
            tail = pRootOfTree;
        } else {
            tail.right = pRootOfTree;
            pRootOfTree.left = tail;

            tail = pRootOfTree;
        }

        convert(pRootOfTree.right);
    }



    public TreeNode ConvertIterative(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = pRootOfTree;
        TreeNode pre = null;
        TreeNode head = null;
        boolean isFirst = true;

        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();

            if (isFirst) {
                head = node;
                pre = head;
                isFirst = false;
            } else {
                pre.right = node;
                node.left = pre;
                pre = node;
            }
            node = node.right;
        }
        return head;
    }
}
