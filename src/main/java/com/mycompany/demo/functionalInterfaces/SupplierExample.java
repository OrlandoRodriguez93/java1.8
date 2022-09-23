package com.mycompany.demo.functionalInterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import com.mycompany.demo.data.Student;
import com.mycompany.demo.data.StudentDataBase;

public class SupplierExample {

    public static void main(String[] args) {

        Supplier<Student> supplier = () -> {
            return new Student("Adam", 2, 3.6, "male", Arrays.asList("swimming", "basketball", "volleyball"));
        };

        Supplier<List<Student>> supplier2 = () -> StudentDataBase.getAllStudents();

        System.out.println(supplier.get());
        System.out.println(supplier2.get());
    }
}
