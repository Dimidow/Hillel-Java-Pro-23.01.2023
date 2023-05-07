-- Retrieving all records from Homework
SELECT * FROM Homework limit 10;

-- Retrieving all records from Lesson, including Homework data
SELECT Lesson.*, Homework.name AS homework_name, Homework.description AS homework_description
FROM Lesson
JOIN Homework ON Lesson.homework_id = Homework.id limit 10;

-- Retrieving all records from Lesson (including Homework data) sorted by update time
SELECT Lesson.*, Homework.name AS homework_name, Homework.description AS homework_description
FROM Lesson
JOIN Homework ON Lesson.homework_id = Homework.id
ORDER BY Lesson.updatedAt limit 10;

-- Retrieving all records from Schedule, including Lesson data
SELECT Schedule.*, Lesson.name AS lesson_name, Lesson.updatedAt AS lesson_updatedAt,
       Homework.name AS homework_name, Homework.description AS homework_description
FROM Schedule
JOIN Lesson ON Lesson.id = Schedule.id
JOIN Homework ON Lesson.homework_id = Homework.id limit 10;

-- Retrieving the count of Lessons for each Schedule
SELECT Schedule.*, Lesson.name AS lesson_name, Lesson.updatedAt AS lesson_updatedAt,
        Homework.name AS homework_name, Homework.description AS homework_description
FROM Schedule
JOIN Lesson_Schedule ON Schedule.id = Lesson_Schedule.schedule_id
JOIN Lesson ON Lesson_Schedule.lesson_id = Lesson.id
JOIN Homework ON Lesson.homework_id = Homework.id
LIMIT 10;