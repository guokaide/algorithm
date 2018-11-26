package com.ex.offer;

import org.junit.Test;

public class Ex_22_FindMedianNodeInList {

    public ListNode findMedian(ListNode head) {
        if (head == null) return null;

        ListNode before = head;
        ListNode after = head;

        while (before.next != null && before.next.next != null) {
            before = before.next.next;
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
        //head.next.next.next.next = new ListNode(5);
        System.out.println(findMedian(head).val);
    }
}
