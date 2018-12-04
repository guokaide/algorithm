package stack;

public interface Stack<T> {
    boolean push(T item);
    T pop();
    T peek();
}
