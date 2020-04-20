package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

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
	void testGetEventsByDay() {
		scheduleController.addEvent("Bio lecture", "Tuesday", new LocalTime[]{LocalTime.of(11, 30), LocalTime.of(13, 0)});
		scheduleController.addEvent("Chem lecture", "Tuesday", new LocalTime[]{LocalTime.of(13, 0), LocalTime.of(15, 0)});
		Assert.assertEquals(scheduleController.getEventsByDay("Tuesday").get(0), "Bio lecture from 11:30 to 13:00");
		Assert.assertEquals(scheduleController.getEventsByDay("Tuesday").get(0), "Chem lecture from 13:00 to 15:00");
	}

}
