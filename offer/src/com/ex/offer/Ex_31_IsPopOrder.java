package com.ex.offer;

import java.util.Stack;

public class Ex_31_IsPopOrder {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();

        int index = 0;
        // push:   1 2 3 4 5
        // pop :   4 5 3 2 1
        // stack : 1 2 3 -4-    |  <- 5 push: empty   pop: 4 5 3 2 1
        // stack : 1 2 3  5     |       push: empty   pop: 5 3 2 1
        for (int i = 0; i < pushA.length; i++) {
            while (!stack.isEmpty() && popA[index] == stack.peek()) {
                stack.pop();  // 遍历完push之前pop出去的
                index++;
            }
            stack.push(pushA[i]);
        }

        // 遍历完push之后pop出去的
        while (!stack.isEmpty() && popA[index] == stack.peek()) {
            stack.pop();
            index++;
        }

        return stack.isEmpty();
    }
}
