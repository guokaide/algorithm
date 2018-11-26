package com.ex.offer;

import java.util.Stack;

/**
 * problem 9: 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */

public class Ex_09_QueueWithTwoStack {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        int res = 0;
        while (!stack1.isEmpty()) {
            res = stack1.pop();
            if (!stack1.isEmpty()) {
                stack2.push(res);
            }
        }

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return res;
    }

}
