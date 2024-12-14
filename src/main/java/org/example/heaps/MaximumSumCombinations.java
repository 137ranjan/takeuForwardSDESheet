package org.example.heaps;

import java.util.*;

public class MaximumSumCombinations {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        // sort both arrays
        Collections.sort(A);
        Collections.sort(B);

        int N = A.size();

        // Max Heap to store combinations
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        // set to track visited pairs
        Set<String> visited = new HashSet<>();

        // Push the first pair (max from both arrays)
        maxHeap.add(new int[]{A.get(N - 1) + B.get(N - 1), N - 1, N - 1});
        visited.add((N - 1) + "," + (N - 1));

        // Result list
        ArrayList<Integer> result = new ArrayList<>();

        // Extract C max sums
        while (C-- > 0 && !maxHeap.isEmpty()) {
            int[] top = maxHeap.poll();
            result.add(top[0]);
            int i = top[1];
            int j = top[2];

            // Push next pairs if not visited
            if (i > 0 && visited.add((i - 1) + "," + j)) {
                maxHeap.add(new int[]{A.get(i - 1) + B.get(j), i - 1, j});
            }
            if (j > 0 && visited.add(i + "," + (j - 1))) {
                maxHeap.add(new int[]{A.get(i) + B.get(j - 1), i, j - 1});
            }
        }
        return result;
    }
}
