package studentOrganizer;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Manages a student's schedule of events (ScheduleUnits).
 * Test cases for Schedule can be found in ScheduleTest.java
 *
 */
public class Schedule {
	
	HashMap<String, ArrayList<ScheduleUnit>> schedule;
	
	public Schedule() {
		this.schedule = new HashMap<>();
		this.schedule.put("Sunday", new ArrayList<ScheduleUnit>());
		this.schedule.put("Monday", new ArrayList<ScheduleUnit>());
		this.schedule.put("Tuesday", new ArrayList<ScheduleUnit>());
		this.schedule.put("Wednesday", new ArrayList<ScheduleUnit>());
		this.schedule.put("Thursday", new ArrayList<ScheduleUnit>());
		this.schedule.put("Friday", new ArrayList<ScheduleUnit>());
		this.schedule.put("Saturday", new ArrayList<ScheduleUnit>());
	}
	
	public void addEventToSchedule(String eventTitle, String weekday, LocalTime[] meetingTime) {
		ScheduleUnit event = new ScheduleUnit(eventTitle, weekday, meetingTime);
		ArrayList<ScheduleUnit> currentSchedule = this.schedule.get(weekday);
		currentSchedule.add(event);
		this.schedule.put(weekday, currentSchedule);
		sortAllEventsInScheduleByTime();
	}
	
	public void removeEventFromSchedule(String weekday, int index) {
		this.schedule.get(weekday).remove(index);
	}
	
	public void updateEventTitle(String weekday, int index, String newEventTitle) {
		this.schedule.get(weekday).get(index).setEventTitle(newEventTitle);
	}
	
	public void updateEventMeetingTime(String weekday, int index, LocalTime[] newMeetingTime) {
		this.schedule.get(weekday).get(index).setMeetingTime(newMeetingTime);
	}
	
	public ArrayList<ScheduleUnit> getScheduleUnitsForDay(String day) {
		return schedule.get(day);
	}
	
	public ArrayList<String> getScheduleSentencesForDay(String day) {
		ArrayList<String> scheduleSentences = new ArrayList<String>();
		for (ScheduleUnit event: schedule.get(day)) {
			String sentence = event.getEventTitle() + " from " + event.getStartTimeAsString() 
							  + " to " + event.getEndTimeAsString();
			scheduleSentences.add(sentence);
		}
		return scheduleSentences;
	}
	
	public ScheduleUnit getScheduleUnitByIndexAndDay(String day, int index) {
		return schedule.get(day).get(index);
	}
	
	public void sortAllEventsInScheduleByTime() {
		for (String day: schedule.keySet()) {
			ArrayList<ScheduleUnit> sortedDayEvents = new ArrayList<ScheduleUnit>();
			sortedDayEvents.addAll(schedule.get(day));
			Collections.sort(sortedDayEvents);
			schedule.get(day).clear();
			schedule.get(day).addAll(sortedDayEvents);
		}
	}
	

}




