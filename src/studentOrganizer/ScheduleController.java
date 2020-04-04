package studentOrganizer;

import java.util.*;

import javax.swing.DefaultListModel;

public class ScheduleController {
	private DefaultListModel<Course> classes;
	
	public ScheduleController() {
		classes = new DefaultListModel<>();
	}
	public void addCourseMeeting(String name) {
		classes.addElement(new Course(name));
	}
	public void removeCourseMeeting(int index) {
		classes.remove(index);
	}
	public DefaultListModel<Course> getAllCourses(){
		return classes;
	}
	
	public DefaultListModel<Course> getMondayCourses(){
		return classes;
	}

	public DefaultListModel<Course> getTuesdayCourses(){
		return classes;
	}
	
	public DefaultListModel<Course> getWednesdayCourses(){
		return classes;
	}
	
	public DefaultListModel<Course> getThursdayCourses(){
		return classes;
	}
	
	public DefaultListModel<Course> getFridayCourses(){
		return classes;
	}
	
	public DefaultListModel<Course> getSaturdayCourses(){
		return classes;
	}
	
	public DefaultListModel<Course> getSundayCourses(){
		return classes;
	}
}
