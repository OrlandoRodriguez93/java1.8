package com.mycompany.demo.streams_terminal;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.mycompany.demo.data.Student;
import com.mycompany.demo.data.StudentDataBase;

public class StreamGroupingByExample {

    public static Map<String, List<Student>> groupStudentsByGender() {
        return StudentDataBase.getAllStudents()
                .stream() // Stream<Student>
                .collect(Collectors.groupingBy(Student::getGender));
    }

    public static Map<String, List<Student>> cutomizedGroupingBy() {
        return StudentDataBase.getAllStudents().stream()
                .collect(Collectors.groupingBy(student -> student.getGpa() >= 3.8 ? "OUTSTANDING" : "AVERAGE"));
    }

    public static Map<Integer, Map<String, List<Student>>> twoLevelGrouping_1() {
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(
                        Student::getGradeLevel,
                        Collectors.groupingBy(student -> student.getGpa() >= 3.8 ? "OUTSTANDING" : "AVERAGE")));
    }

    public static Map<String, Integer> twoLevelGrouping_2() {
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(
                        Student::getName,
                        Collectors.summingInt(Student::getNoteBooks)));
    }

    public static LinkedHashMap<String, Set<Student>> threeArgumentGroupBy() {
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(
                        Student::getName,
                        LinkedHashMap::new,
                        Collectors.toSet()));
    }

    public static void calculateTopGpa() {
        Map<Integer, Optional<Student>> studentMapOptional = StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(
                        Student::getGradeLevel,
                        Collectors.maxBy(Comparator.comparing(Student::getGpa))));

        // System.out.println(studentMapOptional);

        Map<Integer, Student> studentMapOptional1 = StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(
                        Student::getGradeLevel,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparing(Student::getGpa)), Optional::get)));
        System.out.println(studentMapOptional1);
    }

    public static void calculateLeastGpa() {
        Map<Integer, Optional<Student>> studentMapOptional = StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(
                        Student::getGradeLevel,
                        Collectors.minBy(Comparator.comparing(Student::getGpa))));

        // System.out.println(studentMapOptional);

        Map<Integer, Student> studentMapOptional1 = StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(
                        Student::getGradeLevel,
                        Collectors.collectingAndThen(
                                Collectors.minBy(Comparator.comparing(Student::getGpa)), Optional::get)));
        System.out.println(studentMapOptional1);
    }

    public static void main(String[] args) {
        // System.out.println(groupStudentsByGender());
        // System.out.println(cutomizedGroupingBy());
        // System.out.println(twoLevelGrouping_1());
        // System.out.println(twoLevelGrouping_2());
        // System.out.println(threeArgumentGroupBy());
        // calculateTopGpa();
        calculateLeastGpa();
    }
}
