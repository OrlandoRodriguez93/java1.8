package com.mycompany.demo.streams;

import java.util.Optional;

import com.mycompany.demo.data.Student;
import com.mycompany.demo.data.StudentDataBase;

public class StreamsFindAnyFirstExample {

    static Optional<Student> findAny() {
        return StudentDataBase.getAllStudents().stream()
                .filter(student -> student.getGpa() >= 3.9)
                .findAny();
    }

    static Optional<Student> findFirst() {
        return StudentDataBase.getAllStudents().stream()
                .filter(student -> student.getGpa() >= 3.9)
                .findFirst();
    }

    public static void main(String[] args) {
        Optional<Student> findAnyStudent = findAny();
        if (findAnyStudent.isPresent()) {
            System.out.println("Student found: " + findAnyStudent.get());
        } else {
            System.out.println("No student found");
        }

        Optional<Student> findFirstStudent = findFirst();
        if (findFirstStudent.isPresent()) {
            System.out.println("Student found: " + findFirstStudent.get());
        } else {
            System.out.println("No student found");
        }
    }
}
