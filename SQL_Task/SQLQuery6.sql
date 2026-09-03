-- Create Database
CREATE DATABASE SchoolDB;


USE SchoolDB;


-- Create Student Table
CREATE TABLE Student (
    StudentID INT PRIMARY KEY,
    StudentName VARCHAR(50) NOT NULL,
    Class VARCHAR(20),
    City VARCHAR(50)
);

-- Create StudentMarks Table
CREATE TABLE StudentMarks (
    MarkID INT PRIMARY KEY,
    StudentID INT,
    SubjectName VARCHAR(50),
    Marks INT,
    FOREIGN KEY (StudentID) REFERENCES Student(StudentID)
);

INSERT INTO Student VALUES
(101, 'Rahul', '10th', 'Pune'),
(102, 'Priya', '10th', 'Mumbai'),
(103, 'Amit', '11th', 'Nashik'),
(104, 'Sneha', '11th', 'Pune');

INSERT INTO StudentMarks VALUES
(1, 101, 'Maths', 85),
(2, 101, 'Science', 90),
(3, 101, 'English', 78),

(4, 102, 'Maths', 92),
(5, 102, 'Science', 88),
(6, 102, 'English', 95),

(7, 103, 'Maths', 75),
(8, 103, 'Science', 80),
(9, 103, 'English', 70),

(10, 104, 'Maths', 89),
(11, 104, 'Science', 91),
(12, 104, 'English', 87);

select* from  Student
select* from  StudentMarks