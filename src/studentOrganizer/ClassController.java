package studentOrganizer;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

/**
 * ClassController is a mediator between the main course model and the user interface
 */
public class ClassController {
	
	private DefaultListModel<String> classes;
	private DefaultListModel<Task> tasks;
	
	public ClassController() {
		classes = new DefaultListModel<>();
		tasks = new DefaultListModel<>();
	}
	public void addCourse(String name) {
		Course course = new Course(name);
		classes.addElement(course.getCourseName()); 
	}
	
	public void removeCourse(int index) {
		classes.remove(index);
	}
	
	public DefaultListModel<String> getAllCourses(){
		return classes;
	}
	
	public void addTask(String name) {
		Task task = new Task(name, false);
		tasks.addElement(task);  
	}
	public void addUrgent(String name) {
		Task task = new Task(name, true);
		tasks.addElement(task);  
	}
	
	public void markTaskCompleted(int index) {
		tasks.get(index).markCompleted();  
	}
	
	public void markTaskUrgent(int index) {
		tasks.get(index).markUrgent();  
	}
	
	
	public void removeTask(int index) {
		tasks.remove(index);
	}
	
	public Task getTask(int index) {
		return tasks.get(index);
	}
	
	public DefaultListModel<Task> getAllTasks(){
		return tasks;
	}
	
}
	