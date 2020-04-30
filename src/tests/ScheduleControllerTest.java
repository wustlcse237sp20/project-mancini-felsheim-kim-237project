package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import studentOrganizer.ScheduleController;

class ScheduleControllerTest {
	
	ScheduleController scheduleController = new ScheduleController();

	@Test
	void testAddAndGetEvent() {
		scheduleController.addEvent("Bio lecture", "Tuesday", new LocalTime[]{LocalTime.of(11, 30), LocalTime.of(13, 0)});
		scheduleController.addEvent("Chem lecture", "Tuesday", new LocalTime[]{LocalTime.of(13, 0), LocalTime.of(15, 0)});
		Assert.assertEquals(scheduleController.getEvent("Tuesday", 0).getEventTitle(), "Bio lecture");
		Assert.assertEquals(scheduleController.getEvent("Tuesday", 1).getEventTitle(), "Chem lecture");
	}
	
	@Test
	void testAddEventWithStringMeetingTime() {
		scheduleController.addEvent("Bio lecture", "Tuesday", "10:00-11:00");
		scheduleController.addEvent("Chem lecture", "Tuesday", "09:00-10:00");
		Assert.assertEquals(scheduleController.getEvent("Tuesday", 0).getEventTitle(), "Chem lecture");
		Assert.assertEquals(scheduleController.getEvent("Tuesday", 1).getEventTitle(), "Bio lecture");
	}
	
	@Test
	void testParseStringEventTimeToLocalTime() {
		scheduleController.addEvent("Bio lecture", "Tuesday", "10:00-11:00");
		Assert.assertEquals(scheduleController.getEvent("Tuesday", 0).getEndTimeAsString(), "11:00");
		Assert.assertEquals(scheduleController.getEvent("Tuesday", 0).getStartTimeAsString(), "10:00");
	}
	
	@Test
	void testGetEventsByDay() {
		scheduleController.addEvent("Bio lecture", "Tuesday", new LocalTime[]{LocalTime.of(11, 30), LocalTime.of(13, 0)});
		scheduleController.addEvent("Chem lecture", "Tuesday", new LocalTime[]{LocalTime.of(13, 0), LocalTime.of(15, 0)});
		Assert.assertEquals(scheduleController.getEventsByDay("Tuesday").get(0), "Bio lecture from 11:30 to 13:00");
		Assert.assertEquals(scheduleController.getEventsByDay("Tuesday").get(1), "Chem lecture from 13:00 to 15:00");
	}
	
	@Test
	void testAddSpecifiedEventsToSchedule() {
		JCheckBox sundayBox = new JCheckBox("Sunday");
		JCheckBox mondayBox = new JCheckBox("Monday");
		JCheckBox tuesdayBox = new JCheckBox("Tuesday");
		JCheckBox wednesdayBox = new JCheckBox("Wednesday");
		JCheckBox thursdayBox = new JCheckBox("Thursday");
		JCheckBox fridayBox = new JCheckBox("Friday");
		JCheckBox saturdayBox = new JCheckBox("Saturday");
		mondayBox.doClick();
		fridayBox.doClick();
		JCheckBox[] allBoxes = new JCheckBox[]{sundayBox, mondayBox, tuesdayBox, 
				wednesdayBox, thursdayBox, fridayBox, saturdayBox};
		scheduleController.addSpecifiedEventsToSchedule("Bio lecture", allBoxes, "10:00-11:00");
		Assert.assertEquals(scheduleController.getEventsByDay("Monday").get(0), "Bio lecture from 10:00 to 11:00");
		Assert.assertEquals(scheduleController.getEventsByDay("Friday").get(0), "Bio lecture from 10:00 to 11:00");
	}
	
	@Test
	void testUpdateEventTitle() {
		scheduleController.addEvent("Bio lecture", "Tuesday", "10:00-11:00");
		Assert.assertEquals(scheduleController.getEvent("Tuesday", 0).getEventTitle(), "Bio lecture");
		scheduleController.updateEventTitle("Tuesday", 0, "Chem lecture");
		Assert.assertEquals(scheduleController.getEvent("Tuesday", 0).getEventTitle(), "Chem lecture");
	}
	
	@Test
	void testUpdateMeetingTime() {
		scheduleController.addEvent("Chem lecture", "Tuesday", "09:00-10:00");
		scheduleController.addEvent("Bio lecture", "Tuesday", "10:00-11:00");
		Assert.assertEquals(scheduleController.getEvent("Tuesday", 1).getStartTimeAsString(), "10:00");
		Assert.assertEquals(scheduleController.getEvent("Tuesday", 1).getEndTimeAsString(), "11:00");
		scheduleController.updateMeetingTime("Tuesday", 0, "08:00-09:30");
		Assert.assertEquals(scheduleController.getEvent("Tuesday", 0).getStartTimeAsString(), "08:00");
		Assert.assertEquals(scheduleController.getEvent("Tuesday", 0).getEndTimeAsString(), "09:30");
	}
	
	@Test
	void testRemoveEvent() {
		scheduleController.addEvent("Bio lecture", "Tuesday", "10:00-11:00");
		scheduleController.addEvent("Chem lecture", "Tuesday", "09:00-10:00");
		Assert.assertEquals(scheduleController.getEvent("Tuesday", 1).getEventTitle(), "Bio lecture");
		Assert.assertEquals(scheduleController.getEvent("Tuesday", 0).getEventTitle(), "Chem lecture");
		scheduleController.removeEvent("Tuesday", 0);
		Assert.assertEquals(scheduleController.getEvent("Tuesday", 0).getEventTitle(), "Bio lecture");
	}
	
	

}
