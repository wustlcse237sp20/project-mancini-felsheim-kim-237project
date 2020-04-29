package studentOrganizer;

import javax.swing.DefaultListModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

// TODO: Rename to CourseController (for less confusion) next iteration.

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
		gpaModel = new DefaultTreeModel(new DefaultMutableTreeNode("Classes"));
		gpaModelRoot = (DefaultMutableTreeNode) gpaModel.getRoot();
	}
	
	public void addCourse(String name) {
		Course course = new Course(name);
		classes.addElement(course.getCourseName());
		
		// add course as a GPAcalculator for use in calculation of GPA
		gpaModelRoot.add(new DefaultMutableTreeNode(new GPACalculator(course.getCourseName())));
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
	
	// GPACalculator methods
	public DefaultMutableTreeNode getRoot() {
		return gpaModelRoot;
	}
	
	public void addCategory(DefaultMutableTreeNode classNode, String categoryName, double categoryWeight) {
		((GPACalculator)classNode.getUserObject()).addCategory(categoryName, categoryWeight);
		classNode.add(new DefaultMutableTreeNode(new Category(categoryName, categoryWeight)));
	}
	
	public void addAssignment(DefaultMutableTreeNode categoryNode, String assignmentName, int points, int outOf) {
		((GPACalculator)((DefaultMutableTreeNode) categoryNode.getParent()).getUserObject()).addAssignmentGrade(categoryNode.toString().split(" ")[0], assignmentName, points, outOf);
		((Category)categoryNode.getUserObject()).addAssignmentGrade(assignmentName, points, outOf);
		categoryNode.add(new DefaultMutableTreeNode(assignmentName+"   "+(((int)(((double)points/outOf)*10000)))/100.0+"%"));
	}
	
	public void deleteAssignment(DefaultMutableTreeNode assignmentNode) {
		// remove assignmentNode from the tree
		DefaultMutableTreeNode categoryNode = ((DefaultMutableTreeNode) assignmentNode.getParent());
		categoryNode.remove(assignmentNode);
		
		// remove assignment from the category
		Category category = (Category)categoryNode.getUserObject();
		String assignmentName = assignmentNode.toString().split(" ")[0];
		category.deleteAssignmentGrade(assignmentName);
	}
	
	public double calculateGPA() {
		// iterate through root's children
		double gpa = 0;
		if(gpaModelRoot.getChildCount() == 0) {
			return 0;
		}
		for(int i = 0; i < gpaModelRoot.getChildCount(); i++) {
			GPACalculator courseCalculator = (GPACalculator)((DefaultMutableTreeNode)gpaModelRoot.getChildAt(i)).getUserObject();
			gpa += courseCalculator.calculateCourseGPA();
		}
		return (int)(gpa/gpaModelRoot.getChildCount()*100)/100.0;	// round to 2 decimal places
	}
	

}
