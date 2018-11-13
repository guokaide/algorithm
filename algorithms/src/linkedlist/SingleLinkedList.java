package linkedlist;

public class SingleLinkedList {

    private Node head = null;

    public Node findByValue(int value) {
        if (head == null) {
            return null;
        }

        for (Node p = head; p != null; p = p.next) {
            if (p.data == value) return p;
        }

        return null;
    }

    public Node findByIndex(int index) {
        if (head == null || index < 0) {
            return null;
        }

        int temp = 0;
        for (Node p = head; p != null; p = p.next) {
            if (temp == index) return p;
            temp++;
        }

        return null;
    }

    public void printAll() {
        System.out.print("SingleLinkedList: [");
        for (Node p = head; p != null; p = p.next) {
            System.out.print(p.getData() + ",");
        }
        System.out.print("]");
    }


    public static Node createNode(int value) {
        return new Node(value, null);
    }

    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }
}


