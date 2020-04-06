package tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import studentOrganizer.GPACalculator;

/**
 * Note: Acts as a test for methods in both Category.java and GPACalculator.java
 *       because methods from GPACalculator call all methods from Category
 */
public class GPACalculatorTest {
	GPACalculator calculator = new GPACalculator();
	
    @Test
    void testAddCategory() {
    	calculator.addCategory("HW", 0.3);
    
        Assert.assertEquals(calculator.getCategories().get(0).getName(), "HW");
        Assert.assertTrue(calculator.getCategories().get(0).getWeight() == 0.3);
    }
    
    @Test
    void testAddAssignmentGrade() {
    	calculator.addCategory("HW", 0.4);

    	calculator.addAssignmentGrade("HW", "HW1", 8, 10);

    	Assert.assertEquals(calculator.getCategories().get(0).getAssignmentGrades().get("HW1")[0], 8);
    	Assert.assertEquals(calculator.getCategories().get(0).getAssignmentGrades().get("HW1")[1], 10);
    }
    
    @Test
    void testDeleteAssignmentGrade() {
    	calculator.addCategory("HW", 0.4);
    	calculator.addAssignmentGrade("HW", "HW1", 8, 10);

    	calculator.deleteAssignmentGrade("HW", "HW1");

    	Assert.assertTrue(calculator.getCategories().get(0).getAssignmentGrades().isEmpty());
    }
    
    @Test
    void testCalculateCourseGrade() {
    	calculator.addCategory("HW", 0.5);
    	calculator.addCategory("Exams", 0.5);
    	calculator.addAssignmentGrade("HW", "HW1", 8, 10);
    	calculator.addAssignmentGrade("Exams", "Exam1", 50, 100);

    	System.out.println(calculator.calculateCourseGrade());
    	Assert.assertTrue(calculator.calculateCourseGrade() == (0.5*8/10+0.5*50/100));
    }
}