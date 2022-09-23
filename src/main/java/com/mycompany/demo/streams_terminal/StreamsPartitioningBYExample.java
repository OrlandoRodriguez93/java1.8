package com.mycompany.demo.streams_terminal;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.mycompany.demo.data.Student;
import com.mycompany.demo.data.StudentDataBase;

public class StreamsPartitioningBYExample {

    public static Map<Boolean, List<Student>> partitioningBy1() {

        Predicate<Student> gpaPredicate = student -> student.getGpa() >= 3.8;

        return StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.partitioningBy(gpaPredicate));
    }

    public static Map<Boolean, Set<Student>> partitioningBy2() {

        Predicate<Student> gpaPredicate = student -> student.getGpa() >= 3.8;

        return StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.partitioningBy(gpaPredicate, Collectors.toSet()));
    }

    public static void main(String[] args) {
        // System.out.println(partitioningBy1());
        System.out.println(partitioningBy2());
    }
}
