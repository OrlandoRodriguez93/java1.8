package com.mycompany.demo.numericstreams;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericStreamRangesExample {

    public static void main(String[] args) {

        IntStream intStream = IntStream.range(1, 50);
        System.out.println(intStream.count());
        System.out.println();
        IntStream.range(1, 50).forEach((value -> System.out.print(value + ",")));
        System.out.println();
        IntStream.rangeClosed(1, 50).forEach((value -> System.out.print(value + ",")));
        System.out.println();
        LongStream.rangeClosed(1, 50).forEach((value -> System.out.print(value + ",")));
        System.out.println();
        IntStream.range(1, 50).asDoubleStream().forEach((value -> System.out.print(value + ",")));
        ;
    }
}
