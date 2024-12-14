package org.example.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        findCombinations(0, candidates, target, result, new ArrayList<>());
        return result;
    }

    private static void findCombinations(int ind, int[] candidates, int target, List<List<Integer>> result,
                                         List<Integer> ds) {
        if (ind == candidates.length) {
            if (target == 0) {
                result.add(new ArrayList<>(ds));
            }
            return;
        }
        if (candidates[ind] <= target) {
            ds.add(candidates[ind]);
            findCombinations(ind, candidates, target - candidates[ind], result, ds);
            ds.removeLast();
        }
        findCombinations(ind + 1, candidates, target, result, ds);
    }
}
