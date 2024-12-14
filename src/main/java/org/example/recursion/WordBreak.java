package org.example.recursion;

import java.util.*;

public class WordBreak {
    public static ArrayList<String> wordBreak(String s, ArrayList<String> dictionary) {
        // convert dictionary to HashSet for efficient lookup
        Set<String> wordDict = new HashSet<>(dictionary);

        // memoization map to store results for substrings
        Map<String, ArrayList<String>> memo = new HashMap<>();

        return wordBreakHelper(s, wordDict, memo);
    }

    private static ArrayList<String> wordBreakHelper(String s, Set<String> wordDict, Map<String,
            ArrayList<String>> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        ArrayList<String> result = new ArrayList<>();
        if (s.isEmpty()) {
            result.add("");
            return result;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                // recur for remaining substring after 'word'
                String remaining = s.substring(word.length());
                ArrayList<String> subResults = wordBreakHelper(remaining, wordDict, memo);
                for (String sub : subResults) {
                    if (sub.isEmpty()) {
                        result.add(word); // only add the word if no suffix
                    } else {
                        result.add(word + " " + sub); // combine with suffix
                    }
                }
            }
        }

        memo.put(s, result);
        return result;
    }
}
