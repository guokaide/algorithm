package com.ex.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Ex_06_PrintListFromTailToHead {

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) {
            return new ArrayList<>();
        }

        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (ListNode node = listNode; node != null; node = node.next) {
            stack.push(node.val);
        }

        while(!stack.isEmpty()) {
            list.add(stack.pop());
        }

        return list;
    }

    public static ArrayList<Integer> printListFromTailToHeadRecur(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();

        if (listNode != null) {

            if (listNode.next != null) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp = printListFromTailToHeadRecur(listNode.next);
                for (Integer i : temp) {
                    list.add(i);
                }
            }

            list.add(listNode.val);
        }

        return list;
    }

    public static ArrayList<Integer> printListFromTailToHeadWithCollections(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();

        for (ListNode p = listNode; p != null; p = p.next) {
            list.add(p.val);
        }

        Collections.reverse(list);
        return list;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ArrayList<Integer> list = new ArrayList<>();
        list = printListFromTailToHeadRecur(head);

    }
}

