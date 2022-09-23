package com.mycompany.demo.numericstreams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumericStreamsBoxingUnBoxingExample {

    static List<Integer> boxing() {
        return IntStream.rangeClosed(1, 10) // intStream of 10 elements
                // int
                .boxed()
                // Integer
                .collect(Collectors.toList());
    }

    static int unBoxing(List<Integer> integerList) {
        // Wrapper to primitive
        return integerList.stream()
                .mapToInt(Integer::intValue) // IntStream (intValue of the wrapper class)
                .sum();
    }

    public static void main(String[] args) {
        System.out.println("Boxing: " + boxing());
        System.out.println("UnBoxing: " + unBoxing(boxing()));

    }
}
