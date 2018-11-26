package com.ex.offer;

public class Ex_52_FirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }

        int len1 = getLengthOfList(pHead1);
        int len2 = getLengthOfList(pHead2);
        int diff = Math.abs(len1-len2);

        ListNode longListHead = len1 > len2 ? pHead1 : pHead2;
        ListNode shortListHead = len1 < len2 ? pHead1 : pHead2;

        for (int i = 0; i < diff; i++) {
            longListHead = longListHead.next;
        }

        while (longListHead != null && longListHead.val != shortListHead.val) {
            longListHead = longListHead.next;
            shortListHead = shortListHead.next;
        }

        return longListHead != null ? longListHead : null;
    }

    private int getLengthOfList(ListNode pHead1) {
        if (pHead1 == null) {
            return 0;
        }

        int len = 0;
        for (ListNode node = pHead1; node != null; node = node.next) {
            len++;
        }

        return len;
    }
}
