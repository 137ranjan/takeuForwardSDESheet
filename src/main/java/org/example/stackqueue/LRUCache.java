package org.example.stackqueue;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private final Map<Integer, Node> map;
    private final int capacity;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.setNext(tail);
        tail.setPrev(head);
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        deleteNode(node);
        insertAfterHead(node);
        return node.getVal();
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.setVal(value);
            deleteNode(node);
            insertAfterHead(node);
        } else {
            if (map.size() == capacity) {
                Node node = tail.getPrev();
                map.remove(node.getKey());
                deleteNode(node);
            }

            Node newNode = new Node(key, value);
            map.put(key, newNode);
            insertAfterHead(newNode);

        }
    }

    private void deleteNode(Node node) {
        Node prevNode = node.getPrev();
        Node afterNode = node.getNext();
        prevNode.setNext(afterNode);
        afterNode.setPrev(prevNode);
    }

    private void insertAfterHead(Node node) {
        node.setNext(head.getNext());
        node.setPrev(head);
        head.getNext().setPrev(node);
        head.setNext(node);
    }

    public void printLRUCache() {
        Node curr = head.getNext();
        while (curr != tail) {
            System.out.print(curr + " ");
            curr = curr.getNext();
        }
        System.out.println();
    }
}
