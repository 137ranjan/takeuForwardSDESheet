package org.example.greedy;

import java.util.Arrays;

public class MinimumPlatforms {
    public static int findPlatform(int[] arr, int[] dep) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int count = 1;
        int maxCount = 1;

        int i = 1;
        int j = 0;
        int n = arr.length;
        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                count++;
                i++;
            } else if (arr[i] > dep[j]) {
                count--;
                j++;
            }

            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}