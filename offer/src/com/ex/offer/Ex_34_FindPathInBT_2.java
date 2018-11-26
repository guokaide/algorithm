package com.ex.offer;

import java.util.ArrayList;

public class Ex_34_FindPathInBT_2 {
    ArrayList<ArrayList<Integer>> pathList = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) return pathList;

        findPath(root, target, 0);

        return pathList;
    }

    private void findPath(TreeNode root, int target, int sum) {
        path.add(root.val);

        sum += root.val;

        if (sum == target && root.left == null && root.right == null) {
            pathList.add(new ArrayList<>(path));
        }

        if (root.left != null) {
            findPath(root.left, target, sum);
        }

        if (root.right != null) {
            findPath(root.right, target, sum);
        }

        path.remove(path.size()-1);
        return;
    }


}
