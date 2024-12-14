package org.example.heaps;

import java.util.PriorityQueue;

public class KthLargest {
    public static int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
        }
        for (int i = k; i < n; i++) {
            if (!minHeap.isEmpty() && minHeap.peek() < nums[i]) {
                minHeap.remove();
                minHeap.add(nums[i]);
            }
        }
        return minHeap.peek() != null ? minHeap.peek() : -1;
    }

}
