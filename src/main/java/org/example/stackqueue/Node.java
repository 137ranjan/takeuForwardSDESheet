package org.example.stackqueue;

public class Node {
    private int key;
    private int val;
    private Node next;
    private Node prev;

    public Node(int key, int val){
        this.key = key;
        this.val = val;
    }
    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
    @Override
    public String toString() {
        return "{" + key + "," + val + "}";
    }

}
