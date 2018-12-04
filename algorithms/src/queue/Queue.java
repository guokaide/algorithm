package queue;

public interface Queue<T> {
    boolean enqueue(T item);
    T dequeue();
}
