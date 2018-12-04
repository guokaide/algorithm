package stack;

public class ListStack<T> implements Stack<T> {
    private Node top = null;

    // T(N)=O(1)
    @Override
    public boolean push(T item) {
        Node newNode = new Node(item, null);

        // 需要判断栈是否为空
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        return true;
    }

    // T(N)=O(1)
    @Override
    public T pop() {
        if (top == null) {
            return null;
        }

        Node tmp = top;

        top = top.next;
        tmp.next = null;  // 释放删除的top

        return (T) tmp.getData();
    }

    // T(N)=O(1)
    @Override
    public T peek() {
        return (T) top.getData();
    }

    public static class Node<T> {
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
}
