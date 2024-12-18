package org.example.stackqueue;

import java.util.Stack;

public class StockSpanner {
    private final Stack<Stock> stack;
    private int index;

    public StockSpanner() {
        this.stack = new Stack<>();
        index = -1;
    }

    public int next(int price) {
        index = index + 1;
        while (!stack.isEmpty() && stack.peek().price <= price) {
            stack.pop();
        }
        int result = index - (stack.isEmpty() ? -1 : stack.peek().index);
        stack.push(new Stock(price, index));
        return result;
    }

    static class Stock {
        int price;
        int index;

        Stock(int price, int index) {
            this.price = price;
            this.index = index;
        }
    }
}
