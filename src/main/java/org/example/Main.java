package org.example;

import org.example.string.LongestPalindromicSubsequence;

public class Main {
	public static void main(String[] args) {
		String s = "badbd";
		String result = LongestPalindromicSubsequence.longestPalindrome2(s);
		System.out.println(result);
	}
}