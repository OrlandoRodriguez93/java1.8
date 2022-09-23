package com.mycompany.demo.streams;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.mycompany.demo.data.Student;
import com.mycompany.demo.data.StudentDataBase;

public class StreamsExample {

    public static void main(String[] args) {

        Predicate<Student> studentPredicate = (s) -> s.getGradeLevel() >= 3;
        Predicate<Student> studentGpaPredicate = (s) -> s.getGpa() >= 3.9;

        // student name and there activities in a map
        Map<String, List<String>> studentMap = StudentDataBase.getAllStudents().stream()
                .peek((student) -> {
                    System.out.println(student);
                })
                .filter(studentPredicate) // Stream<Student>
                .filter(studentGpaPredicate) // Stream<Student>
                .collect(Collectors.toMap(Student::getName, Student::getActivities)); // Map<>

        System.out.println(studentMap);

        // List<Student> studentList = StudentDataBase.getAllStudents().stream()
        // .collect(Collectors.toList());

        // System.out.println(studentList);
    }
}
