package com.mycompany.demo.functionalInterfaces;

import java.util.List;
import java.util.function.Predicate;

import com.mycompany.demo.data.Student;
import com.mycompany.demo.data.StudentDataBase;

public class PredicateStudentExample {

    static List<Student> studentList = StudentDataBase.getAllStudents();
    static Predicate<Student> p1 = (s) -> s.getGradeLevel() >= 3;
    static Predicate<Student> p2 = (s) -> s.getGpa() >= 3.9;

    public static void filterStudentByGradeLevel() {
        studentList.forEach(student -> {
            if (p1.test(student)) {
                System.out.println(student);
            }
        });
    }

    public static void filterStudentByGpa() {
        studentList.forEach(student -> {
            if (p2.test(student)) {
                System.out.println(student);
            }
        });
    }

    public static void filterStudentByGradeLevelAndByGpa() {
        studentList.forEach(student -> {
            // if (p1.or(p2).test(student)) {
            // if (p1.and(p2).negate().test(student)) {
            if (p1.and(p2).test(student)) {
                System.out.println(student);
            }
        });
    }

    public static void main(String[] args) {
        filterStudentByGradeLevel();
        filterStudentByGpa();
        filterStudentByGradeLevelAndByGpa();
    }
}
