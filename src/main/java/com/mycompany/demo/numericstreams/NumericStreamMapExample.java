package com.mycompany.demo.numericstreams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumericStreamMapExample {

    static List<Integer> mapToObj() {
        return IntStream.rangeClosed(1, 5)
                .mapToObj((i) -> {
                    return new Integer(i);
                })
                .collect(Collectors.toList());
    }

    public static Long mapToLong() {
        return IntStream.rangeClosed(1, 5) // IntStream
                // i is passed from the intstream
                .mapToLong((i) -> i) // convert IntStream to LongStream
                .sum();
    }

    static Double mapToDouble() {
        return IntStream.rangeClosed(1, 5) // IntStream
                // i is passed from the intstream
                .mapToDouble((i) -> i) // convert IntStream to DoubleStream
                .sum();
    }

    public static void main(String[] args) {
        System.out.println("mapToObj: " + mapToObj());
        System.out.println("mapToLong: " + mapToLong());
        System.out.println("mapToDouble: " + mapToDouble());
    }
}
