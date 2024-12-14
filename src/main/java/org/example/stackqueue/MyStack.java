package org.example.stackqueue;

public class MyStack {
    private int[] arr;
    private int top;

    public MyStack() {
        arr = new int[1000];
        top = -1;
    }

    public void push(int x) {
        if (top < 998) {
            top++;
            arr[top] = x;
        }
    }

    public int pop() {
        if (top > -1) {
            int x = arr[top];
            top--;
            return x;
        }
        return -1;
    }
}
