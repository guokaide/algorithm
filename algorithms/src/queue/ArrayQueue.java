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

    @Override
    public boolean enqueue(T item) {

        return false;
    }

    @Override
    public T deque() {

        return null;
    }
}
