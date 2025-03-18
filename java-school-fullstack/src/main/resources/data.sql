INSERT INTO teacher (tFName, tLName, dept) VALUES
('Hedy','Lamarr','Computer Science'),
('Radia','Perlman','Computer Science'),
('Annie','Easley','Computer Science'),
('Peter','Denning','Computer Science'),
('Ravi','Sethi','Computer Science'),
('Hilary','Mantel','English'),
('Margaret','Atwood','English'),
('David','Mitchell','English'),
('Michael','Chabon','English'),
('Neil','Gaiman','English');

INSERT INTO course (courseCode, CourseDesc, teacherId) VALUES
('CS148','Intro to Data Structures',1),
('CS100','Intro to Java',2),
('CS202','Intermediate Java',1),
('CS305','Advanced Python',5),
('CS407','Information Systems Management',4),
('CS206','Network Design',4),
('CS503','Advanced Cyber Security',3),
('CS326','Advanced Fortran',5),
('CS324','Advanced Web Services with Java API',3),
('EN220','Fictional Writing',10),
('EN250','Fantasy Fictional Writing',11),
('EN100','Writing Basics',NULL),
('EN200','English Composition',NULL),
('EN300','Poetry Writing',NULL);

INSERT INTO student (FName, LName) VALUES
('Jolene','Westcott'),
('Tabby','Daniell'),
('Hans','Wozniak'),
('Ifeanyi','Derichs'),
('Guafrid','Lopez'),
('Helena','Abbandonato'),
('Aime','Larsen'),
('Milada','Dreher');

INSERT INTO course_student (student_id, course_id) VALUES
(1,1),
(1,2),
(2,1),
(2,2),
(2,3),
(1,3),
(1,5),
(2,4),
(2,6),
(3,2),
(3,3),
(3,4),
(3,5),
(4,1),
(4,4),
(4,5),
(4,6),
(4,7),
(5,1),
(5,2),
(5,4),
(5,6),
(6,1),
(6,3),
(6,5),
(6,6),
(6,7),
(7,1),
(7,2),
(7,3),
(7,5),
(7,6),
(7,7),
(8,3),
(8,5),
(8,6),
(8,7);