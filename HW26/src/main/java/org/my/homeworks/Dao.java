package org.my.homeworks;

import java.util.List;

public interface Dao {

    void addLesson(Lesson lesson);

    void removeLesson(Lesson lesson);

    List<Lesson> getAllLessons();

    Lesson getLessonById(int id);
}
