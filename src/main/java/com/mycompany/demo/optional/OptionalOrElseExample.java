package com.mycompany.demo.optional;

import java.util.Optional;

import com.mycompany.demo.data.Student;
import com.mycompany.demo.data.StudentDataBase;

public class OptionalOrElseExample {

    static String optionalOrElse() {
        // Optional<Student> studentOptional =
        // Optional.ofNullable(StudentDataBase.studentSupplier.get());
        Optional<Student> studentOptional = Optional.ofNullable(null);

        String name = studentOptional.map(Student::getName).orElse("Default");
        return name;
    }

    static String optionalOrElseGet() {
        // Optional<Student> studentOptional =
        // Optional.ofNullable(StudentDataBase.studentSupplier.get());
        Optional<Student> studentOptional = Optional.ofNullable(null);

        String name = studentOptional.map(Student::getName).orElseGet(() -> "Default");
        return name;
    }

    static String optionalOrElseThrow() {
        // Optional<Student> studentOptional =
        // Optional.ofNullable(StudentDataBase.studentSupplier.get());
        Optional<Student> studentOptional = Optional.ofNullable(null);

        String name = studentOptional.map(Student::getName)
                .orElseThrow(() -> new RuntimeException("No data available"));
        return name;
    }

    public static void main(String[] args) {
        System.out.println(optionalOrElse());
        System.out.println(optionalOrElseGet());
        System.out.println(optionalOrElseThrow());

    }
}
