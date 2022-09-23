package com.mycompany.demo.streams_terminal;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

import com.mycompany.demo.data.Student;
import com.mycompany.demo.data.StudentDataBase;

public class StreamsMaxByMinByExample {

    public static Optional<Student> minBy() {
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.minBy(Comparator.comparing(Student::getGpa)));
    }

    public static Optional<Student> maxBy() {
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.maxBy(Comparator.comparing(Student::getGpa)));
    }

    public static void main(String[] args) {
        Optional<Student> minBy = minBy();
        if (minBy.isPresent()) {
            System.out.println("minBy: " + minBy.get());
        } else {
            System.out.println("No input found");
        }

        Optional<Student> maxBy = maxBy();
        if (maxBy.isPresent()) {
            System.out.println("maxBy: " + maxBy.get());
        } else {
            System.out.println("No input found");
        }
    }
}
