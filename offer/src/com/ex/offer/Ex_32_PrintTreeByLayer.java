package com.ex.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Ex_32_PrintTreeByLayer {

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> nodes = new ArrayList<>();

        int countOfNextLevel = 0;   // 统计下一层的节点数
        int left = 1;               // 统计本层剩余的打印数

        if (pRoot == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);

        while (!queue.isEmpty()) {
            TreeNode x = queue.poll();
            left--;
            nodes.add(x.val);

            if (x.left != null) {
                queue.add(x.left);
                countOfNextLevel++;
            }

            if (x.right != null) {
                queue.add(x.right);
                countOfNextLevel++;
            }

            if (left == 0) {
                result.add(new ArrayList<>(nodes));  // 一定要注意这里，拷贝构造，而不能直接将nodes（这只是个引用）扔进去
                nodes.clear();
                left = countOfNextLevel;
                countOfNextLevel = 0;
            }
        }
        return result;
    }


}
