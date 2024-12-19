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

    //Efficient approach
    public int findCelebrity2(int[][] mat) {
        int n = mat.length;
        int top = 0;
        int down = n - 1;
        while (top < down) {
            if (mat[top][down] == 1) {
                top = top + 1;
            } else if (mat[down][top] == 1) {
                down = down - 1;
            } else {
                top--;
                down--;
            }
        }
        if (top > down) return -1;
        for (int i = 0; i < n; i++) {
            if (i == top) continue;
            if (!(mat[top][i] == 0 && mat[i][top] == 1)) {
                return -1;
            }
        }
        return top;
    }
}
