package com.ex.offer;

import org.junit.Test;

public class Ex_22_FindKthNodeToTail {
    /**
     * 1. 空链表
     * 2. k <= 0
     * 3. k > len
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head, int k) {
        // 1. 边界条件： head == null k <= 0
        if (head == null || k <= 0) return null;

        ListNode before = head;
        ListNode after = head;

        for (int i = 0; i < k-1; i++) {
            before = before.next;
        }
        // 2. n < k: 第k个元素before已经到null，则k > n
        if (before == null) return null;

        while (before.next != null) {
            before = before.next;
            after = after.next;
        }

        return after;
    }

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        FindKthToTail(head, 5);
    }

}
