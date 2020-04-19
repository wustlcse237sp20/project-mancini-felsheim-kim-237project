package studentOrganizer;
import java.util.HashMap;
import java.util.Map;

/**
 * Manages categories of grades to be entered for a class.
 * Examples of categories: Exams, HW, Project, Studio, etc.
 * Note: all non-trivial methods are tested in GPACalculatorTest.
 *
 */
public class Category {
	private String name;
	private double weight;
	private double grade; // need to keep updating grade whenever a new assignment is added
	private Map<String, int[]> assignmentGrades; // int[] are [a, b] pairs, where the student got a out of b points
	
	public Category(String name, double weight) {
		this.name = name;
		this.weight = weight;
		this.assignmentGrades = new HashMap<String, int[]>();
	}
	
	public String getName() {
		return name;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public Map<String, int[]> getAssignmentGrades() {
		return assignmentGrades;
	}
	
	public void addAssignmentGrade(String name, int points, int outOf) {
		int[] assignmentGrade = {points, outOf};
		this.assignmentGrades.put(name, assignmentGrade);
		this.grade = calculateGrade();
	}
	
	public void deleteAssignmentGrade(String name) {
		this.assignmentGrades.remove(name);
		this.grade = calculateGrade();
	}
	
	public double calculateGrade() {
		double points = 0;
		double outOf = 0;
		for(String name: this.assignmentGrades.keySet()) {
			points += this.assignmentGrades.get(name)[0];
			outOf += this.assignmentGrades.get(name)[1];
		}
		return points/outOf;
	}
	
	@Override
	public String toString() {
		return name;
	}

}