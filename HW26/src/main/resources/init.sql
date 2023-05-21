-- Creating the 'Homework' table
CREATE TABLE Homework (
  id INT PRIMARY KEY,
  name VARCHAR(255),
  description VARCHAR(255)
);

-- Creating the 'Lesson' table
CREATE TABLE Lesson (
  id INT PRIMARY KEY,
  name VARCHAR(255),
  updatedAt TIMESTAMP,
  homework_id INT,
  FOREIGN KEY (homework_id) REFERENCES Homework(id)
);

-- Inserting data into the 'Homework' table
INSERT INTO Homework (id, name, description)
VALUES
  (1, 'Homework 1', 'Description 1');