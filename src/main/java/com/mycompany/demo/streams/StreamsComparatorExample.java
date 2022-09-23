package com.mycompany.demo.streams;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.mycompany.demo.data.Student;
import com.mycompany.demo.data.StudentDataBase;

public class StreamsComparatorExample {

    static List<Student> sortStudentsByName() {
        return StudentDataBase.getAllStudents().stream()
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());
    }

    static List<Student> sortStudentsByGpa() {
        return StudentDataBase.getAllStudents().stream()
                .sorted(Comparator.comparing(Student::getGpa))
                .collect(Collectors.toList());
    }

    static List<Student> sortStudentsByGpaDescending() {
        return StudentDataBase.getAllStudents().stream()
                .sorted(Comparator.comparing(Student::getGpa).reversed())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        // System.out.println(sortStudentsByName());

        System.out.println("NAME");
        sortStudentsByName().forEach(System.out::println);
        System.out.println("GPA");
        sortStudentsByGpa().forEach(System.out::println);
        System.out.println("REVERSED");
        sortStudentsByGpaDescending().forEach(System.out::println);
    }
}
