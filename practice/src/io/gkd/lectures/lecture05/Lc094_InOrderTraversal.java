package io.gkd.lectures.lecture05;

import io.gkd.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Lc094_InOrderTraversal {

    private List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        find(root);
        return list;
    }

    public void find(TreeNode root) {
        if (root == null) return;
        find(root.left);
        list.add(root.val);
        find(root.right);
    }

}
