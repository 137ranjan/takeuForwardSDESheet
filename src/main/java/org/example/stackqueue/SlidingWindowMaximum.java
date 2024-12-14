package org.example.stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();

        int l = 0;
        for(int i=0; i<n; i++){
            if(!dq.isEmpty() && dq.peek() == i-k){
                dq.poll();
            }
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }
            dq.offer(i);
            if( i>= k - 1){
                result[l] = nums[dq.peek()];
                l++;
            }
        }
        return result;
    }
}
