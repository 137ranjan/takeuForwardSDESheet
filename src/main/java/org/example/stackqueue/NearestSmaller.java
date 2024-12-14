package org.example.stackqueue;

import java.util.ArrayList;
import java.util.Stack;

public class NearestSmaller {
    public static ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        Stack<Integer> s = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < A.size(); i++) {
            while (!s.isEmpty() && s.peek() >= A.get(i)) {
                s.pop();
            }
            if (s.isEmpty()) {
                result.add(-1);
            } else {
                result.add(s.peek());
            }
            s.push(A.get(i));
        }
        return result;
    }
}
