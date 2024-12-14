package org.example.stackqueue;

public class MyQueue {
    int front, rear;
    int[] arr = new int[100005];

    public MyQueue() {
        front = 0;
        rear = 0;
    }

    //Function to push an element x in a queue.
    public void push(int x) {
        if (rear != 100004) {
            arr[rear] = x;
            rear++;
        }
    }

    //Function to pop an element from queue and return that element.
    public int pop() {
        if (front == rear) {
            return -1;
        }
        int poppedElement = arr[front];
        for (int i = 0; i <= rear; i++) {
            arr[i] = arr[i + 1];
        }
        rear--;
        return poppedElement;
    }
}
