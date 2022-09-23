package com.mycompany.demo.functionalInterfaces;

import java.util.List;
import java.util.function.BiConsumer;

import com.mycompany.demo.data.Student;
import com.mycompany.demo.data.StudentDataBase;

public class BiConsumerExample {

    public static void nameAndActivities() {
        List<Student> StudentList = StudentDataBase.getAllStudents();

        BiConsumer<String, List<String>> biConsumer = (name, activities) -> {
            System.out.println(name + ":" + activities);
        };
        StudentList.forEach(student -> biConsumer.accept(student.getName(), student.getActivities()));
    }

    public static void main(String[] args) {
        BiConsumer<String, String> biConsumer = (a, b) -> {
            System.out.println("a: " + a + " b: " + b);
        };
        biConsumer.accept("java7", "java8");

        BiConsumer<Integer, Integer> multiply = (x, y) -> {
            System.out.println("Multuplication is: " + (x * y));
        };

        BiConsumer<Integer, Integer> division = (x, y) -> {
            System.out.println("Division is: " + (x / y));
        };

        multiply.andThen(division).accept(10, 5);

        nameAndActivities();
    }
}
