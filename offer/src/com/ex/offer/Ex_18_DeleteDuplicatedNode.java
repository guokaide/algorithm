package com.ex.offer;

public class Ex_18_DeleteDuplicatedNode {

    public static ListNode deleteDuplication (ListNode pHead) {
        ListNode first = new ListNode(-1);  // 设置一个前哨节点,不用考虑pre为空的情况

        first.next = pHead;

        ListNode last = first;
        ListNode p = pHead;

        while (p != null && p.next != null) {
            if (p.val == p.next.val) {
                int val = p.val;
                while (p != null && p.val == val) {
                    p = p.next;
                }

                last.next = p;
            } else {
                last = p;
                p = p.next;
            }
        }

        return first.next;
    }

    public static ListNode deleteDuplication1 (ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }

        ListNode pre = null;
        ListNode cur = pHead;

        while (cur != null) {
            ListNode next = cur.next;
            boolean needDelete = false;

            if (next != null && cur.val == next.val) {
                needDelete = true;
            }

            if (!needDelete) {
                pre = cur;
                cur = next;
            } else {
                int val = cur.val;

                while (cur != null && cur.val == val) {
                    cur = cur.next;
                }

                if (pre == null) {
                    pHead = cur;
                } else {
                    pre.next = cur;
                }
            }
        }

        return pHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);


        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode h1 = deleteDuplication1(head);

        TestUtils.printList_ListNode(h1);
    }
}


