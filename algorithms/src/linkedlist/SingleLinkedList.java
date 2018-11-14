package linkedlist;

public class SingleLinkedList {

    private Node head = null;

    // 1. search
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

    // 2. Insert
    public void insertToHead(int value) {
        Node newNode = createNode(value);
        insertToHead(newNode);
    }

    public void insertToHead(Node newNode) {
        if (newNode == null) {
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void insertToTail(int value) {
        Node newNode = createNode(value);
        insertToTail(newNode);
    }

    public void insertToTail(Node newNode) {
        if (newNode == null) {
            return;
        }

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }


    public void insertAfter(Node p, int value) {
        Node newNode = createNode(value);
        insertAfter(p, newNode);
    }

    public void insertAfter(Node p, Node newNode) {
        if (p == null || newNode == null) {
            return;
        }

        newNode.next = p.next;
        p.next = newNode;
    }

    public void insertBefore(Node p, int value) {
        Node newNode = createNode(value);
        insertBefore(p, newNode);
    }

    public void insertBefore(Node p, Node newNode) {
        if (p == null || newNode == null) {
            return;
        }

        if (p == head) {
            insertToHead(newNode);
            return;
        }

        Node before = head;
        while (before.next != p) {
            before = before.next;
        }

        if (before == null) {
            return;
        } else {
            newNode.next = p;
            before.next = newNode;
        }
    }

    // 3. delete
    public void deleteByNode(Node p) {
        if (head == null || p == null) {
            return;
        }

        if (p == head) {
            head = head.next;
            return;
        }

        Node before = head;
        while (before.next != p) {
            before = before.next;
        }

        if (before == null) {
            return;
        } else {
            before.next = p.next;
        }
    }

    public void deleteByValue(int value) {
        Node before = null;
        for (Node p = head; p != null; p = p.next) {
            if (p.getData() == value) {
                if (p == head) {
                    head = head.next;
                    p = head;
                } else {
                    before.next = p.next;
                    p = before;
                }
            }
            before = p;
        }
    }

    public void printAll() {
        System.out.print("SingleLinkedList: [");
        for (Node p = head; p != null; p = p.next) {
            System.out.print(p.getData());
            if (p.next != null) {
                System.out.print(",");
            }
        }
        System.out.print("]");
        System.out.println();
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


