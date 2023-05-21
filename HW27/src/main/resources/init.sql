-- Creating the 'Student' table
CREATE TABLE Student (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255),
  email VARCHAR(255)
);

-- Creating the 'AddStudents' procedure
DELIMITER //
CREATE PROCEDURE AddStudents(IN N INT)
BEGIN
    DECLARE i INT DEFAULT 1;
    WHILE i <= N DO
        INSERT INTO Student (name, email) VALUES (CONCAT('Student ', i), CONCAT('student', i, '@example.com'));
        SET i = i + 1;
    END WHILE;
END //
DELIMITER ;

-- Call the 'AddStudents' procedure
Call AddStudents(10);