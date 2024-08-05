package edu.miu.cs.cs425.studentrecordsmgmtapp;

import edu.miu.cs.cs425.studentrecordsmgmtapp.model.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static edu.miu.cs.cs425.studentrecordsmgmtapp.Utils.findSecondBiggest;
import static edu.miu.cs.cs425.studentrecordsmgmtapp.Utils.printHelloWorld;

public class MyStudentRecordsMgmtApp {

    public static void main(String[] args) throws ParseException {
        // Sample data
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Student[] students = {
                new Student("110001", "Dave", sdf.parse("11/18/1951")),
                new Student("110002", "Anna", sdf.parse("12/07/1990")),
                new Student("110003", "Erica", sdf.parse("01/31/1974")),
                new Student("110004", "Carlos", sdf.parse("08/22/2009")),
                new Student("110005", "Bob", sdf.parse("08/05/1994"))
        };

        // Print list of students
        printListOfStudents(students);

        // Print list of platinum alumni students
        List<Student> platinumAlumni = getListOfPlatinumAlumniStudents(students);
        System.out.println("Platinum Alumni Students:");
        for (Student student : platinumAlumni) {
            System.out.println(student);
        }

        int[] numbers = {5, 7, 10, 14, 35, 40};
        printHelloWorld(numbers);

        // Test findSecondBiggest method
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println("Second Biggest: " + findSecondBiggest(nums));
    }

    public static void printListOfStudents(Student[] students) {
        Arrays.sort(students, (s1, s2) -> s1.getName().compareToIgnoreCase(s2.getName()));
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static List<Student> getListOfPlatinumAlumniStudents(Student[] students) {
        List<Student> platinumAlumni = new ArrayList<>();
        Date now = new Date();
        for (Student student : students) {
            long years = (now.getTime() - student.getDateOfAdmission().getTime()) / (1000L * 60 * 60 * 24 * 365);
            if (years >= 30) {
                platinumAlumni.add(student);
            }
        }
        platinumAlumni.sort((s1, s2) -> s2.getDateOfAdmission().compareTo(s1.getDateOfAdmission()));
        return platinumAlumni;
    }
}
