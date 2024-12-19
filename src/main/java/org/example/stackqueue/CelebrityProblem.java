package org.example.stackqueue;

public class CelebrityProblem {

	// Brute force
	public int findCelebrity(int[][] mat) {
		int n = mat.length;
		int[] iKnow = new int[n];
		int[] knowMe = new int[n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (mat[i][j] == 1) {
					iKnow[i]++;
					knowMe[j]++;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			if (iKnow[i] == 0 && knowMe[i] == n - 1) {
				return i;
			}
		}
		return -1;
	}
}
