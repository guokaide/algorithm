package com.ex.offer;

public class Ex_37_SerializeBT {
    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        if (root == null) {
            return sb.toString();
        }

        serialize(root, sb);
        return sb.toString();
    }

    void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
            return;
        }

        sb.append(root.val + ",");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    int index = -1;
    TreeNode Deserialize(String str) {
        if (str.length() == 0) return null;
        String[] strs = str.split(",");
        return Deserialize(strs);
    }

    TreeNode Deserialize(String[] strs) {
        index++; // 遍历strs,待返回root时，遍历结束
        TreeNode node = null;
        if (!strs[index].equals("#")) {
            node = new TreeNode(Integer.parseInt(strs[index]));
            node.left = Deserialize(strs);
            node.right = Deserialize(strs);
        }
        return node;
    }
}
