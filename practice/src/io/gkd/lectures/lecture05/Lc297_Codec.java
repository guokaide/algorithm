package io.gkd.lectures.lecture05;

import io.gkd.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hard
 * 297. https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 */
public class Lc297_Codec {

    // deserialized string list
    private List<String> seq = new ArrayList<>();
    // deserialized string list pointer
    private int curr;

    // Encodes a tree to a single string.
    // 1 2 null null 3 4 null null 5 null null
    public String serialize(TreeNode root) {
        traverse(root);
        return String.join(" ", seq);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        seq = Arrays.asList(data.split(" "));
        curr = 0;
        return calc();
    }

    private TreeNode calc() {
        if (seq.get(curr).equals("null")) {
            curr++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(seq.get(curr)));
        curr++;
        root.left = calc();
        root.right = calc();
        return root;
    }

    private void traverse(TreeNode root) {
        // for judge leaf node
        if (root == null) {
            seq.add("null");
            return;
        }
        seq.add(Integer.toString(root.val));
        traverse(root.left);
        traverse(root.right);
    }
}
