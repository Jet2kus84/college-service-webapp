CREATE SCHEMA dbCourse;

CREATE TABLE dbCourse.tbCourse (
  idtbCourseNumber int(11) NOT NULL,
  tbCourseName mediumtext NOT NULL,
  tbCourseDescription longtext NOT NULL,
  tbCourseCategory tinytext NOT NULL,
  tbCourseNumberOfStudents int(11) NOT NULL,
  PRIMARY KEY (idtbCourseNumber));

CREATE TABLE dbCourse.STUDENT (
  STUDENTID varchar(20) NOT NULL,
  FIRSTNAME varchar(45) NOT NULL,
  LASTNAME varchar(45) NOT NULL,
  MIDDLEINITIAL varchar(2) DEFAULT NULL,
  DATEOFBIRTH varchar(10) NOT NULL,
  ACADEMIC_YEAR varchar(45) NOT NULL,
  COURSE_ID int(11) DEFAULT NULL,
  PRIMARY KEY (STUDENTID));

CREATE TABLE dbCourse.PROFESSOR (
  PROF_ID INT NOT NULL AUTO_INCREMENT,
  FIRSTNAME VARCHAR(45) NOT NULL,
  LASTNAME VARCHAR(45) NOT NULL,
  PRIMARY KEY (PROF_ID));
  
  CREATE TABLE dbCourse.ADVISOR (
  ADVISOR_ID INT NOT NULL AUTO_INCREMENT,
  FIRSTNAME VARCHAR(45) NOT NULL,
  LASTNAME VARCHAR(45) NOT NULL,
  PRIMARY KEY (ADVISOR_ID));

CREATE TABLE dbCourse.PASSWORD (
  TYPE_ID VARCHAR(20) NOT NULL,
  USERNAME VARCHAR(45) NOT NULL,
  PASSWORD VARCHAR(45) NOT NULL,
  PRIMARY KEY (TYPE_ID));