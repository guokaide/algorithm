package com.ex.offer;

import org.junit.Test;

import java.util.ArrayList;

public class Ex_34_FindPathInBT_1 {
    ArrayList<ArrayList<Integer>> pathList = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) return pathList;

        findPath(root, target);

        return pathList;
    }

    private void findPath(TreeNode root, int target) {
        path.add(root.val);

        if (root.val == target && root.left == null && root.right == null) {
            pathList.add(new ArrayList<>(path));
        }

        if (root.left != null) {
            findPath(root.left, target - root.val);
        }

        if (root.right != null) {
            findPath(root.right, target - root.val);
        }

        path.remove(path.size()-1);

        return;
    }


}
