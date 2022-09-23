package com.mycompany.demo.streams;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.mycompany.demo.data.Student;
import com.mycompany.demo.data.StudentDataBase;

public class StreamsFlatMapExample {

    static List<String> printActivities() {
        return StudentDataBase.getAllStudents().stream() // Stream<Student>
                .map(Student::getActivities) // Stream<List<String>>
                .flatMap(List::stream) // Stream<String>
                // .collect(Collectors.toSet());
                .distinct()
                .sorted() // Sorting the List alphabetically
                .collect(Collectors.toList());
    }

    static long getCountActivities() {
        return StudentDataBase.getAllStudents().stream() // Stream<Student>
                .map(Student::getActivities) // Stream<List<String>>
                .flatMap(List::stream) // Stream<String>
                .distinct() // Stream<String> -> with distinct function performed
                .count();
    }

    public static void main(String[] args) {
        System.out.println(printActivities());
        System.out.println(getCountActivities());
    }
}
