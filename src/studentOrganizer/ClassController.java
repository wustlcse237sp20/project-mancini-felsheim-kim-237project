package studentOrganizer;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 * ClassController is a mediator between the main course model and the user interface
 */
public class ClassController {
	
	private DefaultListModel<String> classes;
	private DefaultListModel<Task> tasks;
	//private GPACalculator gpaCalculator;
	//?? keep a tree model here?
	private DefaultTreeModel GPAModel;
	private DefaultMutableTreeNode root;
	
	public ClassController() {
		classes = new DefaultListModel<>();
		tasks = new DefaultListModel<>();
		//gpaCalculator = new GPACalculator();
		DefaultTreeModel GPAModel = new DefaultTreeModel(new DefaultMutableTreeNode(new GPACalculator()));
		root = (DefaultMutableTreeNode) GPAModel.getRoot();
	}
	public void addCourse(String name) {
		Course course = new Course(name);
		classes.addElement(course.getCourseName());
		
		root.add(new DefaultMutableTreeNode(course.getCourseName()));
	}
	
	public void removeCourse(int index) {
		classes.remove(index);
    root.remove(index);
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
	
	// GPACalculator methods
	public DefaultTreeModel getGPAModel() {
		return GPAModel;
	}
	
	public DefaultMutableTreeNode getRoot() {
		return root;
	}
	
	public void addCategory(DefaultMutableTreeNode classNode, String categoryName, double categoryWeight) {
		((GPACalculator)root.getUserObject()).addCategory(categoryName, categoryWeight);
		classNode.add(new DefaultMutableTreeNode(new Category(categoryName, categoryWeight)));
	}
	
	public void addAssignment(DefaultMutableTreeNode categoryNode, String assignmentName, int points, int outOf) {
		((Category)categoryNode.getUserObject()).addAssignmentGrade(assignmentName, points, outOf);
		categoryNode.add(new DefaultMutableTreeNode(assignmentName+"   "+(((int)(((double)points/outOf)*10000)))/10000.0));
	}
}
	