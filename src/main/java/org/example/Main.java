package org.example;

import java.util.Arrays;

import org.example.stackqueue.MaximumOfMinimumForEveryWindow;

public class Main {
	public static void main(String[] args) {
		int[] a = { 3, 3, 4, 2, 4 };
		int[] result = MaximumOfMinimumForEveryWindow.maxMinWindow(a, a.length);
		System.out.println(Arrays.toString(result));

	}
}