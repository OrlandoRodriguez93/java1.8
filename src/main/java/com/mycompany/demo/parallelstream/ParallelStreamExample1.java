package com.mycompany.demo.parallelstream;

import java.util.List;
import java.util.stream.Collectors;

import com.mycompany.demo.data.Student;
import com.mycompany.demo.data.StudentDataBase;

public class ParallelStreamExample1 {

    static List<String> sequentialPrintprintActivities() {
        long startTime = System.currentTimeMillis();
        List<String> studentActivities = StudentDataBase.getAllStudents().stream() // Stream<Student>
                .map(Student::getActivities) // Stream<List<String>>
                .flatMap(List::stream) // Stream<String>
                // .collect(Collectors.toSet());
                .distinct()
                .sorted() // Sorting the List alphabetically
                .collect(Collectors.toList());
        long endTime = System.currentTimeMillis();
        System.out.println("Duration to execute the pipeline in sequential: " + (endTime - startTime));
        return studentActivities;

    }

    static List<String> parallelPrintprintActivities() {
        long startTime = System.currentTimeMillis();
        List<String> studentActivities = StudentDataBase.getAllStudents()
                .stream() // Stream<Student>
                .parallel() // make it parallel
                .map(Student::getActivities) // Stream<List<String>>
                .flatMap(List::stream) // Stream<String>
                // .collect(Collectors.toSet());
                .distinct()
                .sorted() // Sorting the List alphabetically
                .collect(Collectors.toList());
        long endTime = System.currentTimeMillis();
        System.out.println("Duration to execute the pipeline in sequential: " + (endTime - startTime));
        return studentActivities;
    }

    public static void main(String[] args) {
        System.out.println(sequentialPrintprintActivities());
        System.out.println(parallelPrintprintActivities());
    }
}
