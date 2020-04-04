package studentOrganizer;
import java.util.HashMap;
import java.util.Map;

// examples of categories: Exams, HW, Project, Studio
public class Category {
	String name;
	double weight;
	double grade;
	Map<String, int[]> assignmentGrades; // int[] are [a, b] pairs, where the student got a out of b points
	
	public Category(String name, double weight) {
		this.name = name;
		this.weight = weight;
		this.assignmentGrades = new HashMap<String, int[]>();
	}
	
	public void addAssignmentGrade(String name, int points, int outOf) {
		int[] assignmentGrade = {points, outOf};
		this.assignmentGrades.put(name, assignmentGrade);
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

}
