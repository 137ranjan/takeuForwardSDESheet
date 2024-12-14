package org.example.listarrays;

public class TrappingRainWater {
    public static int trap(int[] height) {
        int n = height.length;
        int leftMax = 0, rightMax = 0, total = 0, l = 0, r = n - 1;
        while (l < r) {
            if (height[l] <= height[r]) {
                if (leftMax > height[l]) {
                    total += leftMax - height[l];
                } else {
                    leftMax = height[l];
                }
                l = l + 1;
            } else {
                if (rightMax > height[r]) {
                    total += rightMax - height[r];
                } else {
                    rightMax = height[r];
                }
                r = r - 1;
            }
        }
        return total;
    }
}
