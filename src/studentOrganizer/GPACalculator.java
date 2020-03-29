package studentOrganizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GPACalculator {
	// stuff to store: weights, assignment names, assignment grades
	List<Category> categories;
	double GPA; // GPA for the semester, for all courses
	double courseGrade;
	
	public GPACalculator() {
		categories = new ArrayList<Category>();
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
	
	//?? this method returns the courseGPA and also sets courseGPA, sketchy
	public double calculateCourseGrade() {
		double n = 0;
		for(Category c: categories) {
			n += c.weight * c.calculateGrade();
		}
		this.courseGrade = n;
		return n;
	}
	
	
		
	
	// calculate cumulative grade of the semester; will need courses for this
	
	
	
}
