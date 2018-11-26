package com.ex.offer;

import java.util.LinkedList;
import java.util.Queue;

public class Ex_09_StackWithTwoQueue {

    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    public void push(int node) {
        queue1.add(node);
    }

    public int pop() {
        int res = 0;

        while (!queue1.isEmpty()) {
            res = queue1.poll();

            if (!queue1.isEmpty()) {
                queue2.add(res);
            }
        }

        while (!queue2.isEmpty()) {
            queue1.add(queue2.poll());
        }

        return res;
    }

    public static void main(String[] args) {
        Ex_09_StackWithTwoQueue stack = new Ex_09_StackWithTwoQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
