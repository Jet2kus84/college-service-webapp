package edu.depaul.djohn.entity;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "PROFESSOR")
@Table(name="PROFESSOR", schema="dbCourse") 
@XmlRootElement
public class Professor implements Serializable, edu.depaul.djohn.entity.Entity {
	
	@Id()
	@Column(name = "PROF_ID", nullable = false) 
	private int id;
	
	@Column(name = "FIRSTNAME", nullable = false) 
	private String firstName;
	
	@Column(name = "LASTNAME", nullable = false) 
	private String lastName;
	
	@Transient//@OneToMany//(mappedBy="professor")
	private final ArrayList<Course> assignedCourses;
	
	@Transient//@OneToMany//(mappedBy="")
	private final ArrayList<Student> students;
	
	public Professor() {
		students = new ArrayList<>();
		assignedCourses = new ArrayList<>();
		firstName = null;
		lastName = null;
	}
	
	public void addStudent(Student _student) {
		if(_student == null ) return;
		students.add(_student);
	}
	
	public void remove(Student _student) {
		if(_student == null) return;
		students.remove(_student);
	}
	
	public ArrayList<Student> getStudentList() {
		return students;
	}
	
	public void assignCourse(Course course) {
		if(course == null) return;
		assignedCourses.add(course);
	}
	
	public void unassignCourse(Course course) {
		if(course == null) return;
		assignedCourses.remove(course);
	} 
	
        /**
         * 
         * @param _firstName 
         */
	public void setFirstName(String _firstName) {
		this.firstName = _firstName;
	}
	
        /**
         * 
         * @return 
         */
	public String getFirstName() {
		return firstName;
	}
	
        /**
         * 
         * @param _lastName 
         */
	public void setLastName(String _lastName) {
		this.lastName = _lastName;
	}
	
        /**
         * 
         * @return 
         */
	public String getLastName() {
		return lastName;
	}
	
        @Override
        public String getId() {
            return String.valueOf(this.id);
        }
        
        public void setID(int id) {
            this.id = id;
        }
        
        
        @Override
        public String toString() {
            String schema = "Profesor Name: " + 
                    this.getFirstName() + " " +
                    this.getLastName() + "<br>" +
                    "Professor ID: " + 
                    this.id + "<br>";
		return schema;
        }
}
