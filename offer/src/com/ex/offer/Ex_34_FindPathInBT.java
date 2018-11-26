package com.ex.offer;

import org.junit.Test;

import java.util.ArrayList;

public class Ex_34_FindPathInBT {

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> pathList = new ArrayList<>();

        if (root == null) {
            return pathList;
        }
        ArrayList<Integer> path = new ArrayList<>();

        findPath(root, target, path, pathList);

        return pathList;
    }

    private void findPath(TreeNode root,
                          int target,
                          ArrayList<Integer> path,
                          ArrayList<ArrayList<Integer>> pathList) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            if (root.val == target) {
                path.add(root.val);
                pathList.add(path);
            }
            return;
        }

        path.add(root.val);
        ArrayList<Integer> pathCopy = new ArrayList<>(path);

        findPath(root.left, target - root.val, path, pathList);
        findPath(root.right, target - root.val, pathCopy, pathList);
        return;
    }


    @Test
    public void test() {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(12);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        ArrayList<ArrayList<Integer>> list = FindPath(node1, 22);
        int a = 5;
    }
}
