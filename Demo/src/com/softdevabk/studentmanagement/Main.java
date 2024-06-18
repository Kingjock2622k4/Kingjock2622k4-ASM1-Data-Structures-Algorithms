package com.softdevabk.studentmanagement;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManagement sm = new StudentManagement();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Search");
            System.out.println("5. Sort Students");
            System.out.println("6. Display All Students");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Marks: ");
                    double marks = scanner.nextDouble();
                    sm.addStudent(new Student(id, name, marks));
                    break;

                case 2:
                    System.out.print("Enter ID of Student to Edit: ");
                    String editId = scanner.nextLine();
                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter New Marks: ");
                    double newMarks = scanner.nextDouble();
                    sm.editStudent(editId, newName, newMarks);
                    break;

                case 3:
                    System.out.print("Enter ID of Student to Delete: ");
                    String deleteId = scanner.nextLine();
                    sm.deleteStudent(deleteId);
                    break;

                case 4:
                    System.out.println("Choose search method:");
                    System.out.println("1. Search by ID");
                    System.out.println("2. Search by Name");
                    System.out.print("Choose an option: ");
                    int searchChoice = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    if (searchChoice == 1) {
                        System.out.print("Enter ID to Search: ");
                        String searchId = scanner.nextLine();
                        Student foundStudent = sm.searchById(searchId);
                        if (foundStudent != null) {
                            System.out.println(foundStudent);
                        } else {
                            System.out.println("Student not found.");
                        }
                    } else if (searchChoice == 2) {
                        System.out.print("Enter Name to Search: ");
                        String searchName = scanner.nextLine();
                        List<Student> foundStudents = sm.searchByName(searchName);
                        if (!foundStudents.isEmpty()) {
                            for (Student student : foundStudents) {
                                System.out.println(student);
                            }
                        } else {
                            System.out.println("No students found.");
                        }
                    } else {
                        System.out.println("Invalid choice.");
                    }
                    break;

                case 5:
                    System.out.println("Choose sorting method:");
                    System.out.println("1. Quick Sort");
                    System.out.println("2. Selection Sort");
                    System.out.print("Choose an option: ");
                    int sortChoice = scanner.nextInt();
                    if (sortChoice == 1) {
                        sm.quickSort();
                        System.out.println("Students sorted using Quick Sort.");
                    } else if (sortChoice == 2) {
                        sm.selectionSort();
                        System.out.println("Students sorted using Selection Sort.");
                    } else {
                        System.out.println("Invalid choice.");
                    }
                    break;

                case 6:
                    sm.displayStudents();
                    break;

                case 7:
                    scanner.close();
                    System.out.println("Exiting program.");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
            System.out.println(); // Add a blank line for better readability
        }
    }
}
