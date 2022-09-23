package com.mycompany.demo.defaults;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import com.mycompany.demo.data.Student;
import com.mycompany.demo.data.StudentDataBase;

public class DefaultMethodsExample2 {

    static Consumer<Student> studentConsumer = (student -> System.out.println(student));
    static Comparator<Student> nameComparator = Comparator.comparing(Student::getName);
    static Comparator<Student> gradeComparator = Comparator.comparing(Student::getGradeLevel);

    public static void sortByName(List<Student> studentList) {
        System.out.println("AfterSort");
        Comparator<Student> nameComparator = Comparator.comparing(Student::getName);
        studentList.sort(nameComparator);
        studentList.forEach(studentConsumer);
    }

    public static void sortByGpa(List<Student> studentList) {
        System.out.println("AfterSort");
        Comparator<Student> gpaComparator = Comparator.comparingDouble(Student::getGpa);
        studentList.sort(gpaComparator);
        studentList.forEach(studentConsumer);
    }

    public static void comparatorChaining(List<Student> studentList) {

        System.out.println("AfterComparatorChaining");
        studentList.sort(gradeComparator.thenComparing(nameComparator));
        studentList.forEach(studentConsumer);

    }

    public static void main(String[] args) {

        List<Student> studentList = StudentDataBase.getAllStudents();
        // System.out.println(studentList);
        // Before sort
        studentList.forEach(studentConsumer);

        // sortByName(studentList);
        // sortByGpa(studentList);
        comparatorChaining(studentList);
    }
}
