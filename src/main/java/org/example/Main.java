package org.example;

import org.example.stackqueue.StockSpanner;

public class Main {
	public static void main(String[] args) {
		StockSpanner stockSpanner = new StockSpanner();
		System.out.println(stockSpanner.next(100)); // return 1
		System.out.println(stockSpanner.next(80)); // return 1
		System.out.println(stockSpanner.next(60)); // return 1
		System.out.println(stockSpanner.next(70)); // return 2
		System.out.println(stockSpanner.next(60)); // return 1
		System.out.println(stockSpanner.next(75)); // return 4, because the last 4 prices (including today's price of
													// 75) were less than or equal to today's price.
		System.out.println(stockSpanner.next(85)); // return 6
		// Test comment
	}
}