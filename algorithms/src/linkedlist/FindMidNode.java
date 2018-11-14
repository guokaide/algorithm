package linkedlist;

public class FindMidNode {

    // 1. T(n) = O(2*n) 遍历2次
    public static Node findMidNode(Node head) {
        if (head == null) {
            return null;
        }

        int len = 0;
        Node p = head;

        while(p != null) {
            len++;
            p = p.next;
        }

        p = head;
        for (int i = 0; i < len/2; i++) {
            p = p.next;
        }

        return p;
    }

    // 2. T(n) = O(n) 遍历1次
    // 快慢指针法
    public static Node findMidNodeFast(Node head) {
        if (head == null) {
            return null;
        }

        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }


    public static Node createNode(int value) {
        return new Node(value, null);
    }

    public static class Node {
        public int data;
        public Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
