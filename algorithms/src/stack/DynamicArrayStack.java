package stack;

/**
 * 支持动态扩容的栈
 *
 * @param <T>
 */
public class DynamicArrayStack<T> implements Stack<T> {
    private T[] items;
    private int size;
    private int capacity;

    public DynamicArrayStack(int capacity) {
        this.capacity = capacity;
        this.items = (T[]) new Object[capacity];
        this.size = 0;
    }

    // T(N)=O(1): 思考一下，这里涉及到了数组的动态扩容，
    // 那么时间复杂度为什么仍然是O(1)
    @Override
    public boolean push(T item) {
        if (size == capacity) {
            capacity = capacity * 2;
            resize(capacity);
        }

        items[size] = item;
        size++;

        return false;
    }

    // T(N)=O(1)
    @Override
    public T pop() {
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

    private void resize(int size) {
        T[] tmp = (T[]) new Object[size];
        for (int i = 0; i < this.capacity; i++) {
            tmp[i] = this.items[i];
        }

        this.items = tmp;
    }
}
