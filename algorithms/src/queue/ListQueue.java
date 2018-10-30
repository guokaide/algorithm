package queue;

public class ListQueue<T> implements Queue<T> {
    @Override
    public boolean enqueue(T item) {
        return false;
    }

    @Override
    public T deque() {
        return null;
    }
}
