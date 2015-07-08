package edu.depaul.djohn.entity;

import java.util.ArrayList;
import java.util.List;

public abstract class Schedule {

	private final List<Course> courses;
	
	public Schedule() {
		courses = new ArrayList<>();
	}
	
	/**
	 * 
	 * @param _course to enroll student in.
	 */
	public void enroll(Course _course) {
		
		//Search to see if student is already enrolled in course.
		for(Course c : courses)
			if(c.getIdentifier().equalsIgnoreCase(_course.getIdentifier()))
				return;
		
		//if student isn't enrolled in this course, enroll student.
		courses.add(_course);
		_course.setNumberOfStudentsEnrolled(+1);
	}
	
	/**
	 * 
	 * @param _course to remove from student schedule.
	 */
	public void drop(Course _course) {
		courses.remove(_course);
		_course.setNumberOfStudentsEnrolled(-1);
	}
	
	/**
	 * 
	 * @return list of courses student is enrolled in
	 */
	public List<Course> schedule() {
		return courses;
	}
}
