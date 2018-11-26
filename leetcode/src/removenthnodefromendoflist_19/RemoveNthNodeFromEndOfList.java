package removenthnodefromendoflist_19;

/**
* 19. Remove Nth Node From End of List
* https://leetcode.com/problems/remove-nth-node-from-end-of-list/
*/
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;

        for (int i = 0; i < n; i++) {
            p1 = p1.next;
        }

        ListNode p2 = head; // 要删除的节点
        ListNode pre = null;

        while (p1 != null) {
            p1 = p1.next;
            pre = p2;
            p2 = p2.next;
        }

        if (p2 == head) {  // 要删除的节点为head,特殊处理
            head = head.next;
        } else {
            pre.next = p2.next;
            p2.next = null;
        }

        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            this.val = val;
        }
    }
}
