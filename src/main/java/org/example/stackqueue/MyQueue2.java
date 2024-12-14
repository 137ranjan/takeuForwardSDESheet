package org.example.stackqueue;

import java.util.Stack;

public class MyQueue2 {

    private Stack<Integer> stack;

    public MyQueue2() {
        stack = new Stack<>();
    }

    public void push(int x) {
        Stack<Integer> tempStack = new Stack<>();
        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }
        stack.push(x);
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

    public int pop() {
        return stack.pop();
    }

    public int peek() {
        return stack.peek();
    }

    public boolean empty() {
        return stack.isEmpty();
    }

}
