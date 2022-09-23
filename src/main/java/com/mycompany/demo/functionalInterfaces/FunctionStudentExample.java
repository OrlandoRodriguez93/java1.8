package com.mycompany.demo.functionalInterfaces;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

import com.mycompany.demo.data.Student;
import com.mycompany.demo.data.StudentDataBase;

public class FunctionStudentExample {

    static Predicate<Student> p1 = (s) -> s.getGradeLevel() >= 3;

    static Function<List<Student>, Map<String, Double>> studentFunction = (students -> {
        Map<String, Double> studentGradeMap = new HashMap<>();
        students.forEach(student -> {
            if (p1.test(student)) {
                studentGradeMap.put(student.getName(), student.getGpa());
            }
        });
        return studentGradeMap;
    });

    public static void main(String[] args) {
        List<Student> studentList = StudentDataBase.getAllStudents();
        System.out.println(studentFunction.apply(studentList));
    }
}
