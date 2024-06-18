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

    // Quick sort algorithm by student marks (descending order)
    public void quickSort() {
        quickSort(0, students.size() - 1);
    }

    private void quickSort(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);
            quickSort(low, pi - 1);
            quickSort(pi + 1, high);
        }
    }

    private int partition(int low, int high) {
        double pivot = students.get(high).getStudentMarks();
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (students.get(j).getStudentMarks() >= pivot) {
                i++;
                Student temp = students.get(i);
                students.set(i, students.get(j));
                students.set(j, temp);
            }
        }
        Student temp = students.get(i + 1);
        students.set(i + 1, students.get(high));
        students.set(high, temp);
        return i + 1;
    }

    // Selection sort algorithm by student marks (descending order)
    public void selectionSort() {
        for (int i = 0; i < students.size() - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < students.size(); j++) {
                if (students.get(j).getStudentMarks() > students.get(maxIndex).getStudentMarks()) {
                    maxIndex = j;
                }
            }
            Student temp = students.get(maxIndex);
            students.set(maxIndex, students.get(i));
            students.set(i, temp);
        }
    }

    // Display all students
    public void displayStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
