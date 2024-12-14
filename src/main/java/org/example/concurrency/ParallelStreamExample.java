package org.example.concurrency;

import java.util.stream.IntStream;

public class ParallelStreamExample {
    public static void run() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int evenIndexSum = IntStream.range(0, arr.length)
                .parallel()
                .filter(i -> i % 2 == 0)
                .map(i -> arr[i])
                .sum();
        int oddIndexSum = IntStream.range(0, arr.length)
                .parallel()
                .filter(i -> i % 2 != 0)
                .map(i -> arr[i])
                .sum();

        System.out.println("EvenIndexSum: " + evenIndexSum);
        System.out.println("OddIndexSum: " + oddIndexSum);
    }
}
