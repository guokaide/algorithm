package io.gkd.lectures.lecture05;

import io.gkd.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Easy
 * 589. https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 */
public class Lc589_PreOrderNTree {
    private List<Integer> list = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        find(root);
        return list;
    }

    private void find(Node root) {
        if (root == null) return;
        list.add(root.val);
        for (Node node : root.children) {
            find(node);
        }
    }

    public List<Integer> preorderIter(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            Node r = stack.pop();
            list.add(r.val);
            List<Node> children = r.children;
            for (int i = children.size() - 1; i >= 0; i--) {
                stack.push(children.get(i));
            }
        }
        return list;
    }
}
