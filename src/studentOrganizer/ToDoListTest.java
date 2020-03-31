package studentOrganizer;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class ToDoListTest {
	
	ToDoList toDoList = new ToDoList();

	@Test
	void testRemoveAllCompletedTasks() {

		toDoList.addTask(new Task("Study for biology test", false));
		toDoList.addTask(new Task("Write reading report", true));
		toDoList.addTask(new Task("Read ch3 of math textbook", false));
		toDoList.addTask(new Task("Practice piano", false));
		toDoList.addTask(new Task("Email professor", true));
		toDoList.addTask(new Task("Meet for group project", true));
				
		toDoList.markTaskCompleted(1);
		toDoList.markTaskCompleted(2);
		
		toDoList.removeAllCompletedTasks();
		
		Assert.assertEquals(toDoList.getTask(1).getTaskDescription(), "Practice piano");
		Assert.assertEquals(toDoList.size(), 4);
		
	}
	
	@Test
	void testMarkAllTasksAsCompleted() {
		
		toDoList.addTask(new Task("Study for biology test", false));
		toDoList.addTask(new Task("Write reading report", true));
		toDoList.addTask(new Task("Read ch3 of math textbook", false));
		toDoList.addTask(new Task("Practice piano", false));
		toDoList.addTask(new Task("Email professor", true));
		toDoList.addTask(new Task("Meet for group project", true));
		
		toDoList.markTaskCompleted(1);
		toDoList.markTaskCompleted(2);
		
		toDoList.markAllTasksAsCompleted();
		
		Assert.assertEquals(toDoList.getTask(0).isCompleted(), true);
		Assert.assertEquals(toDoList.getTask(1).isCompleted(), true);
		Assert.assertEquals(toDoList.getTask(2).isCompleted(), true);
		Assert.assertEquals(toDoList.getTask(3).isCompleted(), true);
		Assert.assertEquals(toDoList.getTask(4).isCompleted(), true);
		Assert.assertEquals(toDoList.getTask(5).isCompleted(), true);
	}
	
	@Test
	void testSortAllTasks() {
		
		toDoList.addTask(new Task("Study for biology test", false));
		toDoList.addTask(new Task("Write reading report", false));
		toDoList.addTask(new Task("Read ch3 of math textbook", true));
		toDoList.addTask(new Task("Practice piano", false));
		toDoList.addTask(new Task("Email professor", true));
		toDoList.addTask(new Task("Meet for group project", true));
		
		toDoList.markTaskCompleted(1);
		toDoList.markTaskCompleted(2);
		
		toDoList.sortAllTasks();
		
		Assert.assertEquals(toDoList.getTask(0).getTaskDescription(), "Email professor");
		Assert.assertEquals(toDoList.getTask(1).getTaskDescription(), "Meet for group project");
		Assert.assertEquals(toDoList.getTask(2).getTaskDescription(), "Study for biology test");
		Assert.assertEquals(toDoList.getTask(3).getTaskDescription(), "Practice piano");
		Assert.assertEquals(toDoList.getTask(4).getTaskDescription(), "Read ch3 of math textbook");
		Assert.assertEquals(toDoList.getTask(5).getTaskDescription(), "Write reading report");
	}

}
