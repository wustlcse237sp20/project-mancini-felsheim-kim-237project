package studentOrganizer;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

// TODO: Rename to CourseConroller (for less confusion) next iteration.

/**
 * ClassController is a mediator between the main course model and the user interface
 */
public class ClassController {
	
	private DefaultListModel<String> classes;
	private DefaultListModel<Task> tasks;
	private DefaultTreeModel gpaModel;
	private DefaultMutableTreeNode gpaModelRoot;
	
	public ClassController() {
		classes = new DefaultListModel<>();
		tasks = new DefaultListModel<>();
		DefaultTreeModel GPAModel = new DefaultTreeModel(new DefaultMutableTreeNode(new GPACalculator()));
		gpaModelRoot = (DefaultMutableTreeNode) GPAModel.getRoot();
	}
	
	public void addCourse(String name) {
		Course course = new Course(name);
		classes.addElement(course.getCourseName());
		
		gpaModelRoot.add(new DefaultMutableTreeNode(course.getCourseName()));
	}
	
	public void removeCourse(int index) {
		classes.remove(index);
		gpaModelRoot.remove(index);
	}
	
	public DefaultListModel<String> getAllCourses(){
		return classes;
	}
	
	// ToDo list methods
	
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
	
	public DefaultListModel<Task> getAllTasks(){
		return tasks;
	}
	
	public Task getTask(int index) {
		return tasks.get(index);
	}
	
	public int getTaskSize() {
		return tasks.getSize();
	}
	
	public DefaultListModel<Task> removeAllCompletedTasks(){
		ToDoList toDoList = new ToDoList();
		for (int i=0; i<tasks.size(); i++) {
			toDoList.addTask(tasks.get(i));
		}
		toDoList.removeAllCompletedTasks();
		
		tasks.removeAllElements();
		
		for (int i=0; i<toDoList.size(); i++)
		{
			tasks.add(i, toDoList.getTask(i));
		}
		return tasks;
	}
	
	public DefaultListModel<Task> sortAllTasks(){
		ToDoList toDoList = new ToDoList();
		for (int i=0; i<tasks.size(); i++) {
			toDoList.addTask(tasks.get(i));
		}
		toDoList.sortAllTasks();
		
		for (int i=0; i<tasks.size(); i++)
		{
			tasks.set(i, toDoList.getTask(i));
		}
		return tasks;
	}
	
	public DefaultListModel<Task> markAllComplete(){
		ToDoList toDoList = new ToDoList();
		for (int i=0; i<tasks.size(); i++) {
			toDoList.addTask(tasks.get(i));
		}
		toDoList.markAllTasksAsCompleted();
		
		for (int i=0; i<tasks.size(); i++)
		{
			tasks.set(i, toDoList.getTask(i));
		}
		return tasks;
	}
	
	// GPACalculator methods
	
	public DefaultTreeModel getGPAModel() {
		return gpaModel;
	}
	
	public DefaultMutableTreeNode getRoot() {
		return gpaModelRoot;
	}
	
	public void addCategory(DefaultMutableTreeNode classNode, String categoryName, double categoryWeight) {
		((GPACalculator)gpaModelRoot.getUserObject()).addCategory(categoryName, categoryWeight);
		classNode.add(new DefaultMutableTreeNode(new Category(categoryName, categoryWeight)));
	}
	
	public void addAssignment(DefaultMutableTreeNode categoryNode, String assignmentName, int points, int outOf) {
		((Category)categoryNode.getUserObject()).addAssignmentGrade(assignmentName, points, outOf);
		categoryNode.add(new DefaultMutableTreeNode(assignmentName+"   "+(((int)(((double)points/outOf)*10000)))/10000.0));
	}

}
