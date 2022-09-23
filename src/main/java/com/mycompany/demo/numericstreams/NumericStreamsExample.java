package com.mycompany.demo.numericstreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class NumericStreamsExample {

    public static int sumOfNNumbers(List<Integer> integers) {
        return integers.stream()
                .reduce(0, (x, y) -> x + y); // Unboxing to convert the Integer to int
    }

    public static int sumOfNNumbersIntStream() {
        return IntStream.rangeClosed(1, 6).sum(); // 1, 2, 3, 4, 5, 6
    }

    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println(sumOfNNumbers(integers));
        System.out.println(sumOfNNumbersIntStream());

    }
}
