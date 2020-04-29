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
	double courseGrade;
	String courseName; // there is one CourseGradeCalculator per course
	
	public GPACalculator(String courseName) {
		categories = new ArrayList<Category>();
		this.courseName = courseName;
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
	
	/**
	 * calculate the GPA based on standard cutoffs
	 * @return the GPA, maximum 4.0
	 */
	public double calculateCourseGPA() {
		double grade = calculateCourseGrade();
		// standard grade cutoffs
		if(grade < 0.6) {
			grade = 0; // F
		} else if(grade < 0.64) {
			grade = 0.67; // D-
		} else if(grade < 0.67) {
			grade = 1; // D
		} else if(grade < 0.7) {
			grade = 1.33; // D+
		} else if(grade < 0.74) {
			grade = 1.67; // C-
		} else if(grade < 0.77) {
			grade = 2; // C
		} else if(grade < 0.80) {
			grade = 2.33; // C+
		} else if(grade < 0.84) {
			grade = 2.67; // B-
		} else if(grade < 0.87) {
			grade = 3; // B
		} else if(grade < 0.9) {
			grade = 3.33; // B+
		} else if(grade < 0.94) {
			grade = 3.67; // A-
		} else if(grade < 0.97) {
			grade = 4; // A
		} else if(grade <= 1) {
			grade = 4; // A+
		}
		return grade;
	}
	
	@Override
	public String toString() {
		return this.courseName + "   " + (int)(calculateCourseGrade()*10000)/100.0 + "%";
	}
	
}