package com.ex.offer;

import java.util.HashMap;
import java.util.Map;

public class Ex_35_CloneList {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if (pHead == null) return pHead;

        RandomListNode node = pHead;

        // A - A' - B - B' - C - C' - null
        while (node != null) {
            RandomListNode cloneNode = new RandomListNode(node.label);
            cloneNode.next = node.next;
            node.next = cloneNode;

            node = cloneNode.next;
        }

        // 设置Random
        node = pHead;
        while (node != null) {
            RandomListNode cloneNode = node.next;
            if (node.random != null) cloneNode.random = node.random.next;

            node = cloneNode.next;
        }

        RandomListNode head = pHead.next;

        // 拆分链表
        node = pHead;
        RandomListNode node1 = head;
        while (node != null) {
            node.next = node1.next;
            node = node.next;
            if (node == null) break;
            node1.next = node.next;
            node1 = node1.next;
        }
        return head;

    }

    public RandomListNode Clone1(RandomListNode pHead)
    {
        if (pHead == null) return pHead;

        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode node = pHead;

        while (node != null) {
            map.put(node, new RandomListNode(node.label));
        }

        for (RandomListNode key : map.keySet()) {
            map.get(key).next = map.get(key.next);
            map.get(key).random = map.get(key.random);
        }

        return map.get(0);
    }
}
