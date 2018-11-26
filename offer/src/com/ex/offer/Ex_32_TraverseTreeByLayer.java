package com.ex.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 注1：
 * 树的按层遍历借助于     队列
 * 树的先中后序遍历借助于 栈
 *
 * 注2：
 * 树的按层遍历本质上说就是广度优先遍历二叉树（树是图的一种特殊退化形式）
 * 那么如何广度优先遍历有向图呢？
 *
 * A:无论是广度优先遍历有向图还是二叉树，都需要用到队列。
 * 首先把起始节点（或者根节点（对树而言））放入队列
 * 然后每次从队列的头部取出一个节点，遍历这个节点之后把它能够到达的节点（或者子节点（对树而言））都一次放入队列中
 * 重复以上遍历过程，知道队列中所有的节点全部被遍历完。
 *
 */
public class Ex_32_TraverseTreeByLayer {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();

        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            result.add(temp.val);
            if (temp.left != null) queue.add(temp.left);
            if (temp.right != null) queue.add(temp.right);
        }

        return result;
    }
}
