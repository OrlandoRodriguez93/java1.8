package com.mycompany.demo.lambdas;

import java.util.Comparator;

public class ComparatorLambdaExample {

    public static void main(String[] args) {

        // Prior java 8
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2); // 0 -> o1 == o2
                // 1 -> o1 > o2
                // -1 -> o1 < o2
            }
        };
        System.out.println("Result of the comparator is: " + comparator.compare(3, 3));
        System.out.println("Result of the comparator is: " + comparator.compare(3, 2));
        System.out.println("Result of the comparator is: " + comparator.compare(2, 3));

        Comparator<Integer> comparatorLambda = (Integer x, Integer y) -> x.compareTo(y);
        System.out.println("Result of the comparator using lambda is: " + comparatorLambda.compare(2, 3));

        Comparator<Integer> comparatorLambda1 = (x, y) -> x.compareTo(y);
        System.out.println("Result of the comparator using lambda1 is: " + comparatorLambda1.compare(2, 3));

    }

}
