package studentOrganizer;

import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class ScheduleTest {
	Schedule schedule = new Schedule();

	@Test
	void testAddEventsToSchedule() {
		ScheduleUnit event1 = new ScheduleUnit("Bio lecture", "Tuesday", 
				new LocalTime[]{LocalTime.of(11, 30), LocalTime.of(13, 0)});
		ScheduleUnit event2 = new ScheduleUnit("Bio lecture", "Thursday", 
				new LocalTime[]{LocalTime.of(11, 30), LocalTime.of(13, 0)});
		ArrayList<ScheduleUnit> events = new ArrayList<ScheduleUnit>();
		events.add(event1);
		events.add(event2);
		schedule.addEventsToSchedule(events);
		Assert.assertEquals(schedule.getScheduleUnitsForDay("Tuesday").get(0).getEventTitle(), "Bio lecture");
		Assert.assertEquals(schedule.getScheduleUnitsForDay("Thursday").get(0).getEventTitle(), "Bio lecture");

	}
	
	@Test
	void testGetScheduleSentencesForDay() {
		ScheduleUnit event1 = new ScheduleUnit("Bio lecture", "Tuesday", 
				new LocalTime[]{LocalTime.of(11, 30), LocalTime.of(13, 0)});
		ScheduleUnit event2 = new ScheduleUnit("Bio lecture", "Thursday", 
				new LocalTime[]{LocalTime.of(11, 30), LocalTime.of(13, 0)});
		ArrayList<ScheduleUnit> events = new ArrayList<ScheduleUnit>();
		events.add(event1);
		events.add(event2);
		schedule.addEventsToSchedule(events);
		Assert.assertEquals(schedule.getScheduleSentencesForDay("Tuesday").get(0), "Bio lecture from 11:30 to 13:00");
	}
	
	@Test 
	void testSortAllEventsInScheduleByTime() {
		ScheduleUnit event1 = new ScheduleUnit("Bio lecture", "Tuesday", 
				new LocalTime[]{LocalTime.of(11, 30), LocalTime.of(13, 0)});
		ScheduleUnit event2 = new ScheduleUnit("Chem lecture", "Tuesday", 
				new LocalTime[]{LocalTime.of(10, 00), LocalTime.of(12, 0)});
		ArrayList<ScheduleUnit> events = new ArrayList<ScheduleUnit>();
		events.add(event1);
		events.add(event2);
		schedule.addEventsToSchedule(events);
		schedule.sortAllEventsInScheduleByTime();
		Assert.assertEquals(schedule.getScheduleUnitsForDay("Tuesday").get(0).getEventTitle(), "Chem lecture");
		Assert.assertEquals(schedule.getScheduleUnitsForDay("Tuesday").get(1).getEventTitle(), "Bio lecture");


	}

}
