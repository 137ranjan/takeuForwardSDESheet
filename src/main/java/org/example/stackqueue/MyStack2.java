package org.example.stackqueue;

import java.util.Queue;
import java.util.LinkedList;

public class MyStack2 {
    private Queue<Integer> q;

    public MyStack2() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        int size = q.size();
        q.add(x);
        for (int i = 0; i < size; i++) {
            q.add(q.remove());
        }
    }

    public int pop() {
        return q.remove();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}
