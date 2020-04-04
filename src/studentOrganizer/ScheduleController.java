package studentOrganizer;

import javax.swing.DefaultListModel;

/**
 * ScheduleController is a mediator between the main schedule model and the user interface
 */
public class ScheduleController {
	private DefaultListModel<Course> events;
	
	public ScheduleController() {
		events = new DefaultListModel<>();
	}
	
	public void addCourseMeeting(String name) {
		events.addElement(new Course(name));
	}
	
	public void removeCourseMeeting(int index) {
		events.remove(index);
	}
	
	public DefaultListModel<Course> getAllCourses(){
		//TODO: implement method
		return events;
	}
	
	public DefaultListModel<Course> getMondayCourses(){
		//TODO: implement method for next iteration
		return events;
	}

	public DefaultListModel<Course> getTuesdayCourses(){
		//TODO: implement method for next iteration
		return events;
	}
	
	public DefaultListModel<Course> getWednesdayCourses(){
		//TODO: implement method for next iteration
		return events;
	}
	
	public DefaultListModel<Course> getThursdayCourses(){
		//TODO: implement method for next iteration
		return events;
	}
	
	public DefaultListModel<Course> getFridayCourses(){
		//TODO: implement method for next iteration
		return events;
	}
	
	public DefaultListModel<Course> getSaturdayCourses(){
		//TODO: implement method for next iteration
		return events;
	}
	
	public DefaultListModel<Course> getSundayCourses(){
		//TODO: implement method for next iteration
		return events;
	}
}
