package org.my.homeworks;

import java.util.List;

public interface Dao {

    void addStudent(Student Student);

    void updateStudent(Student student);

    void deleteStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(int id);
}
