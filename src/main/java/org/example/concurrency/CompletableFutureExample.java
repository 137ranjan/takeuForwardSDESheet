package org.example.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.IntStream;

public class CompletableFutureExample {
    public static void run() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        CompletableFuture<Integer> evenIndexSum = CompletableFuture.supplyAsync(() ->
                IntStream.range(0, arr.length)
                        .filter(i -> i % 2 == 0)
                        .map(i -> arr[i])
                        .sum()
        );

        CompletableFuture<Integer> oddIndexSum = CompletableFuture.supplyAsync(() ->
                IntStream.range(0, arr.length)
                        .filter(i -> i % 2 != 0)
                        .map(i -> arr[i])
                        .sum()
        );

        CompletableFuture<Void> combinedFuture = evenIndexSum.thenAcceptBoth(oddIndexSum, (evenSum, oddSum) -> {
            System.out.println("Sum of elements at even indices: " + evenSum);
            System.out.println("Sum of elements at odd indices: " + oddSum);
        });

        try {
            combinedFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
