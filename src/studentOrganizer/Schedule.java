package studentOrganizer;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

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
	
	public void addEventsToSchedule(ArrayList<ScheduleUnit> events) {
		for (ScheduleUnit event: events) {
			String day = event.getWeekday();
			ArrayList<ScheduleUnit> currentSchedule = this.schedule.get(day);
			currentSchedule.add(event);
			this.schedule.put(day, currentSchedule);
		}
		sortAllEventsInScheduleByTime();
	}
	
	public void addEventToSchedule(ScheduleUnit event) {
		String day = event.getWeekday();
		ArrayList<ScheduleUnit> currentSchedule = this.schedule.get(day);
		currentSchedule.add(event);
		this.schedule.put(day, currentSchedule);
		sortAllEventsInScheduleByTime();
	}
	
	public void addEventToSchedule(String eventTitle, String weekday, LocalTime[] meetingTime) {
		ScheduleUnit event = new ScheduleUnit(eventTitle, weekday, meetingTime);
		ArrayList<ScheduleUnit> currentSchedule = this.schedule.get(weekday);
		currentSchedule.add(event);
		this.schedule.put(weekday, currentSchedule);
		sortAllEventsInScheduleByTime();
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




