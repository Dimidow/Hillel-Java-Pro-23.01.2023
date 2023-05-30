package org.my.homeworks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LessonDao implements Dao {

    private final Connection connection;

    public LessonDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addLesson(Lesson lesson) {
        String query = "INSERT INTO Lesson (id, name, homework_id) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, lesson.getId());
            statement.setString(2, lesson.getName());
            statement.setInt(3, lesson.getHomework().getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeLesson(Lesson lesson) {
        String query = "DELETE FROM Lesson WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, lesson.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Lesson> getAllLessons() {
        List<Lesson> lessons = new ArrayList<>();
        String query = "SELECT * FROM Lesson";
        try (
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)
        ) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int homeworkId = resultSet.getInt("homework_id");

                Homework homework = getHomeworkById(homeworkId);
                Lesson lesson = new Lesson(id, name, homework);
                lessons.add(lesson);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lessons;
    }

    @Override
    public Lesson getLessonById(int id) {
        String query = "SELECT * FROM Lesson WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                int homeworkId = resultSet.getInt("homework_id");

                Homework homework = getHomeworkById(homeworkId);
                return new Lesson(id, name, homework);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Homework getHomeworkById(int id) {
        String query = "SELECT * FROM Homework WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                return new Homework(id, name, description);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}