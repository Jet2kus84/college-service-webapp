package edu.depaul.djohn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * 
 * @author Deonte D Johnson
 * Adding a persistence layer
 *
 */

@Entity(name = "tbCourse") 
@Table(name="tbCourse", schema="dbCourse") //because table name is different than class name
@XmlRootElement
public class Course implements Serializable, edu.depaul.djohn.entity.Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8589079804083426131L;

	@Id //signifies the primary key
	@Column(name = "idtbCourseNumber", nullable = false) //added fields because name field name is different
	private int courseNumber = 0;
	
	@Column(name = "tbCourseName", nullable = false)
	private String courseName = null;
	
	@Column(name = "tbCourseDescription", nullable = false)
	private String courseDescription = null;
	
	@Column(name = "tbCourseCategory", nullable = false)
	private String courseCategory = null;
	
	@Column(name = "tbCourseNumberOfStudents", nullable = false)
	private int numberOfStudentsEnrolled = 0;
	
	//@ManyToOne(fetch=FetchType.LAZY)
	//@JoinColumn(name="PROFESSOR_ID")
	//private Professor professor;
	
	@OneToMany(targetEntity=Student.class)
	@JoinColumn(name="COURSE_ID")
	private final java.util.List<Student> students;
	
	//default no-argument constructor to conform to persistent rules
	public Course() { 
		students = new java.util.ArrayList<>();
	}
	
        /**
         * 
         * @return value used to identify course, the value is a string 
         * that consist of the course category and the course number
         */
	public String getIdentifier() {
		return courseCategory + courseNumber;
	}
	
        /**
         * 
         * @return the actual full name of the course being added
         */
	public String getCourseName() {
		return courseName;
	}

        /**
         *  
         * @param courseName is the actual full name of the course
         * being added
         */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
        
        /**
         * 
         * @return the course number associated with the actual course
         */
	public int getCourseNumber() {
		return courseNumber;
	}

        /**
         * 
         * @param courseNumber the number associated with the actual course
         */
	public void setCourseNumber(int courseNumber) {
		this.courseNumber = courseNumber;
	}

        /**
         * 
         * @return what this course is about
         */
	public String getCourseDescription() {
		return courseDescription;
	}

        /**
         * 
         * @param courseDescription is a description of what the course
         * is about
         */
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
        
        /**
         * 
         * @return the abbriavated course category this course is in
         */
	public String getCourseCategory() {
		return courseCategory;
	}

        /**
         * 
         * @param courseCategory the abbriavated course 
         * category this course is in
         */
	public void setCourseCategory(String courseCategory) {
		this.courseCategory = courseCategory;
	}

        /**
         * 
         * @return number of student currently in the course
         */
	public int getNumberOfStudentsEnrolled() {
            //redundant code but already added
		return numberOfStudentsEnrolled;
	}

        /**
         * 
         * @param numberOfStudentsEnrolled is the number of students currently
         * in the course
         */
	public void setNumberOfStudentsEnrolled(int numberOfStudentsEnrolled) {
            //this method will not be used
            this.numberOfStudentsEnrolled = numberOfStudentsEnrolled;
	}

        /**
         * 
         * @return list of student in the course 
         */
        @XmlTransient
	public java.util.List<Student> getStudents() {
		return students;
	}
	
        @Override
        public String getId() {
            return String.valueOf(courseNumber);
        }
        
        @Override
	public String toString() {
		
		StringBuilder b = new StringBuilder();
		b.append("Section: ").append(courseCategory).append(" ").append(courseNumber).append("\n");
		b.append("Course Name: ").append(courseName).append("\n");
		b.append("Course Description: ").append(courseDescription).append("\n");
		return b.toString();
        }
}
