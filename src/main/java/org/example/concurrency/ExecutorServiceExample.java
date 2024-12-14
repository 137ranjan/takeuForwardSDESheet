package org.example.concurrency;

import java.util.concurrent.*;
import java.util.stream.IntStream;

public class ExecutorServiceExample {
    public static void run() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        try (ExecutorService executorService = Executors.newFixedThreadPool(2)) {

            Callable<Integer> evenIndexSumTask = () ->
                    IntStream.range(0, arr.length)
                            .filter(i -> i % 2 == 0)
                            .map(i -> arr[i])
                            .sum();
            Callable<Integer> oddIndexSumTask = () ->
                    IntStream.range(0, arr.length)
                            .filter(i -> i % 2 != 0)
                            .map(i -> arr[i])
                            .sum();

            Future<Integer> evenIndexSumFuture = executorService.submit(evenIndexSumTask);
            Future<Integer> oddIndexSumFuture = executorService.submit(oddIndexSumTask);

            try {
                int evenIndexSum = evenIndexSumFuture.get();
                int oddIndexSum = oddIndexSumFuture.get();

                System.out.println("evenIndexSum: " + evenIndexSum);
                System.out.println("oddIndexSum: " + oddIndexSum);
            } catch (ExecutionException | InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                executorService.shutdown();
            }
        }
    }
}
