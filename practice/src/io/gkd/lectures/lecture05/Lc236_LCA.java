package io.gkd.lectures.lecture05;

import io.gkd.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Medium
 * 236.https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * 向上标记法
 */
public class Lc236_LCA {

    // 存储每个节点的 father
    private Map<Integer, TreeNode> father;

    // Time: O(n)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.father = new HashMap<>();     // TreeNode.val -> root TreeNode
        calcFather(root);
        // 存储其中一个节点的所有祖先
        Set<TreeNode> redNodes = new HashSet<>();
        redNodes.add(root);
        // 记录从 p 向上的所有祖先，标记为红色
        while(p != root) {
            redNodes.add(p);
            p = father.get(p.val);
        }
        // 在 p 的祖先中找到距离 q 最近的祖先，即 q 向上走，走到距离最近的一个红点
        while (!redNodes.contains(q)) {
            q = father.get(q.val);
        }
        return q;
    }

    // 深度优先遍历记录每个节点的父节点
    private void calcFather(TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            father.put(root.left.val, root);
            calcFather(root.left);
        }
        if (root.right != null) {
            father.put(root.right.val, root);
            calcFather(root.right);
        }
    }
}
