package queue;

public class ListQueue<T> implements Queue<T> {

    Node head = null;
    Node tail = null;

    // T(N)=O(1)
    @Override
    public boolean enqueue(T item) {
        Node newNode = new Node(item, null);
        if (tail == null) {
            tail = newNode;
            head = newNode;
            return true;
        }

        tail.next = newNode;
        tail = tail.next;

        return true;
    }

    // T(N)=O(1)
    @Override
    public T dequeue() {
        if (head == null) {
            return null;
        }

        Node tmp = head;
        head = head.next;
        tmp.next = null;

        return (T) tmp.getData();
    }

    // for test
    public void printAll() {
        System.out.print("[");
        for (Node p = head; p != null; p = p.next) {
            System.out.print(p.getData() + " ");
        }
        System.out.print("]");
        System.out.println();
    }

    private static class Node<T>{
        private T data;
        private Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return this.data;
        }
    }

    public static void main(String[] args) {
        ListQueue<String> queue = new ListQueue<>();
        queue.printAll();
        queue.enqueue("A");
        queue.printAll();
        queue.enqueue("B");
        queue.enqueue("C");
        queue.enqueue("D");
        queue.printAll();
        queue.enqueue("E");
        queue.printAll();

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.printAll();
    }
}
