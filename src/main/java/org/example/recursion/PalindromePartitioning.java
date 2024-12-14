package org.example.recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        findPalindrome(0, s, new ArrayList<>(), result);
        return result;
    }

    private static void findPalindrome(int index, String s, List<String> ds, List<List<String>> result) {
        if (index == s.length()) {
            result.add(new ArrayList<>(ds));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                ds.add(s.substring(index, i + 1));
                findPalindrome(i + 1, s, ds, result);
                ds.removeLast();
            }
        }
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}