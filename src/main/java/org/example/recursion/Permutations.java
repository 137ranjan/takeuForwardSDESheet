package org.example.recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permuteHelper(nums, new ArrayList<>(), result);
        return result;
    }

    private static void permuteHelper(int[] nums, List<Integer> ds, List<List<Integer>> result) {
        if (ds.size() == nums.length) {
            result.add(new ArrayList<>(ds));
            return;
        }
        for (int num : nums) {
            if (ds.contains(num)) {
                continue;
            }
            ds.add(num);
            permuteHelper(nums, ds, result);
            ds.removeLast();
        }
    }
}
