package com.mycompany.demo.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsLimitSkipExample {

    public static Optional<Integer> limit(List<Integer> integers) {
        return integers.stream()
                .limit(2) // Only first n elements
                .reduce((x, y) -> x + y);
    }

    public static Optional<Integer> skip(List<Integer> integers) {
        return integers.stream()
                .skip(2) // Ignore first n element
                .limit(1) // Only one element after skip 2 elements
                .reduce((x, y) -> x + y);
    }

    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(6, 7, 8, 9, 10);
        Optional<Integer> limitOptional = limit(integers);

        if (limitOptional.isPresent()) {
            System.out.println(limitOptional.get());
        } else {
            System.out.println("No input is passed.");
        }

        Optional<Integer> skipOptional = skip(integers);

        if (skipOptional.isPresent()) {
            System.out.println(skipOptional.get());
        } else {
            System.out.println("No input is passed.");
        }
    }
}
