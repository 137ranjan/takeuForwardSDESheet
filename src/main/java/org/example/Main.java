package org.example;

import org.example.string.LongestCommonPrefix;

public class Main {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(LongestCommonPrefix.longestCommonPrefix(strs));
    }
}