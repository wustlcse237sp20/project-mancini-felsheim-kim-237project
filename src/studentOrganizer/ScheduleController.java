package studentOrganizer;

import java.time.LocalTime;

import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;

/**
 * ScheduleController is a mediator between the main schedule model and the user interface
 * Tests can be found in ScheduleControllerTest.java
 */
public class ScheduleController {
	private Schedule schedule;
	
	public ScheduleController() {
		schedule = new Schedule();
	}
	
	public void addEvent(String eventTitle, String weekday, LocalTime[] meetingTime) {
		schedule.addEventToSchedule(eventTitle, weekday, meetingTime);
	}
	
	public void addEvent(String eventTitle, String weekday, String stringMeetingTime) {
		LocalTime[] meetingTime = parseStringEventTimeToLocalTime(stringMeetingTime);
		schedule.addEventToSchedule(eventTitle, weekday, meetingTime);
	}
	
	public ScheduleUnit getEvent(String weekday, int index) {
		return schedule.getScheduleUnitByIndexAndDay(weekday, index);
	}
	
	public void removeEvent(String weekday, int index) {
		schedule.removeEventFromSchedule(weekday, index);
	}
	
	public void updateEventTitle(String weekday, int index, String newEventTitle) {
		schedule.updateEventTitle(weekday, index, newEventTitle);
	}
	
	public void updateMeetingTime(String weekday, int index, String newStringMeetingTime) {
		LocalTime[] newMeetingTime = parseStringEventTimeToLocalTime(newStringMeetingTime);
		schedule.updateEventMeetingTime(weekday, index, newMeetingTime);
	}
	
	public void addSpecifiedEventsToSchedule(String eventTitle, JCheckBox[] dayBoxes, String stringMeetingTime) {
		LocalTime[] eventMeetingTime = parseStringEventTimeToLocalTime(stringMeetingTime);
		String [] weekday = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		for (int i = 0; i < 7; i++) {
			if(dayBoxes[i].isSelected()) {
				schedule.addEventToSchedule(eventTitle, weekday[i], eventMeetingTime);
			}
		}
	}
	
	public DefaultListModel<String> getEventsByDay(String weekday){
		DefaultListModel<String> dayEvents = new DefaultListModel<>();
		for (String event: schedule.getScheduleSentencesForDay(weekday)) {
			dayEvents.addElement(event);
		}
		return dayEvents;
	}
	
	private LocalTime[] parseStringEventTimeToLocalTime(String stringEventTime) {
		String startString = stringEventTime.split("-")[0];
		String endString = stringEventTime.split("-")[1];
		
		int startHour = Integer.parseInt(startString.split(":")[0]);
		int startMinute = Integer.parseInt(startString.split(":")[1]);
		int endHour = Integer.parseInt(endString.split(":")[0]);
		int endMinute = Integer.parseInt(endString.split(":")[1]);
		
		LocalTime[] eventMeetingTime = new LocalTime[]{LocalTime.of(startHour, startMinute),
				LocalTime.of(endHour, endMinute)};
		
		return eventMeetingTime;
	}
	
	
}
