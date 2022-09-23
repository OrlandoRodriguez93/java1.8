package com.mycompany.demo.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsMinMaxExample {

    public static int findMaxValue(List<Integer> integerList) {
        return integerList.stream()
                // X variable holds the max value for each element in the iteration
                .reduce(0, (x, y) -> x > y ? x : y);
    }

    public static int findMinValue(List<Integer> integerList) {
        return integerList.stream()
                // X variable holds the max value for each element in the iteration
                .reduce(0, (x, y) -> x < y ? x : y);
    }

    public static Optional<Integer> findMaxValueOptional(List<Integer> integerList) {
        return integerList.stream()
                // X variable holds the max value for each element in the iteration
                .reduce((x, y) -> x > y ? x : y);
    }

    public static Optional<Integer> findMinValueOptional(List<Integer> integerList) {
        return integerList.stream()
                // X variable holds the max value for each element in the iteration
                .reduce((x, y) -> x < y ? x : y);
    }

    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(6, 7, 8, 9, 10);
        // List<Integer> integerList = new ArrayList<>();
        System.out.println("Max value");
        System.out.println(findMaxValue(integerList));

        Optional<Integer> result = findMaxValueOptional(integerList);
        if (result.isPresent()) {
            System.out.println(result.get());
        } else {
            System.out.println("No max value found.");
        }

        System.out.println("Min value");
        System.out.println(findMinValue(integerList));

        Optional<Integer> resultMin = findMinValueOptional(integerList);
        if (resultMin.isPresent()) {
            System.out.println(resultMin.get());
        } else {
            System.out.println("No min value found.");
        }

    }
}
