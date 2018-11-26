package com.ex.offer;

/**
 * 含有指向父节点指针的二叉树节点
 * Ex_08_GetNextNodeInBT
 */
public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode parent = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
