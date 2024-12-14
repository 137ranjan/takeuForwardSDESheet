package org.example.stackqueue;

import java.util.Stack;

public class LargestRectangleArea {
    public int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = height.length;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[stack.peek()] > height[i]) {
                int elementIndex = stack.pop();
                int nse = i;
                int pse = stack.isEmpty() ? -1 : stack.peek();
                maxArea = Math.max(maxArea, height[elementIndex] * (nse - pse - 1));
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int elementIndex = stack.pop();
            int nse = n;
            int pse = stack.isEmpty() ? -1 : stack.peek();

            maxArea = Math.max(maxArea, height[elementIndex] * (nse - pse - 1));
        }

        return maxArea;
    }
}
