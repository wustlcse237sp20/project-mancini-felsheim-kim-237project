package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import javax.swing.tree.DefaultMutableTreeNode;

import org.junit.jupiter.api.Test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import studentOrganizer.Category;
import studentOrganizer.ClassController;
import studentOrganizer.GPACalculator;
import studentOrganizer.OrganizerGradePage;
import studentOrganizer.ScheduleController;
// tests GPACalculator methods from ClassController
class GPAControllerTest {
	ClassController classController = new ClassController();

	@Test
	void testAddCategory() {
		classController.addCourse("Math");
		classController.addCategory((DefaultMutableTreeNode)classController.getRoot().getChildAt(0), "Tests", 0.4);
		classController.addAssignment((DefaultMutableTreeNode)classController.getRoot().getChildAt(0).getChildAt(0), "Midterm", 5, 10);
		
		DefaultMutableTreeNode classNode = (DefaultMutableTreeNode) classController.getRoot().getChildAt(0);
		Category categoryAdded = (Category)((DefaultMutableTreeNode) classNode.getChildAt(0)).getUserObject();
		Assert.assertEquals(categoryAdded.getName(), "Tests");
		Assert.assertTrue(categoryAdded.getWeight() == 0.4);
	}

	@Test
	void testAddAssignment() {
		classController.addCourse("Math");
		classController.addCategory((DefaultMutableTreeNode)classController.getRoot().getChildAt(0), "Tests", 0.4);
		classController.addAssignment((DefaultMutableTreeNode)classController.getRoot().getChildAt(0).getChildAt(0), "Midterm", 5, 10);
		
		DefaultMutableTreeNode categoryNode = (DefaultMutableTreeNode) classController.getRoot().getChildAt(0).getChildAt(0);
		Map<String, int[]> assignmentGrades = ((Category)categoryNode.getUserObject()).getAssignmentGrades();
		Assert.assertTrue(assignmentGrades.containsKey("Midterm"));
		Assert.assertTrue(assignmentGrades.get("Midterm")[0] == 5);
		Assert.assertTrue(assignmentGrades.get("Midterm")[1] == 10);
	}
	
	@Test
	void testDeleteAssignment() {
		classController.addCourse("Math");
		classController.addCategory((DefaultMutableTreeNode)classController.getRoot().getChildAt(0), "Tests", 0.4);
		classController.addAssignment((DefaultMutableTreeNode)classController.getRoot().getChildAt(0).getChildAt(0), "Midterm", 5, 10);
		
		classController.deleteAssignment((DefaultMutableTreeNode)classController.getRoot().getChildAt(0).getChildAt(0).getChildAt(0));
		Assert.assertTrue(classController.getRoot().getChildAt(0).getChildAt(0).getChildCount() == 0);
	}
	
	@Test
	void testGPACalculatorCalculateCourseGrade() {
		classController.addCourse("Math");
		classController.addCategory((DefaultMutableTreeNode)classController.getRoot().getChildAt(0), "Tests", 0.4);
		classController.addAssignment((DefaultMutableTreeNode)classController.getRoot().getChildAt(0).getChildAt(0), "Midterm", 5, 10);
		
		// check
		double courseGrade = ((GPACalculator)((DefaultMutableTreeNode)classController.getRoot().getChildAt(0)).getUserObject()).calculateCourseGrade();
		Assert.assertTrue(courseGrade == 0.4*0.5);
	}

}


