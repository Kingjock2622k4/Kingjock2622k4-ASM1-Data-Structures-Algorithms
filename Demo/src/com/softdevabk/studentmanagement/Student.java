package com.softdevabk.studentmanagement;

public class Student {
    private String studentId;
    private String studentName;
    private double studentMarks;

    public Student(String studentId, String studentName, double studentMarks) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentMarks = studentMarks;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public double getStudentMarks() {
        return studentMarks;
    }

    public void setStudentMarks(double studentMarks) {
        this.studentMarks = studentMarks;
    }

    @Override
    public String toString() {
        String rank;
        if (studentMarks < 5.0) {
            rank = "Fail";
        } else if (studentMarks < 6.5) {
            rank = "Medium";
        } else if (studentMarks < 7.5) {
            rank = "Good";
        } else if (studentMarks < 9.0) {
            rank = "Very Good";
        } else {
            rank = "Excellent";
        }
        return "Student ID: " + studentId + ", Name: " + studentName + ", Marks: " + studentMarks + ", Rank: " + rank;
    }
}
