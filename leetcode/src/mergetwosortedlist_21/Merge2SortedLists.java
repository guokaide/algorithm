package mergetwosortedlist_21;

/**
 * 21. Merge Two Sorted Lists
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class Merge2SortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode outpost = new ListNode(-1);
        ListNode temp = outpost;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }

            temp = temp.next;
        }

        if (l1 == null) {
            temp.next = l2;
        }

        if (l2 == null) {
            temp.next = l1;
        }

        return outpost.next;
    }
	
	public ListNode mergeTwoListsRecur(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
		if (l1.val < l2.val) {
			l1.next = mergeTwoListsRecur(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoListsRecur(l1, l2.next);
			return l2;
		}
	}

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x;}
    }
}
