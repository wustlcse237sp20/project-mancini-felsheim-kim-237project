package tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import studentOrganizer.ClassController;

class TaskControllerTest {

	ClassController toDoList= new ClassController();
			
	@Test
	void testAddTask() {
		toDoList.addTask("Math homework");
		toDoList.addTask("English Homework");
		toDoList.addTask("Science Homework");
		
		Assert.assertEquals(toDoList.getTask(0).getTaskDescription(), "Math homework");
		Assert.assertEquals(toDoList.getTaskSize(), 3);
		
	}
	
	@Test
	void testAddUrgentTask() {
		toDoList.addUrgent("Math Homework");
		toDoList.addTask("English Homework");
		toDoList.addTask("Science Homework");
		
		Assert.assertEquals(toDoList.getTask(0).isUrgent(), true);
		Assert.assertEquals(toDoList.getTask(1).isUrgent(), false);
		Assert.assertEquals(toDoList.getTaskSize(), 3);
		
	}
	
	@Test
	void testMarkTaskCompleted() {
		toDoList.addTask("Math homework");
		toDoList.addTask("English Homework");
		toDoList.addTask("Science Homework");
		
		toDoList.markTaskCompleted(0);
		
		Assert.assertEquals(toDoList.getTask(0).isCompleted(), true);
		Assert.assertEquals(toDoList.getTask(1).isCompleted(), false);
		Assert.assertEquals(toDoList.getTaskSize(), 3);
		
	}
	
	@Test
	void testMarkUrgentTask() {
		toDoList.addTask("Math Homework");
		toDoList.addTask("English Homework");
		toDoList.addTask("Science Homework");
		
		toDoList.markTaskUrgent(0);
		
		Assert.assertEquals(toDoList.getTask(0).isUrgent(), true);
		Assert.assertEquals(toDoList.getTask(1).isUrgent(), false);
		Assert.assertEquals(toDoList.getTaskSize(), 3);
		
	}
	
	@Test
	void testRemoveTask() {
		toDoList.addTask("Math homework");
		toDoList.addTask("English Homework");
		toDoList.addTask("Science Homework");
		
		toDoList.removeTask(0);
		
		Assert.assertEquals(toDoList.getTask(0).getTaskDescription(), "English Homework");
		Assert.assertEquals(toDoList.getTaskSize(), 2);
		
	}

}
