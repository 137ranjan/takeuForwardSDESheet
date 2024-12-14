package org.example.binarysearch;

public class MedianInRowWiseSortedMatrix {
    public static int median(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        // point low and high to right elements
        for (int i = 0; i < m; i++) {
            low = Math.min(low, mat[i][0]);
            high = Math.max(high, mat[i][n - 1]);
        }

        int req = (n * m) / 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            int smallEqual = countSmallEqual(mat, mid);
            if (smallEqual <= req) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private static int countSmallEqual(int[][] mat, int x) {
        int m = mat.length;
        int n = mat[0].length;

        int count = 0;
        for (int i = 0; i < m; i++) {
            count += upperBound(mat[i], x, n);
        }
        return count;
    }

    private static int upperBound(int[] arr, int x, int n) {
        int low = 0, high = n - 1;
        int ans = n;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
