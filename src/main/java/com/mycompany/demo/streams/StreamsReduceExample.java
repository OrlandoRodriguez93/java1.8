package com.mycompany.demo.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.mycompany.demo.data.Student;
import com.mycompany.demo.data.StudentDataBase;

public class StreamsReduceExample {

    static int performMultiplication(List<Integer> integerList) {

        return integerList.stream()
                .reduce(1, (a, b) -> a * b);
    }

    static Optional<Integer> performMultiplicationWithoutIdentity(List<Integer> integerList) {

        return integerList.stream()
                .reduce((a, b) -> a * b);
    }

    static Optional<Student> getHighestGpaStudent() {
        return StudentDataBase.getAllStudents().stream()
                // students one by one
                .reduce((s1, s2) -> (s1.getGpa() > s2.getGpa()) ? s1 : s2);
    }

    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(1, 3, 5, 7);
        List<Integer> emptyList = new ArrayList<>();

        System.out.println(performMultiplication(integers));

        Optional<Integer> result = performMultiplicationWithoutIdentity(integers);

        System.out.println(result.isPresent());
        System.out.println(result.get());

        Optional<Integer> resultEmpty = performMultiplicationWithoutIdentity(emptyList);
        System.out.println(resultEmpty.isPresent());
        // System.out.println(resultEmpty.get()); //java.util.NoSuchElementException

        // Check if Optional has a value
        if (resultEmpty.isPresent()) {
            System.out.println(resultEmpty.get());
        }

        Optional<Student> studentOptional = getHighestGpaStudent();
        if (studentOptional.isPresent()) {
            System.out.println(studentOptional.get());
        }
    }
}
