package com.ex.offer;

public class Ex_24_ReverseSList {

    public ListNode ReverseList(ListNode head) {
        if (head == null) return null;

        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null; // 指向剩余的需要被reverse的链表

        while (cur != null) {
            next = cur.next;  // 记录：剩余的需要被reverse的链表
            cur.next = pre;   // 核心：cur -> pre
            pre = cur;        // 更新pre
            cur = next;       // 更新cur
        }

        head = pre;
        return head;
    }

    public ListNode reverseList(ListNode head) {
        //若是空链表或者tail节点
        if (head == null || head.next == null) return head;

        //先反转 head.next -> ...  例如： 1->2->3->4->null  1-> |2<-3<-4|
        ListNode reverseHead = reverseList(head.next);
        //修改head指向             null <- 1 <- |2<-3<-4|
        head.next.next = head;
        head.next = null;
        return reverseHead;
    }



}
