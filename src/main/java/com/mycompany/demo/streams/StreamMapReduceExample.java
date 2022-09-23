package com.mycompany.demo.streams;

import com.mycompany.demo.data.Student;
import com.mycompany.demo.data.StudentDataBase;

public class StreamMapReduceExample {

    // Sum of all noteBooks of Students
    private static int noOfNoteBooks() {
        return StudentDataBase.getAllStudents().stream() // Stream<Student>
                .filter((s) -> s.getGradeLevel() >= 3)
                .filter((s) -> s.getGender().equals("female"))
                .map(Student::getNoteBooks) // Stream<Integer>
                // .reduce(0, (s1, s2) -> s1 + s2);
                .reduce(0, Integer::sum); // Another way of do the sum
    }

    public static void main(String[] args) {
        System.out.println(noOfNoteBooks());
    }
}
