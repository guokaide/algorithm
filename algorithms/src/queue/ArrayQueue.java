package queue;

public class ArrayQueue<T> implements Queue<T> {
    private T[] items;
    private int capacity;
    private int head;
    private int tail;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        this.items = (T[]) new Object[capacity];
        this.head = 0;
        this.tail = 0;
    }

    // T(N)=O(1)
    @Override
    public boolean enqueue(T item) {
        if (tail == capacity) {
            // head == 0 && tail == capacity, queue is full.
            if (head == 0) {
                return false;
            }

            // 数据搬移，空出位置
            for (int i = head; i < tail; i++) {
                items[i-head] = items[i];
            }
			
	    // 搬移完之后，更新head和tail
	    tail -= head;
            head = 0;
        }

        items[tail] = item;
        tail++;

        return true;
    }

    // T(N)=O(1)
    @Override
    public T dequeue() {
        if (head == tail) {
            return null;
        }

        T tmp = items[head];
        head++;

        return tmp;
    }

    // for test
    public void printAll() {
        System.out.print("[");
        for (int i = head;  i < tail; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.print("]");
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayQueue<String> queue = new ArrayQueue<>(4);
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
