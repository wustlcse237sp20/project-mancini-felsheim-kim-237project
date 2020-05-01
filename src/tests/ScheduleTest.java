package tests;

import java.time.LocalTime;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import studentOrganizer.Schedule;
import studentOrganizer.ScheduleUnit;

class ScheduleTest {
	Schedule schedule = new Schedule();
	

	@Test
	void testAddEventToScheduleAndGetScheduleUnitsForDay() {
		schedule.addEventToSchedule("Bio lecture", "Tuesday", new LocalTime[]{LocalTime.of(11, 30), LocalTime.of(13, 0)});
		schedule.addEventToSchedule("Bio lecture", "Thursday", new LocalTime[]{LocalTime.of(11, 30), LocalTime.of(13, 0)});
		Assert.assertEquals(schedule.getScheduleUnitsForDay("Tuesday").get(0).getEventTitle(), "Bio lecture");
		Assert.assertEquals(schedule.getScheduleUnitsForDay("Thursday").get(0).getEventTitle(), "Bio lecture");
	}
	
	@Test
	void testRemoveEventFromSchedule() {
		schedule.addEventToSchedule("Bio lecture", "Tuesday", new LocalTime[]{LocalTime.of(10, 0), LocalTime.of(11, 0)});
		schedule.addEventToSchedule("Chem lecture", "Tuesday", new LocalTime[]{LocalTime.of(11, 30), LocalTime.of(13, 0)});
		Assert.assertEquals(schedule.getScheduleUnitsForDay("Tuesday").get(0).getEventTitle(), "Bio lecture");
		Assert.assertEquals(schedule.getScheduleUnitsForDay("Tuesday").get(1).getEventTitle(), "Chem lecture");
		schedule.removeEventFromSchedule("Tuesday", 0);
		Assert.assertEquals(schedule.getScheduleUnitsForDay("Tuesday").get(0).getEventTitle(), "Chem lecture");
	}
	
	@Test
	void testUpdateEventTitle() {
		schedule.addEventToSchedule("Bio lecture", "Tuesday", new LocalTime[]{LocalTime.of(10, 0), LocalTime.of(11, 0)});
		Assert.assertEquals(schedule.getScheduleUnitsForDay("Tuesday").get(0).getEventTitle(), "Bio lecture");
		schedule.updateEventTitle("Tuesday", 0, "Chem lecture");
		Assert.assertEquals(schedule.getScheduleUnitsForDay("Tuesday").get(0).getEventTitle(), "Chem lecture");
	}
	
	@Test
	void testUpdateEventMeetingTime() {
		schedule.addEventToSchedule("Bio lecture", "Tuesday", new LocalTime[]{LocalTime.of(10, 0), LocalTime.of(11, 0)});
		Assert.assertEquals(schedule.getScheduleUnitsForDay("Tuesday").get(0).getStartTimeAsString(), "10:00");
		Assert.assertEquals(schedule.getScheduleUnitsForDay("Tuesday").get(0).getEndTimeAsString(), "11:00");
		schedule.updateEventMeetingTime("Tuesday", 0, new LocalTime[]{LocalTime.of(8, 0), LocalTime.of(9, 30)});
		Assert.assertEquals(schedule.getScheduleUnitsForDay("Tuesday").get(0).getStartTimeAsString(), "08:00");
		Assert.assertEquals(schedule.getScheduleUnitsForDay("Tuesday").get(0).getEndTimeAsString(), "09:30");
	}
	
	@Test
	void testGetScheduleSentencesForDay() {
		schedule.addEventToSchedule("Bio lecture", "Tuesday", new LocalTime[]{LocalTime.of(11, 30), LocalTime.of(13, 0)});
		schedule.addEventToSchedule("Bio lecture", "Thursday", new LocalTime[]{LocalTime.of(11, 30), LocalTime.of(13, 0)});
		Assert.assertEquals(schedule.getScheduleSentencesForDay("Tuesday").get(0), "Bio lecture from 11:30 to 13:00");
		Assert.assertEquals(schedule.getScheduleSentencesForDay("Thursday").get(0), "Bio lecture from 11:30 to 13:00");
	}
	
	@Test
	void testGetScheduleUnitByIndexAndDay() {
		schedule.addEventToSchedule("Bio lecture", "Tuesday", new LocalTime[]{LocalTime.of(11, 30), LocalTime.of(13, 0)});
		schedule.addEventToSchedule("Chem lecture", "Tuesday", new LocalTime[]{LocalTime.of(15, 0), LocalTime.of(16, 0)});
		Assert.assertEquals(schedule.getScheduleUnitByIndexAndDay("Tuesday", 0).getEventTitle(), "Bio lecture");
		Assert.assertEquals(schedule.getScheduleUnitByIndexAndDay("Tuesday", 1).getEventTitle(), "Chem lecture");
	}
	
	@Test 
	void testSortAllEventsInScheduleByTime() {
		schedule.addEventToSchedule("Bio lecture", "Tuesday", new LocalTime[]{LocalTime.of(11, 30), LocalTime.of(13, 0)});
		schedule.addEventToSchedule("Bio lecture", "Thursday", new LocalTime[]{LocalTime.of(11, 30), LocalTime.of(13, 0)});
		schedule.addEventToSchedule("Math study group", "Tuesday", new LocalTime[]{LocalTime.of(9, 00), LocalTime.of(10, 0)});
		Assert.assertEquals(schedule.getScheduleSentencesForDay("Tuesday").get(0), "Math study group from 09:00 to 10:00");
		Assert.assertEquals(schedule.getScheduleSentencesForDay("Tuesday").get(1), "Bio lecture from 11:30 to 13:00");
		Assert.assertEquals(schedule.getScheduleSentencesForDay("Thursday").get(0), "Bio lecture from 11:30 to 13:00");


	}

}
