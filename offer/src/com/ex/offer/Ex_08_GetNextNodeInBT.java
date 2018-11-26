package com.ex.offer;


/**
 * 后继节点
 */
public class Ex_08_GetNextNodeInBT {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }

        if (pNode.right != null) {
            return getMostLeft(pNode.right);
        } else {
            TreeLinkNode parent = pNode.parent;
            while (parent != null && parent.left != pNode) {
                pNode = parent;
                parent = parent.parent;
            }
            return parent;
        }
    }

    private TreeLinkNode getMostLeft(TreeLinkNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}


