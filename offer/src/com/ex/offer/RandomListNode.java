package com.ex.offer;

/**
 * 含有指向随机节点指针的单链表节点
 */
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
