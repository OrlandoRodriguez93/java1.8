package com.mycompany.demo.optional;

import java.util.Optional;

import com.mycompany.demo.data.Bike;
import com.mycompany.demo.data.Student;
import com.mycompany.demo.data.StudentDataBase;

public class OptionalMapFlatMapExample {

    // Filter
    static void optionalFiler() {
        Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get()); // Optopnal<Student>

        studentOptional
                .filter(student -> student.getGpa() >= 3.5)
                .ifPresent(student -> System.out.println(student));

    }

    // map
    static void mapOptional() {
        Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get()); // Optopnal<Student>

        if (studentOptional.isPresent()) {
            Optional<String> optionalString = studentOptional
                    .filter(student -> student.getGpa() >= 3.5) // Optional<Student <Optional>Bike>>
                    .map(Student::getName);
            System.out.println(optionalString.get());
        }
    }

    // FlatMap
    static void flatMapOptional() {
        Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get()); // Optopnal<Student>

        Optional<String> optionalString = studentOptional
                .filter(student -> student.getGpa() >= 3.5) // Optional<Student <Optional>Bike>>
                .flatMap(Student::getBike)// Optional<Bike>
                .map(Bike::getName);
        optionalString.ifPresent(s -> System.out.println(s));

    }

    public static void main(String[] args) {
        optionalFiler();
        mapOptional();
        flatMapOptional();
    }
}
