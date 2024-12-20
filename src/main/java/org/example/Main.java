package org.example;

import org.example.string.ReverseWordsInAString;

public class Main {
	public static void main(String[] args) {
		String s = "the sky is blue";
		String result = ReverseWordsInAString.reverseWords(s);
		System.out.println(result);
	}
}