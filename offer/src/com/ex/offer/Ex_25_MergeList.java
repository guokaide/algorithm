package com.ex.offer;

import org.junit.Test;

public class Ex_25_MergeList {

    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode head = null;

        if (list1.val < list2.val) {
            head = list1;
            head.next = Merge(list1.next, list2);
        } else {
            head = list2;
            head.next = Merge(list1, list2.next);
        }

        return head;
    }

    public ListNode Merge1(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode pre = new ListNode(-1);

        ListNode node = pre;

        ListNode p1 = list1;
        ListNode p2 = list2;

        while (p1 != null && p2 != null) {
            while (p1 != null && p1.val < p2.val) {
                node.next = new ListNode(p1.val);
                node = node.next;
                p1 = p1.next;
            }

            if (p1 == null) {
                while (p2 != null) {
                    node.next = new ListNode(p2.val);
                    node = node.next;
                    p2 = p2.next;
                }
            }

            while (p2 != null && p2.val < p1.val) {
                node.next = new ListNode(p2.val);
                node = node.next;
                p2 = p2.next;
            }

            if (p2 == null) {
                while (p1 != null) {
                    node.next = new ListNode(p1.val);
                    node = node.next;
                    p1 = p1.next;
                }
            }
        }

        return pre.next;
    }

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(5);

        ListNode head1 = new ListNode(2);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(6);
        ListNode h = Merge(head, head1);
        TestUtils.printList_ListNode(h);
    }

    @Test
    public void test1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(5);

        ListNode head1 = new ListNode(2);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(6);

        ListNode h1 = Merge1(head, head1);
        TestUtils.printList_ListNode(h1);
    }

}
