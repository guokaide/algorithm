package queue;

public class CircularQueue<T> {
    private T[] items;
    private int capacity;
    private int head;
    private int tail;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.items = (T[]) new Object[capacity];
        this.head = 0;
        this.tail = 0;
    }

    // T(N)=O(1)
    public boolean enqueue(T item) {
        // 队满条件
        if ((tail + 1) % capacity == head) {
            return false;
        }

        items[tail] = item;
        tail = (tail + 1) % capacity;
        return true;
    }

    // T(N)=O(1)
    public T dequeue() {
        // 队空
        if (head == tail) {
            return null;
        }

        T tmp = items[head];
        items[head] = null;  // 这里可以选择置为nulL,也可以不置为null.
        head = (head + 1) % capacity;

        return tmp;
    }

    // for test
    public void printAll() {
        System.out.print("[");
        for (int i = 0;  i < capacity; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.print("]");
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueue<java.lang.String> queue = new CircularQueue<>(4);
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
        queue.enqueue("E");
        queue.printAll();
    }
}
