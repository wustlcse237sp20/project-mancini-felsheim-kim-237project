package studentOrganizer;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class TaskTest {
	Task task = new Task("Study for biology test", false);

	@Test
	void testMarkUrgent() {
		task.markUrgent();
		Assert.assertEquals(task.isUrgent(), true);
	}
	
	@Test
	void testMarkNotUrgent() {
		task.markNotUrgent();
		Assert.assertEquals(task.isUrgent(), false);
	}
	
	@Test
	void testMarkCompleted() {
		task.markCompleted();
		Assert.assertEquals(task.isCompleted(), true);
	}
	
	@Test
	void testMarkNotCompleted() {
		task.markNotCompleted();
		Assert.assertEquals(task.isCompleted(), false);
	}
	
	@Test
	void testSetTaskDescription() {
		task.setTaskDescription("Study for physics quiz");
		Assert.assertEquals(task.getTaskDescription(), "Study for physics quiz");
	}

}
