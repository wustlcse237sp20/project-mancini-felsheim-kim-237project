package studentOrganizer;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Course {
	
	String courseName;
	double courseGrade;
	Map<String, LocalTime[]> courseSchedule;
	
	public Course(String courseName) {
		this.courseName = courseName;
	}
	
	public void setCourseMeetingTime(ArrayList<String> weekdays, int[] startTime, int[] endTime) {
		courseSchedule = new HashMap<String, LocalTime[]>();
		for (String day: weekdays) {
			LocalTime[] startAndEndTimes = {LocalTime.of(startTime[0], startTime[1]), 
					LocalTime.of(endTime[0], endTime[1])};
			courseSchedule.put(day, startAndEndTimes);
		}
	}
}
