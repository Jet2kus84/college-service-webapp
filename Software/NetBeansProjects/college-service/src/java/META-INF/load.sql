INSERT INTO dbCourse.PASSWORD
(TYPE_ID,
USERNAME,
PASSWORD)
VALUES 
('ADVISOR',
'advisor',
'adv2015');

INSERT INTO dbCourse.PASSWORD
(TYPE_ID,
USERNAME,
PASSWORD)
VALUES 
('PROFESSOR',
'professor',
'prof2015');

INSERT INTO dbCourse.PASSWORD
(TYPE_ID,
USERNAME,
PASSWORD)
VALUES 
('STUDENT',
'student',
'stu2015');

INSERT INTO dbcourse.student (STUDENTID, FIRSTNAME, LASTNAME, MIDDLEINITIAL, DATEOFBIRTH, ACADEMIC_YEAR, COURSE_ID) 
	VALUES ('DBaker1979', 'Daniel', 'Baker', 'T', '3/28/1979', 'Senior', NULL);

INSERT INTO dbcourse.student (STUDENTID, FIRSTNAME, LASTNAME, MIDDLEINITIAL, DATEOFBIRTH, ACADEMIC_YEAR, COURSE_ID) 
	VALUES ('DBradley1980', 'Donald', 'Bradley', 'D', '4/28/1980', 'Senior', NULL);

INSERT INTO dbcourse.student (STUDENTID, FIRSTNAME, LASTNAME, MIDDLEINITIAL, DATEOFBIRTH, ACADEMIC_YEAR, COURSE_ID) 
	VALUES ('djohnson1984', 'Deonte', 'Johnson', 'D', '06/23/1984', 'Freshman', NULL);

INSERT INTO dbcourse.student (STUDENTID, FIRSTNAME, LASTNAME, MIDDLEINITIAL, DATEOFBIRTH, ACADEMIC_YEAR, COURSE_ID) 
	VALUES ('JMcClure1979', 'John', 'McClure', 'C', '11/23/1979', 'Freshman', NULL);

INSERT INTO dbcourse.student (STUDENTID, FIRSTNAME, LASTNAME, MIDDLEINITIAL, DATEOFBIRTH, ACADEMIC_YEAR, COURSE_ID) 
	VALUES ('LThigpen1984', 'LaToya', 'Thigpen', 'L', '6/5/1984', 'Senior', NULL);

INSERT INTO dbcourse.student (STUDENTID, FIRSTNAME, LASTNAME, MIDDLEINITIAL, DATEOFBIRTH, ACADEMIC_YEAR, COURSE_ID) 
	VALUES ('PKilo1979', 'Patrick', 'Kilo', 'B', '7/14/1979', 'Junior', NULL);

INSERT INTO dbcourse.student (STUDENTID, FIRSTNAME, LASTNAME, MIDDLEINITIAL, DATEOFBIRTH, ACADEMIC_YEAR, COURSE_ID) 
	VALUES ('RCalvier1990', 'Ramond', 'Calvier', 'K', '9/23/1990', 'Junior', NULL);

INSERT INTO dbcourse.student (STUDENTID, FIRSTNAME, LASTNAME, MIDDLEINITIAL, DATEOFBIRTH, ACADEMIC_YEAR, COURSE_ID) 
	VALUES ('SHoward1983', 'Shonda', 'Howard', 'L', '8/12/1983', 'Freshman', NULL);

INSERT INTO dbcourse.student (STUDENTID, FIRSTNAME, LASTNAME, MIDDLEINITIAL, DATEOFBIRTH, ACADEMIC_YEAR, COURSE_ID) 
	VALUES ('SHardin1980', 'Sandra', 'Hardin', 'L', '4/23/1980', 'Sophomore', NULL);

INSERT INTO dbcourse.tbcourse (idtbCourseNumber, tbCourseName, tbCourseDescription, tbCourseCategory, tbCourseNumberOfStudents) 
	VALUES (210, 'Descrete Mathematics', 'This course will prepare student for programming			', 'MATH', 0);

INSERT INTO dbcourse.tbcourse (idtbCourseNumber, tbCourseName, tbCourseDescription, tbCourseCategory, tbCourseNumberOfStudents) 
	VALUES (300, 'Calculus ll', 'This course will expand on the material taught in calculus I.', 'MATH', 0);

INSERT INTO dbcourse.tbcourse (idtbCourseNumber, tbCourseName, tbCourseDescription, tbCourseCategory, tbCourseNumberOfStudents) 
	VALUES (450, 'Object Oriented Programming', 'This class focuses on patterns', 'SE', 0);


INSERT INTO dbcourse.tbcourse (idtbCourseNumber, tbCourseName, tbCourseDescription, tbCourseCategory, tbCourseNumberOfStudents) 
	VALUES (480, 'Agile Software Development', 'This course will teach students the methodology of agile development. Students 
will develop projects using agile development technics.			', 'SE', 0);


INSERT INTO dbcourse.tbcourse (idtbCourseNumber, tbCourseName, tbCourseDescription, tbCourseCategory, tbCourseNumberOfStudents) 
	VALUES (554, 'Enterprise Java Beans', 'Discusses EJB, JDNI, JPA. This course continues material covered in SE 452');			', 'SE', 0);

INSERT INTO dbcourse.professor (FIRSTNAME, LASTNAME) 
	VALUES ('Michael', 'Shannon');

INSERT INTO dbcourse.professor (FIRSTNAME, LASTNAME) 
	VALUES ('Michael', 'Shannon');

INSERT INTO dbcourse.ADVISOR (ADVISOR_ID, FIRSTNAME, LASTNAME) 
	VALUES (1902, 'James', 'Addision');

INSERT INTO dbcourse.ADVISOR (ADVISOR_ID, FIRSTNAME, LASTNAME) 
	VALUES (4322, 'Robert', 'Thomas');

INSERT INTO dbcourse.ADVISOR (ADVISOR_ID, FIRSTNAME, LASTNAME) 
	VALUES (2626, 'Carol', 'Atkins');

