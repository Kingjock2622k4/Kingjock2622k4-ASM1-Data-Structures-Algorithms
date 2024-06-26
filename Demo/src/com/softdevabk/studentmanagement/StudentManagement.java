package com.softdevabk.studentmanagement;

import java.util.ArrayList;
import java.util.List;

public class StudentManagement {
    private List<Student> students;

    public StudentManagement() {
        this.students = new ArrayList<>();
    }

    // Add a new student to the list
    public void addStudent(Student student) {
        students.add(student);
    }

    // Edit an existing student's details
    public void editStudent(String studentId, String newName, double newMarks) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                student.setStudentName(newName);
                student.setStudentMarks(newMarks);
                return;
            }
        }
    }

    // Delete a student from the list
    public void deleteStudent(String studentId) {
        students.removeIf(student -> student.getStudentId().equals(studentId));
    }

    // Search for a student by their ID
    public Student searchById(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    // Search for students by their name
    public List<Student> searchByName(String studentName) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getStudentName().equalsIgnoreCase(studentName)) {
                result.add(student);
            }
        }
        return result;
    }

    // Sort students by their marks in descending order using bubble sort
    public void sortStudentsByMarks() {
        int n = students.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (students.get(j).getStudentMarks() < students.get(j + 1).getStudentMarks()) {
                    // Swap students[j] and students[j + 1]
                    Student temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                }
            }
        }
    }

    // Display all students
    public void displayStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
