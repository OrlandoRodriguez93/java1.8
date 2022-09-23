package com.mycompany.demo.numericstreams;

import java.util.stream.IntStream;

public class NumericStreamAggregateExample {

    public static void main(String[] args) {
        System.out.println(IntStream.rangeClosed(1, 50).sum());
        System.out.println(IntStream.rangeClosed(1, 50).max()); // Return an Optional
        System.out.println(IntStream.rangeClosed(1, 50).min()); // Return an Optional
        System.out.println(IntStream.rangeClosed(1, 50).average()); // Return an Optional
    }
}
