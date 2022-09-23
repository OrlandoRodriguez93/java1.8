package com.mycompany.demo.functionalInterfaces;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.mycompany.demo.data.Student;
import com.mycompany.demo.data.StudentDataBase;

public class PredicateAndConsumerExample {

    static List<Student> studentList = StudentDataBase.getAllStudents();

    Predicate<Student> p1 = (s) -> s.getGradeLevel() >= 3;
    Predicate<Student> p2 = (s) -> s.getGpa() >= 3.9;

    BiPredicate<Integer, Double> biPredicate = (gradeLevel, gpa) -> gradeLevel >= 3 && gpa >= 3.9;

    BiConsumer<String, List<String>> b1 = (name, activities) -> System.out.println(name + ": " + activities);

    Consumer<Student> studentConsumer = (student) -> {
        // if (p1.and(p2).test(student)) {
        // b1.accept(student.getName(), student.getActivities());
        // }
        if (biPredicate.test(student.getGradeLevel(), student.getGpa())) {
            b1.accept(student.getName(), student.getActivities());
        }
    };

    void printNameAndActivities(List<Student> studentList) {
        studentList.forEach(studentConsumer);
    }

    public static void main(String[] args) {

        new PredicateAndConsumerExample().printNameAndActivities(studentList);

    }
}
