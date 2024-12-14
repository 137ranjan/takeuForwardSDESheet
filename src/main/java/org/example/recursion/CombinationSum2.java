package org.example.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        findCombination(0, candidates, target, new ArrayList<>(), result);
        return result;
    }

    private static void findCombination(int index, int[] candidates, int target, List<Integer> ds,
                                        List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(ds));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (candidates[i] > target) {
                break;
            }
            ds.add(candidates[i]);
            findCombination(i + 1, candidates, target - candidates[i], ds, result);
            ds.removeLast();
        }
    }
}
