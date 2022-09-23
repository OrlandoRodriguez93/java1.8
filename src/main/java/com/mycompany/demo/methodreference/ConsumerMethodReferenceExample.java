package com.mycompany.demo.methodreference;

import java.util.List;
import java.util.function.Consumer;

import com.mycompany.demo.data.Student;
import com.mycompany.demo.data.StudentDataBase;

public class ConsumerMethodReferenceExample {

    // className:methodName
    static Consumer<Student> consumer = System.out::println;

    // className::instanceMethodName
    static Consumer<Student> consumer2 = Student::printListOfActivities;

    public static void main(String[] args) {

        StudentDataBase.getAllStudents().forEach(consumer);
        StudentDataBase.getAllStudents().forEach(consumer2);

    }
}
