package com.ex.offer;

import java.util.ArrayList;
import java.util.Stack;

public class Ex_32_PrintTreeWithZhi {

    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> nodes = new ArrayList<>();

        if (pRoot == null) return result;

        Stack<TreeNode> s1 = new Stack<>(); // 奇数层 1
        Stack<TreeNode> s2 = new Stack<>(); // 偶数层 0

        int cur = 1;
        int next = 0;

        s1.add(pRoot);

        while (!s1.isEmpty() || !s2.isEmpty()) {
            TreeNode x = null;
            if (cur == 1) {
                x = s1.pop();
            } else {
                x = s2.pop();
            }

            nodes.add(x.val);

            if (cur == 1) {
                if (x.left != null) {
                    s2.push(x.left);
                }

                if (x.right != null) {
                    s2.push(x.right);
                }


            } else {
                if (x.right != null) {
                    s1.push(x.right);
                }

                if (x.left != null) {
                    s1.push(x.left);
                }
            }

            if (cur == 1 && s1.isEmpty() && !nodes.isEmpty()) {
                result.add(new ArrayList<>(nodes));
                nodes.clear();
                next = 1-next;
                cur = 1-cur;
            }


            if (cur == 0 && s2.isEmpty() && !nodes.isEmpty() ) {
                result.add(new ArrayList<>(nodes));
                nodes.clear();
                next = 1-next;
                cur = 1-cur;
            }
        }
        return result;
    }

    // 此答案有错
    public ArrayList<ArrayList<Integer>> Print1(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> nodes = new ArrayList<>();

        if (pRoot == null) return result;

        Stack<TreeNode>[] stacks = new Stack[2];
        int current = 0;  //奇数层
        int next = 1;     //偶数层
        stacks[current].push(pRoot);

        while (!stacks[0].isEmpty() || !stacks[1].isEmpty()) {
            TreeNode x = stacks[current].pop();
            nodes.add(x.val);

            if (current == 0) {
                if (x.left != null) {
                    stacks[next].push(x.left);
                }

                if (x.right != null) {
                    stacks[next].push(x.right);
                }
            } else {
                if (x.right != null) {
                    stacks[next].push(x.right);
                }

                if (x.left != null) {
                    stacks[next].push(x.left);
                }
            }

            if (stacks[current].isEmpty()) {
                result.add(new ArrayList<>(nodes));
                nodes.clear();
                current = 1 - current;
                next = 1- next;

            }
        }

        return result;
    }

}
