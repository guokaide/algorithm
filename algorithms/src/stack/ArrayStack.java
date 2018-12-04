package stack;

public class ArrayStack<T> implements Stack<T> {
    private T[] items;     // 数组
    private int size;      // 栈中元素的个数
    private int capacity;  // 栈的容量


    public ArrayStack(int capacity) {
        this.capacity = capacity;
        this.items = (T[]) new Object[capacity];
        this.size = 0;
    }

    // T(N)=O(1)
    @Override
    public boolean push(T item) {
        // 数组空间不足，无法push
        if (size == capacity) {
            return false;
        }

        // size为待push的位置
        items[size] = item;
        size++;

        return true;
    }

    // T(N)=O(1)
    @Override
    public T pop() {
        // 数组为空，无法pop
        if (size == 0) {
            return null;
        }

        T item = items[size-1];
        size--;

        return item;
    }

    // T(N)=O(1)
    @Override
    public T peek() {
        return items[size-1];
    }
}
