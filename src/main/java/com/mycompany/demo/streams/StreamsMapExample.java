package com.mycompany.demo.streams;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.mycompany.demo.data.Student;
import com.mycompany.demo.data.StudentDataBase;

public class StreamsMapExample {

    public static Set<String> namesList() {
        return StudentDataBase.getAllStudents().stream()
                // Student as input -> Student name
                .map(Student::getName) // Stream<String>
                .map(String::toUpperCase) // Stream<String> -> uppercase operation on each input
                // .collect(Collectors.toList()); // List<String>
                .collect(Collectors.toSet()); // List<String>
    }

    public static void main(String[] args) {
        System.out.println(namesList());
    }
}
