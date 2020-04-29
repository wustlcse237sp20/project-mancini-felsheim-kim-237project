package studentOrganizer;

import java.time.LocalTime;

/**
 * Keeps track of an event to be recorded in a student's schedule.
 * Note: there is no test class because all functions are trivial.
 *
 */
public class ScheduleUnit implements Comparable<ScheduleUnit> {

	String eventTitle;
	String weekday;
	LocalTime startTime;
	LocalTime endTime;
	
	public ScheduleUnit (String eventTitle, String weekday, LocalTime[] meetingTime) {
		this.eventTitle = eventTitle;
		this.weekday = weekday;
		this.startTime = meetingTime[0];
		this.endTime = meetingTime[1];
	}
	
	public String getEventTitle() {
		return this.eventTitle;
	}
	
	public String getWeekday() {
		return this.weekday;
	}
	
	public LocalTime getStartTime() {
		return this.startTime;
	}
	
	public LocalTime getEndTime() {
		return this.endTime;
	}
	
	public LocalTime[] getMeetingTime() {
		return new LocalTime[]{this.startTime, this.endTime};
	}
	
	public String getStartTimeAsString() {
		return startTime.toString();
	}
	
	public String getEndTimeAsString() {
		return endTime.toString();
	}
	
	public void setEventTitle(String newEventTitle) {
		this.eventTitle = newEventTitle;
	}
	
	public void setMeetingTime(LocalTime[] newMeetingTime) {
		this.startTime = newMeetingTime[0];
		this.endTime = newMeetingTime[1];
	}
	
	@Override
	public int compareTo(ScheduleUnit otherEvent) {
		return this.startTime.compareTo(otherEvent.getStartTime());
	}
	
	@Override
	public String toString() {
		return this.eventTitle;
	}
 
	
}
