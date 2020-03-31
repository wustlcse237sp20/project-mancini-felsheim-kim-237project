package studentOrganizer;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Course {
	
	String courseName;
	double courseGrade;
	ArrayList<String> courseMeetingDays;
	// A course meeting time is an array of length 2: index 0 specifies start time
	// and index 1 specifies end time
	LocalTime[] courseMeetingTime; 
	ArrayList<ScheduleUnit> courseSchedule;
	
	public Course(String courseName) {
		this.courseName = courseName;
	}
	
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public void setCourseGrade(double courseGrade) {
		this.courseGrade = courseGrade;
	}
	
	/**
	 * Sets the course schedule given the meeting days and start/end times. Assumes that the course 
	 * meets at the same times of the day for each weekday it meets.
	 * @param weekdays ArrayList containing the weekdays (e.g. "Tuesday") that the class meets 
	 * @param startTime array specifying the start time of the class in hours (index 0) and 
	 * 		  in minutes (index 1), e.g. a 2:30 PM class would have a startTime of {14,30}
	 * @param endTime array specifying the end time of the class in hours (index 0) and in
	 * 		  minutes (index 1), e.g. a class that ends at 4:00 PM would have an endTime of {16, 0}
	 */
	public void setCourseSchedule(ArrayList<String> weekdays, int[] startTime, int[] endTime) {
		this.courseMeetingDays = weekdays;
		this.courseMeetingTime = new LocalTime[]{LocalTime.of(startTime[0], startTime[1]),
				LocalTime.of(endTime[0], endTime[1])};
		this.courseSchedule = new ArrayList<ScheduleUnit>();
		for (String day: weekdays) {
			this.courseSchedule.add(new ScheduleUnit(this.courseName, day, this.courseMeetingTime));
		}
	}
	
	public String getCourseName() {
		return this.courseName;
	}
	
	public double getCourseGrade() {
		return this.courseGrade;
	}
	
	public LocalTime[] getCourseMeetingTime() {
		return this.courseMeetingTime;
	}
	
	public ArrayList<String> getCourseMeetingDays() {
		return this.courseMeetingDays;
	}
	
	public ArrayList<ScheduleUnit> getCourseSchedule() {
		return this.courseSchedule;
	}
	
	
}
