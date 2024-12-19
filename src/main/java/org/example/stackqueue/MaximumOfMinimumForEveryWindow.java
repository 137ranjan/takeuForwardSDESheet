package org.example.stackqueue;

import java.util.Arrays;
import java.util.Stack;

public class MaximumOfMinimumForEveryWindow {
	public static int[] maxMinWindow(int[] a, int n) {
		int[] prevSmaller = new int[n];
		int[] nextSmaller = new int[n];
		Arrays.fill(prevSmaller, -1);
		Arrays.fill(nextSmaller, n);

		// Stack for prevSmaller element
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && a[stack.peek()] >= a[i]) {
				stack.pop();
			}
			if (!stack.isEmpty()) {
				prevSmaller[i] = stack.peek();
			}
			stack.push(i);
		}

		// Stack for Next Smaller Element
		stack.clear();
		for (int i = n - 1; i >= 0; i--) {
			while (!stack.isEmpty() && a[stack.peek()] >= a[i]) {
				stack.pop();
			}
			if (!stack.isEmpty()) {
				nextSmaller[i] = stack.peek();
			}
			stack.push(i);
		}

		// Calculate the maximum of minimums for each window size
		int[] maxOfMins = new int[n + 1];
		for (int i = 0; i < n; i++) {
			// Calculate span of the window where a[i] is minimum
			int span = nextSmaller[i] - prevSmaller[i] - 1;
			maxOfMins[span] = Math.max(maxOfMins[span], a[i]);
		}

		// Fill the result array by propagating maximums
		for (int i = n - 1; i >= 1; i--) {
			maxOfMins[i] = Math.max(maxOfMins[i], maxOfMins[i + 1]);
		}

		// Build the output for window sizes 1 to n
		int[] result = new int[n];
		for (int i = 1; i <= n; i++) {
			result[i - 1] = maxOfMins[i];
		}
		return result;
	}
}
