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
		LocalTime[] times = {LocalTime.of(11, 30), LocalTime.of(1, 0)};
		
		course.setCourseSchedule(weekdays, startTime, endTime);
		
		Assert.assertEquals(course.getCourseMeetingDays(), weekdays);
		Assert.assertEquals(course.getCourseMeetingTime()[0], times[0]);
		Assert.assertEquals(course.getCourseSchedule().get(0).getEventTitle(), "Physics");
		Assert.assertEquals(course.getCourseSchedule().get(1).getEventTitle(), "Physics");
		Assert.assertEquals(course.getCourseSchedule().get(0).getStartTime(), LocalTime.of(11, 30));
		Assert.assertEquals(course.getCourseSchedule().get(1).getStartTime(), LocalTime.of(11, 30));
		Assert.assertEquals(course.getCourseSchedule().get(0).getEndTime(), LocalTime.of(1, 0));
		Assert.assertEquals(course.getCourseSchedule().get(1).getEndTime(), LocalTime.of(1, 0));
		Assert.assertEquals(course.getCourseSchedule().get(0).getWeekday(), "Tuesday");
		Assert.assertEquals(course.getCourseSchedule().get(1).getWeekday(), "Thursday");
	}
	

}
