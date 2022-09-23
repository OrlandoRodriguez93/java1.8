package com.mycompany.demo.streams;

import com.mycompany.demo.data.StudentDataBase;

public class StreamsMatchExample {

    public static boolean allMatch() {
        return StudentDataBase.getAllStudents().stream()
                .allMatch(student -> student.getGpa() >= 3.5); // Return true if all elements comply with the predicate
    }

    public static boolean anyMatch() {
        return StudentDataBase.getAllStudents().stream()
                .anyMatch(student -> student.getGpa() >= 4.0); // Return true if at least one element comply with
                                                               // the predicate
    }

    public static boolean noneMatch() {
        return StudentDataBase.getAllStudents().stream()
                .noneMatch(student -> student.getGpa() >= 4.1); // Return true if at all elements not comply with
                                                                // the predicate
    }

    public static void main(String[] args) {
        System.out.println("Result of allMatch: " + allMatch());
        System.out.println("Result of anyMatch: " + anyMatch());
        System.out.println("Result of noneMatch: " + noneMatch());
    }
}
