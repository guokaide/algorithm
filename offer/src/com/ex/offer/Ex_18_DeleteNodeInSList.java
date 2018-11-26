package com.ex.offer;

public class Ex_18_DeleteNodeInSList {

    public static Node deleteNode(Node head, Node toBeDeleted) {
        if (head == null || toBeDeleted == null) {
            return head;
        }

        // toBeDeleted is not tail
        if (toBeDeleted.next != null) {
            Node temp = toBeDeleted.next;
            toBeDeleted.val = temp.val;
            toBeDeleted.next = temp.next;
            temp = null;
        } else if (head == toBeDeleted){  // toBeDeleted is tail and list length = 1
            toBeDeleted = null;
            head = null;
        } else { // // toBeDeleted is tail and list length != 1
            Node pNode = head;
            while (pNode.next != toBeDeleted) {
                pNode = pNode.next;
            }
            pNode.next = null;
        }

        return head;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.next = null;
        Node head1 = deleteNode(node1, node1);  // case 2:注意 Java中是值传递
        TestUtils.printList(head1);

        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        Node head2 = deleteNode(node2, node2); // case 1
        TestUtils.printList(head2);

        Node head3 = deleteNode(head2, node5); // case 3
        TestUtils.printList(head3);
    }

}


