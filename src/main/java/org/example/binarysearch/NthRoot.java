package org.example.binarysearch;

public class NthRoot {
    public static int NthRootFunction(int n, int m) {
        int left = 1, right = m - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            double product = 1;
            for (int j = 0; j < n; j++) {
                product *= mid;
            }
            if (product == m) {
                return mid;
            } else if (product < m) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
