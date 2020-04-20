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
import studentOrganizer.OrganizerGradePage;
import studentOrganizer.ScheduleController;

class GPAControllerTest {
	ClassController classController = new ClassController();
//	ScheduleController scheduleController = new ScheduleController();
//	OrganizerGradePage gradePage = new OrganizerGradePage(classController, scheduleController);

	@Test
	void testAddCategory() {
		DefaultMutableTreeNode classNode = new DefaultMutableTreeNode("Math");
		
		classController.addCategory(classNode, "HW", 0.4);
		
		Category categoryAdded = (Category)((DefaultMutableTreeNode) classNode.getChildAt(0)).getUserObject();
		Assert.assertEquals(categoryAdded.getName(), "HW");
		Assert.assertTrue(categoryAdded.getWeight() == 0.4);
	}

	@Test
	void testAddAssignment() {
		Category category = new Category("Tests", 0.4);
		DefaultMutableTreeNode categoryNode = new DefaultMutableTreeNode(category);
		
		classController.addAssignment(categoryNode, "Midterm", 5, 10);
		
		Map<String, int[]> assignmentGrades = ((Category)categoryNode.getUserObject()).getAssignmentGrades();
		int[] grade = {5, 10};
		Assert.assertTrue(assignmentGrades.containsKey("Midterm"));
		Assert.assertTrue(assignmentGrades.get("Midterm")[0] == 5);
		Assert.assertTrue(assignmentGrades.get("Midterm")[1] == 10);
	}
}


