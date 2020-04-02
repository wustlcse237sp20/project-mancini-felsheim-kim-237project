package studentOrganizer;

import java.time.LocalTime;

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
	
	@Override
	public int compareTo(ScheduleUnit otherEvent) {
		return this.startTime.compareTo(otherEvent.getStartTime());
	}
 
	
}
