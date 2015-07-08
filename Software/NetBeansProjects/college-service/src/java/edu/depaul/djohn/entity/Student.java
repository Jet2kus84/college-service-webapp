package edu.depaul.djohn.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity(name = "STUDENT")
@Table(name="STUDENT", schema="dbCourse") 
@XmlRootElement
public class Student extends Schedule implements Serializable, 
        edu.depaul.djohn.entity.Entity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "STUDENTID", nullable = false)
	private String studentId;
	
	@Column(name = "FIRSTNAME", nullable = false)
	private String firstName;
	
	@Column(name = "LASTNAME", nullable = false)
	private String lastName;
	
	@Column(name = "MIDDLEINITIAL", nullable = true)
	private String middleInitial = " ";
	
	@Column(name = "DATEOFBIRTH", nullable = false)
	private String DateOfBirth;
	
	//@Embedded
	@Transient
	private DOB dateOfBirth;
	
	@Column(name = "ACADEMIC_YEAR", nullable = false)
	private String year;

        @Override
        public String getId() {
            return this.studentId;
        }
	
	//construct date of birth for student
	//@Embeddable
	public static class DOB implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = -355926033687256453L;
		public int month, day, year;
                @Override
		public String toString() {
			return month + "/" + day + "/" + year;
		}
	}
	
	@OneToMany(targetEntity=Course.class)
	@JoinColumn(name="idtbCourseNumber")
	private final List<Course> schedule;
	
	public Student() {
		schedule = new java.util.ArrayList<>();
	}
		
	public void setStudentID() {
		studentId = firstName.substring(0, 1) + lastName + dateOfBirth.year;
	}

	/**
	 * 
	 * @return student's first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * 
	 * @param firstName set student's first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * 
	 * @return student's last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * 
	 * @param lastName set student's last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * 
	 * @return student's initial of middle name
	 */
	public String getMiddleInitial() {
		return middleInitial;
	}

	/**
	 * 
	 * @param middleInitial set student's initial of middle name
	 */
	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}

	/**
	 * 
	 * @return student's date of birth
	 */
	public DOB getDateOfBirth() {
		return dateOfBirth; 
	}

	/**
	 * 
	 * @param month student's birth month
	 * @param day student's birth day
	 * @param year student's birth year
	 */
	public void setDateOfBirth(int month, int day, int year) {
		dateOfBirth = new DOB();
		this.dateOfBirth.month = month;
		this.dateOfBirth.day = day;
		this.dateOfBirth.year = year;
		
		DateOfBirth = dateOfBirth.toString();
	}

	/**
	 * 
	 * @return student's academic year
	 */
	public String getYear() {
		return year;
	}

	/**
	 * 
	 * @param year set student's academic year
	 */
	public void setYear(String year) {
		this.year = year;
	}
	
        @Override
	public String toString() {
		String classes = " ";
		for(Course c : schedule)
			classes = "\nStudent Schedule: " + c;
		
		String schema = "Student Name: " + 
				this.getFirstName() + " " +
				this.middleInitial + " " + 
				this.getLastName() + "<br>" +
				"Date Of Birth: " + 
				this.DateOfBirth + "<br>" +
				"Student ID: " + this.studentId + "<br>" +
				classes;
		
		return schema;
	}
	
	/**
	 * 
	 * @param _course to enroll student in.
	 */
        @Override
	public void enroll(Course _course) {
		
		//Search to see if student is already enrolled in course.
		for(Course c : schedule)
			if(c.getIdentifier().equalsIgnoreCase(_course.getIdentifier()))
				return;
		
		//if student isn't enrolled in this course, enroll student.
		schedule.add(_course);
		_course.setNumberOfStudentsEnrolled(+1);
	}
	
	/**
	 * 
	 * @param _course to remove from student schedule.
	 */
        @Override
	public void drop(Course _course) {
		schedule.remove(_course);
		_course.setNumberOfStudentsEnrolled(-1);
	}
	
	/**
	 * 
	 * @return list of courses student is enrolled in
	 */
        @XmlTransient
	public List<Course> getSchedule() {
		return schedule;
	}
}
