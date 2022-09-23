package com.mycompany.demo.parallelstream;

import java.util.function.Supplier;
import java.util.stream.IntStream;

public class ParallelStreamExample {

    static long checkPerformanceResult(Supplier<Integer> supplier, int numberOfTimes) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < numberOfTimes; i++) {
            supplier.get();
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    static int sumSequentialStream() {
        return IntStream.rangeClosed(1, 100000).sum();
    }

    static int sumParallelStream() {
        return IntStream
                .rangeClosed(1, 100000)
                .parallel() // Split the data in to multiple Threads
                .sum();
    }

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println("sequential: " + checkPerformanceResult(ParallelStreamExample::sumSequentialStream, 100));
        System.out.println("parallel: " + checkPerformanceResult(ParallelStreamExample::sumParallelStream, 100));

    }
}
