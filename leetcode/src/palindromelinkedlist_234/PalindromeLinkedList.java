package palindromelinkedlist_234;

/**
 * 234. Palindrome Linked List
 * https://leetcode.com/problems/palindrome-linked-list/
 * Solution:
 * 1. 找到中间节点，将单链表后半段逆置
 * 2. 左半段从左到右，右半段从右到左，比较2段链表是否对应相等
 * 3. 对比完之后，最好能将右半段逆置，还原链表
 * 示例：
 * 1->2->2->1
 * 1->2->2<-1  (第2个2指向null)
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        // 1. 找到单链表的中间节点
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;   // 此时slow就是中间节点
        }

        // 2. 从中间节点开始，将右半段链表逆置
        ListNode pre = null;
        ListNode next = null;

        while (slow != null) {
            next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }

        // 3. 左半段从左到右，右半段从右到左，比较2段链表是否对应相等
        fast = head;
        slow = pre;

        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }

        // 4. 对比完之后，最好能将右半段逆置，还原链表

        return true;

    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            this.val = val;
        }
    }
}
