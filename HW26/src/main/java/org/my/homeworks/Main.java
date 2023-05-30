package org.my.homeworks;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.my.homeworks.db.DataBaseConnection;

public class Main {

    public static void main(String[] args) {

        try {

            Connection connection = DataBaseConnection.getConnection();
            LessonDao lessonDao = new LessonDao(connection);

            int lessonId = 1;

            Homework homework = lessonDao.getHomeworkById(lessonId);
            Lesson lessonOne = new Lesson(lessonId, "Math", homework);
            lessonOne.setHomework(homework);
            lessonDao.addLesson(lessonOne);

            List<Lesson> allLessons = lessonDao.getAllLessons();
            for (Lesson lesson : allLessons) {
                System.out.println("Lesson ID: " + lesson.getId());
                System.out.println("Lesson Name: " + lesson.getName());
                System.out.println("Homework Name: " + lesson.getHomework().getName());
                System.out.println("Homework Description: " + lesson.getHomework().getDescription());
            }

            Lesson lessonById = lessonDao.getLessonById(lessonId);
            if (lessonById != null) {
                System.out.println("Lesson ID: " + lessonById.getId());
                System.out.println("Lesson Name: " + lessonById.getName());
                System.out.println("Homework Name: " + lessonById.getHomework().getName());
                System.out.println("Homework Description: " + lessonById.getHomework().getDescription());
            }
            lessonDao.removeLesson(lessonOne);
            DataBaseConnection.close(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}