package org.example.listarrays;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {
    public static void printRandomNodeList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
        System.out.println("null");

        System.out.println("Random");
        curr = head;
        while (curr != null) {
            System.out.println(curr.val + "->" + (curr.random != null ? curr.random.val : "null"));
            curr = curr.next;
        }
    }

    public static Node copyRandomListUsingHashMap(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node temp = head;
        while (temp != null) {
            Node copyNode = new Node(temp.val);
            map.put(temp, copyNode);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            Node copyNode = map.get(temp);
            copyNode.next = map.get(temp.next);
            copyNode.random = map.get(temp.random);
            temp = temp.next;
        }
        return map.get(head);
    }

    public static Node copyRandomListOptimal(Node head) {
        Node curr = head;
        while (curr != null) {
            Node copyNode = new Node(curr.val);
            copyNode.next = curr.next;
            curr.next = copyNode;
            curr = curr.next.next;
        }
        curr = head;
        while (curr != null) {
            Node copyCurr = curr.next;
            if (curr.random != null) {
                copyCurr.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        Node dummyNode = new Node(-1);
        Node res = dummyNode;
        curr = head;
        while (curr != null) {
            res.next = curr.next;
            curr.next = curr.next.next;
            res = res.next;
            curr = curr.next;
        }

        return dummyNode.next;
    }
}
