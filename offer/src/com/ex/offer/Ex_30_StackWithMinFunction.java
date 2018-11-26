package com.ex.offer;

import java.util.Stack;

public class Ex_30_StackWithMinFunction {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> help = new Stack<>();

    public void push(int node) {
        stack.push(node);

        if (help.isEmpty()) {
            help.push(node);
        }

        if (help.peek() >= node) {
            help.push(node);
        } else {
            help.push(help.peek());
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
            help.pop();
        }
    }

    public int top() {
        if (!stack.isEmpty()) {
            return stack.peek();
        }
        return -1;
    }

    public int min() {
        if (!help.isEmpty()) {
            return help.peek();
        }
        return -1;
    }
}
