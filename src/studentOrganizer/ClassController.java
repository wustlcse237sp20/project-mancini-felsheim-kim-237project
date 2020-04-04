package studentOrganizer;

import java.util.*;

import javax.swing.DefaultListModel;

public class ClassController {
	
	private DefaultListModel<String> classes;
	private DefaultListModel<String> tasks;
	
	public ClassController() {
		classes = new DefaultListModel<>();
		tasks = new DefaultListModel<>();
	}
	public void addCourse(String name) {
		Course course = new Course(name);
		classes.addElement(course.getCourseName()); 
	}
	
	public void addTask(String name) {
		tasks.addElement(name);  
	}
	
	public void removeTask(int index) {
		tasks.remove(index);
	}
	
	public void removeCourse(int index) {
		classes.remove(index);
	}
	public DefaultListModel<String> getAllCourses(){
		return classes;
	}
	
	public DefaultListModel<String> getAllTasks(){
		return tasks;
	}

}
