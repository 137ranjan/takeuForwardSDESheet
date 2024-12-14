package org.example.binarysearch;

public class KthElementOfTwoArrays {
    public static long kthElement(int k, int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int count = 0;

        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                count++;
                if (count == k) {
                    return arr1[i];
                }
                i++;
            } else {
                count++;
                if (count == k) {
                    return arr2[j];
                }
                j++;
            }
        }
        while (i < n1) {
            count++;
            if (count == k) {
                return arr1[i];
            }
            i++;
        }
        while (j < n2) {
            count++;
            if (count == k) {
                return arr2[j];
            }
            j++;
        }
        return -1;
    }

    public static long kthElement2(int k, int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;

        if (n > m) {
            return kthElement2(k, arr2, arr1);
        }

        int low = Math.max(0, k - m), high = Math.min(k, n);
        while (low <= high) {
            int cut1 = (low + high) >> 1;
            int cut2 = k - cut1;
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
            if (cut1 < m) r1 = arr1[cut1];
            if (cut2 < n) r2 = arr2[cut2];
            if (cut1 - 1 >= 0) l1 = arr1[cut1 - 1];
            if (cut2 - 1 >= 0) l2 = arr2[cut2 - 1];

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }
        return -1;
    }
}
