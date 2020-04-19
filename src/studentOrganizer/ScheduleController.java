package studentOrganizer;

import java.time.LocalTime;

import javax.swing.DefaultListModel;

/**
 * ScheduleController is a mediator between the main schedule model and the user interface
 */
public class ScheduleController {
	private Schedule schedule;
	
	public ScheduleController() {
		schedule = new Schedule();
	}
	
	public void addEvent(String eventTitle, String weekday, LocalTime[] meetingTime) {
		schedule.addEventToSchedule(eventTitle, weekday, meetingTime);
	}
	
	public void removeEvent(int index) {
		//TODO: implement for next iteration
	}
	
	public DefaultListModel<String> getEventsByDay(String weekday){
		DefaultListModel<String> dayEvents = new DefaultListModel<>();
		for (String event: schedule.getScheduleSentencesForDay(weekday)) {
			dayEvents.addElement(event);
		}
		return dayEvents;
	}
	
}
