package org.example.string;

public class LongestPalindromicSubsequence {

	// Efficient
	public static String longestPalindrome2(String s) {
		String result = "";

		for (int i = 0; i < s.length(); i++) {
			int left = i, right = i;
			while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
				if (right - left + 1 > result.length()) {
					result = s.substring(left, right + 1);
				}
				left--;
				right++;
			}

			left = i;
			right = i + 1;

			while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
				if (right - left + 1 > result.length()) {
					result = s.substring(left, right + 1);
				}
				left--;
				right++;
			}
		}
		return result;
	}

	// Brute force
	public static String longestPalindrome(String s) {
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j < s.length(); j++) {
				if (isPalindrome(s, i, j) && result.length() < j - i + 1) {
					result = s.substring(i, j + 1);
				}
			}
		}
		return result;
	}

	private static boolean isPalindrome(String s, int start, int end) {
		while (start < end) {
			if (s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
}
