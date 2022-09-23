package com.mycompany.demo.optional;

import java.util.Optional;

import com.mycompany.demo.data.Student;
import com.mycompany.demo.data.StudentDataBase;

public class OptionalExample {

    static String getStudentName() {
        // Student student = StudentDataBase.studentSupplier.get();
        Student student = null;

        if (student != null) {
            return student.getName();
        }
        return null;
    }

    static Optional<String> getStudentNameOptional() {
        // Optional<Student> studentOptional =
        // Optional.ofNullable(StudentDataBase.studentSupplier.get());
        Optional<Student> studentOptional = Optional.ofNullable(null); // Optional.empty()

        if (studentOptional.isPresent()) {
            return studentOptional.map(Student::getName); // Optional<String>
        }
        return Optional.empty(); // Represents an optional object with no value

    }

    public static void main(String[] args) {
        // String name = getStudentName();
        // if (name != null)
        // System.out.println(name.length());
        // else
        // System.out.println("Name not found.");

        Optional<String> stringOptional = getStudentNameOptional();
        if (stringOptional.isPresent()) {
            System.out.println(stringOptional.get().length());
        } else {
            System.out.println("Name not found.");
        }
    }
}
