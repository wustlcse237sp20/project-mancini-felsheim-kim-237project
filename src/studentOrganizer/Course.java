package studentOrganizer;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Manages a students course list.
 * Note: No test class is provided because all methods are trivial getters and setters.
 *
 */
public class Course {
	 
	String courseName;
	double courseGrade;
	
	public Course(String courseName) { 
		this.courseName = courseName;
	}
	 
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public void setCourseGrade(double courseGrade) {
		this.courseGrade = courseGrade;
	}
	
	public String getCourseName() {
		return this.courseName;
	}
	
	public double getCourseGrade() {
		return this.courseGrade;
	}
	
}
