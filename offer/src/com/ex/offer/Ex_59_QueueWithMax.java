package com.ex.offer;

import org.junit.Test;

import java.util.LinkedList;

public class Ex_59_QueueWithMax {
    private LinkedList<Integer> data = new LinkedList<>();
    private LinkedList<Integer> qMax = new LinkedList<>();

    public void push_back(Integer x) {

        if (!qMax.isEmpty() && qMax.peekLast() > x) {
            qMax.addLast(qMax.peek());
        }

        qMax.addLast(x);
        data.addLast(x);
    }

    public Integer pop_front() {
        if (!data.isEmpty()) {
            qMax.pollFirst();
            return data.pollFirst();
        }

        return null;
    }

    public Integer max() {
        if (!qMax.isEmpty()) {
            return qMax.peekFirst();
        }
        return null;
    }
}
