package stack;

public class ArrayStack<T> implements Stack<T> {
    private T[] items;     // 数组
    private int top;       // 栈中元素的个数（或者说是栈顶指针）
    private int capacity;  // 栈的容量


    public ArrayStack(int capacity) {
        this.capacity = capacity;
        this.items = (T[]) new Object[capacity];
        this.top = 0;
    }

    // T(N)=O(1)
    @Override
    public boolean push(T item) {
        // 数组空间不足，无法push
        if (top == capacity) {
            return false;
        }

        // size为待push的位置
        items[top] = item;
        top++;

        return true;
    }

    // T(N)=O(1)
    @Override
    public T pop() {
        // 数组为空，无法pop
        if (top == 0) {
            return null;
        }

        T item = items[top -1];
        top--;

        return item;
    }

    // T(N)=O(1)
    @Override
    public T peek() {
        if (top == 0) {
            return null;
        }
        return items[top -1];
    }

    public static void main(String[] args) {
        ArrayStack<String> stack = new ArrayStack<>(4);
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.peek());
    }
}
