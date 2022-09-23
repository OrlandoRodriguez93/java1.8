package com.mycompany.demo.streams_terminal;

import java.util.stream.Collectors;

import com.mycompany.demo.data.StudentDataBase;

public class StreamsCountingExample {

    public static long count() {
        return StudentDataBase.getAllStudents()
                .stream()
                .filter(student -> student.getGpa() >= 3.9)
                .collect(Collectors.counting());
    }

    public static void main(String[] args) {
        System.out.println("Count: " + count());
    }
}
