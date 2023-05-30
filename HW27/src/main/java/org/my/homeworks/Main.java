package org.my.homeworks;

public class Main {

    public static void main(String[] args) {

        StudentService studentService = new StudentService();

        // Adding student
        Student studentForAdding = new Student();
        studentForAdding.setName("John Doe");
        studentForAdding.setEmail("john@example.com");
        studentService.addStudent(studentForAdding);

        // Updating student
        int studentIdToUpdate = 2;
        studentService.updateStudent(studentIdToUpdate, "Jane Smith", "jane@example.com");

        // Getting student by id
        int studentIdToRetrieve = 13;
        studentService.getStudentById(studentIdToRetrieve);

        // Getting all the student records
        studentService.getAllStudents();

        // Removing student
        studentService.removeStudent(studentForAdding);
    }
}