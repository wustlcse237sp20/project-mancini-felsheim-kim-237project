package studentOrganizer;

import java.util.ArrayList;
import java.util.List;

/**
 * A tool to calculate a student's grades and GPA.
 * Test cases for GPACalculator (and Category) can be found in GPACalculatorTest.
 *
 */
public class GPACalculator {
	List<Category> categories;
	double semesterGPA; 
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
		for(Category category: categories) {
			if(category.getName().equals(categoryName)) {
				category.addAssignmentGrade(assignmentName, points, outOf);
			}
		}
	}
	
	public void deleteAssignmentGrade(String categoryName, String assignmentName) {
		for(Category category: categories) {
			if(category.getName().equals(categoryName)) {
				category.deleteAssignmentGrade(assignmentName);
			}
		}
	}
	
	public double calculateCourseGrade() {
		double grade = 0;
		for(Category category: categories) {
			grade += category.getWeight() * category.calculateGrade();
		}
		this.courseGrade = grade;
		return grade;
	}
	
	@Override
	public String toString() {
		return "Classes";
	}
	
	// TODO for next iteration:
	// calculate cumulative grade of the semester; will need courses for this
	// cumulative grade for the semester will show up at the bottom at all times, will
	// automatically update if any changes to the grades are made
	
	
}