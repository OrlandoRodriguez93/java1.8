package com.mycompany.demo.functionalInterfaces;

import java.util.List;
import java.util.function.Consumer;

import com.mycompany.demo.data.Student;
import com.mycompany.demo.data.StudentDataBase;

public class ConsumerExample {
    static final List<Student> studentList = StudentDataBase.getAllStudents();
    static Consumer<Student> c2 = (student) -> System.out.println(student);
    static Consumer<Student> c3 = (student) -> System.out.print(student.getName());
    static Consumer<Student> c4 = (student) -> System.out.println(student.getActivities());

    static void printName() {
        studentList.forEach(c2);
    }

    public static void printNameAndActivities() {
        studentList.forEach(c3.andThen(c4)); // consumer chaining
    }

    public static void printNameAndActivitiesUsingCondition() {
        studentList.forEach((student) -> {
            if (student.getGradeLevel() >= 3 && student.getGpa() >= 3.9)
                c3.andThen(c4).andThen(c2).accept(student);
        });
    }

    public static void main(String[] args) {

        Consumer<String> c1 = (s) -> System.out.println(s.toUpperCase());
        // c1.accept("hola mundo");
        // printName();
        // printNameAndActivities();
        printNameAndActivitiesUsingCondition();
    }
}
