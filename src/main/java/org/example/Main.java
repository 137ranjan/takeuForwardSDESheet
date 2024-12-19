package org.example;

import org.example.stackqueue.CelebrityProblem;

public class Main {
	public static void main(String[] args) {
		int[][] mat = {
				{ 0, 0, 0, 0 },
				{ 1, 1, 1, 0 },
				{ 1, 1, 0, 1 },
				{ 1, 0, 1, 1 }
		};
		CelebrityProblem solution = new CelebrityProblem();
		int result = solution.findCelebrity2(mat);
		System.out.println(result);
	}
}