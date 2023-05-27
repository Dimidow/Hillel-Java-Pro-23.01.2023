package org.my.homeworks;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StudentService {

    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);
    private StudentDao studentDao;

    public StudentService() {
        this.studentDao = new StudentDao();
    }

    public void addStudent(Student student) {
        try {
            studentDao.add(student);
            System.out.println("Student was added successfully");
        } catch (Exception e) {
            logger.info("Error during adding the student");
            e.printStackTrace();
        }
    }

    public void updateStudent(int studentId, String name, String email) {
        try {
            Student studentToUpdate = studentDao.getEntityById(studentId);
            if (studentToUpdate != null) {
                studentToUpdate.setName(name);
                studentToUpdate.setEmail(email);
                studentDao.update(studentToUpdate);
                System.out.println("Student record was updated");
            } else {
                System.out.println("Student record was not found");
            }
        } catch (Exception e) {
            logger.info("Error during updating the student's record");
            e.printStackTrace();
        }
    }

    public void getStudentById(int studentId) {
        try {
            Student retrievedStudent = studentDao.getEntityById(studentId);
            if (retrievedStudent != null) {
                System.out.println("Got record with Student data:");
                System.out.println("ID: " + retrievedStudent.getId());
                System.out.println("Name: " + retrievedStudent.getName());
                System.out.println("Email: " + retrievedStudent.getEmail());
            } else {
                System.out.println("Student record was not found");
            }
        } catch (Exception e) {
            logger.info("Error during retrieving the student's record");
            e.printStackTrace();
        }
    }

    public void getAllStudents() {
        try {
            List<Student> allStudents = studentDao.getAllEntities();
            System.out.println("Got all records with Student data:");
            for (Student student : allStudents) {
                System.out.println("ID: " + student.getId());
                System.out.println("Name: " + student.getName());
                System.out.println("Email: " + student.getEmail());
                System.out.println("----------");
            }
        } catch (Exception e) {
            logger.info("Error during getting all the records from Student");
            e.printStackTrace();
        }
    }

    public void removeStudent(Student student) {
        try {
            studentDao.delete(student);
            System.out.println("Student was removed successfully");
        } catch (Exception e) {
            logger.info("Error during removing the student");
            e.printStackTrace();
        }
    }
}