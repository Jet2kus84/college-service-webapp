package edu.depaul.djohn.entity;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "ADVISOR")
@Table(name="ADVISOR", schema="dbCourse") 
@XmlRootElement
public class Advisor implements Serializable, edu.depaul.djohn.entity.Entity {
 
        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        @Column(name = "ADVISOR_ID", nullable = false) 
        private int id;
        
        @Column(name = "FIRSTNAME", nullable = false) 
	private String firstName;
        
        @Column(name = "LASTNAME", nullable = false) 
	private String lastName;
	
        @Transient//@OneToMany
	private final ArrayList<Student> students;
        
	public Advisor() {
		students = new ArrayList<>();
		firstName = null;
		lastName = null;
	}
	
        /**
         * 
         * @param _student 
         */
	public void addStudent(Student _student) {
		if(_student == null ) return;
		students.add(_student);
	}
	
        
        /**
         * 
         * @param _student 
         */
	public void remove(Student _student) {
		if(_student == null) return;
		students.remove(_student);
	}
	
        /**
         * 
         * @return 
         */
	public ArrayList<Student> getStudentList() {
		return students;
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
        
        public void setID(int id) {
            this.id = id;
        }
        
        @Override
        public String getId() {
            return String.valueOf(id);
        }
    
        @Override
        public String toString() {
            String schema = "Advisor Name: " + 
                    this.getFirstName() + " " +
                    this.getLastName() + "<br>" +
                    "Professor ID: " + 
                    this.id + "<br>";
		return schema;
        }
}
