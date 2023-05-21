package org.my.homeworks;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        StudentDao studentDao = new StudentDao();
        Student studentForAdding = new Student();
        studentForAdding.setName("John Doe");
        studentForAdding.setEmail("john@example.com");

//Adding student
        try {
            studentDao.addStudent(studentForAdding);
            System.out.println("Student was added successfully");
        } catch (Exception e) {
            System.out.println("The error during adding the student");
            e.printStackTrace();
        }
//Updating student
        int studentIdToUpdate = 2;
        try {
            Student studentToUpdate = studentDao.getStudentById(studentIdToUpdate);
            if (studentToUpdate != null) {
                studentToUpdate.setName("Jane Smith");
                studentToUpdate.setEmail("jane@example.com");
                studentDao.updateStudent(studentToUpdate);
                System.out.println("Student record was updated");
            } else {
                System.out.println("Student record was not found");
            }
        } catch (Exception e) {
            System.out.println("The error during updating the student`s record");
            e.printStackTrace();
        }
//Getting student by id
        int studentIdToRetrieve = 13;
        try {
            Student retrievedStudent = studentDao.getStudentById(studentIdToRetrieve);
            if (retrievedStudent != null) {
                System.out.println("Got record with Student data:");
                System.out.println("ID: " + retrievedStudent.getId());
                System.out.println("Name: " + retrievedStudent.getName());
                System.out.println("Email: " + retrievedStudent.getEmail());
            } else {
                System.out.println("Student record was not found");
            }
        } catch (Exception e) {
            System.out.println("The error during updating the student`s record");
            e.printStackTrace();
        }
//Getting all the student records
        try {
            List<Student> allStudents = studentDao.getAllStudents();
            System.out.println("Got all records with Student data:");
            for (Student student : allStudents) {
                System.out.println("ID: " + student.getId());
                System.out.println("Name: " + student.getName());
                System.out.println("Email: " + student.getEmail());
                System.out.println("----------");
            }
        } catch (Exception e) {
            System.out.println("The error during getting all the records from Student");
            e.printStackTrace();
        }
//Removing student
        try {
            studentDao.deleteStudent(studentForAdding);
            System.out.println("Student was removed successfully");
        } catch (Exception e) {
            System.out.println("The error during removing the student");
            e.printStackTrace();
        }
    }
}