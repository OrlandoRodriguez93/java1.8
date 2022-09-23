package com.mycompany.demo.streams;

import java.util.List;
import java.util.stream.Collectors;

import com.mycompany.demo.data.Student;
import com.mycompany.demo.data.StudentDataBase;

public class StreamsFilterExample {

    static List<Student> filterStudents() {
        return StudentDataBase.getAllStudents().stream() // Stream<Student>
                .filter(student -> student.getGender().equals("female")) // Stream<Student> filters and sends only the
                                                                         // students whose gender is female
                .filter(student -> student.getGpa() >= 3.9)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        // System.out.println(filterStudents());
        filterStudents().forEach(System.out::println);

    }
}
