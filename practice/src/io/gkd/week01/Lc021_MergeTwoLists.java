package io.gkd.week01;

import io.gkd.ListNode;

/**
 * Easy
 * 21. https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class Lc021_MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode();
        ListNode cur = sentinel;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) {
            cur.next = l1;
        } else {
            cur.next = l2;
        }
        return sentinel.next;
    }
}
