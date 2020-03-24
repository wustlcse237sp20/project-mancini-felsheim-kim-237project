package studentOrganizer;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.ArrayList;


class CourseTest {
	Course course = new Course("Physics");

	@Test
	void testSetCourseMeetingTime() {
		ArrayList<String> weekdays = new ArrayList<String>();
		weekdays.add("Tuesday");
		weekdays.add("Thursday");
		int[] startTime = {11, 30};
		int[] endTime = {1, 0};
		course.setCourseMeetingTime(weekdays, startTime, endTime);
		LocalTime[] times = {LocalTime.of(11, 30), LocalTime.of(1, 0)};
		Assert.assertEquals(course.courseSchedule.get("Tuesday")[0], times[0]);
		Assert.assertEquals(course.courseSchedule.get("Tuesday")[1], times[1]);
		Assert.assertEquals(course.courseSchedule.get("Thursday")[0], times[0]);
		Assert.assertEquals(course.courseSchedule.get("Thursday")[1], times[1]);
	}
	

}
