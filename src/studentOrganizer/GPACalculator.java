package studentOrganizer;

import java.util.ArrayList;
import java.util.List;

public class GPACalculator {
	// stuff to store: weights, assignment names, assignment grades
	List<Category> categories;
	double GPA; // GPA for the semester, for all courses
	double courseGrade;
	
	public GPACalculator() {
		categories = new ArrayList<Category>();
	}
	
	public List<Category> getCategories() {
		return categories;
	}
	
	public void addCategory(String name, double weight) {
		categories.add(new Category(name, weight));
	}
	
	public void addAssignmentGrade(String categoryName, String assignmentName, int points, int outOf) {
		for(Category c: categories) {
			if(c.name.equals(categoryName)) {
				c.addAssignmentGrade(assignmentName, points, outOf);
			}
		}
	}
	
	public void deleteAssignmentGrade(String categoryName, String assignmentName) {
		for(Category c: categories) {
			if(c.name.equals(categoryName)) {
				c.deleteAssignmentGrade(assignmentName);
			}
		}
	}
	
	public double calculateCourseGrade() {
		double n = 0;
		for(Category c: categories) {
			n += c.weight * c.calculateGrade();
		}
		this.courseGrade = n;
		return n;
	}
	
	
	// calculate cumulative grade of the semester; will need courses for this
	// cumulative grade for the semester will show up at the bottom at all times, will
	// automatically update if any changes to the grades are made
	
	
	
}