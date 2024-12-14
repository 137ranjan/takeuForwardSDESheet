package org.example.stackqueue;

import java.util.Stack;

public class MinStack {
    private final Stack<Long> stack;
    private long min;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(0L);
            min = val;
        } else {
            stack.push((long) val - min);
            if (val < min) {
                min = val;
            }
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            long diff = stack.pop();
            if (diff < 0) {
                min = min - diff;
            }
        }
    }

    public int top() {
        if (!stack.isEmpty()) {
            long diff = stack.peek();
            if (diff > 0) {
                return (int) (min + diff);
            } else {
                return (int) min;
            }
        }
        return -1;
    }

    public int getMin() {
        return (int) min;
    }
}
