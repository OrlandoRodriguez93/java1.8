package com.mycompany.demo.streams_terminal;

import java.util.stream.Collectors;

import com.mycompany.demo.data.Student;
import com.mycompany.demo.data.StudentDataBase;

public class StreamsSumAvgExample {

    static int sum() {
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.summingInt(Student::getNoteBooks));
    }

    static double avg() {
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.averagingInt(Student::getNoteBooks));
    }

    public static void main(String[] args) {
        System.out.println("sum: " + sum());
        System.out.println("avg: " + avg());
    }
}
