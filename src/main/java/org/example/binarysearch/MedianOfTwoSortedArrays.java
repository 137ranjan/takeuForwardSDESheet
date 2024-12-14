package org.example.binarysearch;

public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int index1 = (m + n) / 2;
        int index2 = (m + n) / 2 - 1;
        int count = 0;
        int index1Elem = -1;
        int index2Elem = -1;

        int i = 0, j = 0;
        while (i < m && j < n && !(index1Elem != -1 && index2Elem != -1)) {
            if (nums1[i] <= nums2[j]) {
                if (count == index1) {
                    index1Elem = nums1[i];
                }
                if (count == index2) {
                    index2Elem = nums1[i];
                }
                count++;
                i++;
            } else {
                if (count == index1) {
                    index1Elem = nums2[j];
                }
                if (count == index2) {
                    index2Elem = nums2[j];
                }
                count++;
                j++;
            }
        }

        while (i < m && !(index1Elem != -1 && index2Elem != -1)) {
            if (count == index1) {
                index1Elem = nums1[i];
            }
            if (count == index2) {
                index2Elem = nums1[i];
            }
            count++;
            i++;
        }

        while (j < n && !(index1Elem != -1 && index2Elem != -1)) {
            if (count == index1) {
                index1Elem = nums2[j];
            }
            if (count == index2) {
                index2Elem = nums2[j];
            }
            count++;
            j++;
        }

        if ((m + n) % 2 == 0) {
            return (index1Elem + index2Elem) / 2d;
        } else {
            return index1Elem;
        }
    }

    public static double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 > n2) {
            return findMedianSortedArrays3(nums2, nums1);
        }
        int low = 0, high = n1;
        int left = (n1 + n2 + 1) / 2;
        int n = n1 + n2;
        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
            if (mid1 < n1) r1 = nums1[mid1];
            if (mid2 < n2) r2 = nums2[mid2];
            if (mid1 - 1 >= 0) l1 = nums1[mid1 - 1];
            if (mid2 - 1 >= 0) l2 = nums2[mid2 - 1];
            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1) {
                    return Math.max(l1, l2);
                } else {
                    return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }
            } else if (l1 > r2) high = mid1 - 1;
            else low = mid1 + 1;
        }
        return 0;
    }
}
