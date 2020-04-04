package studentOrganizer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AllInOne {

	private JFrame frame;
	private ClassController controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllInOne window = new AllInOne();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AllInOne() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JLabel lblClasses = new JLabel("Classes");
		springLayout.putConstraint(SpringLayout.NORTH, lblClasses, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblClasses, 10, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(lblClasses);
		
		controller = new ClassController();
		JList list = new JList(controller.getAllCourses());
		springLayout.putConstraint(SpringLayout.NORTH, list, 8, SpringLayout.SOUTH, lblClasses);
		springLayout.putConstraint(SpringLayout.WEST, list, 0, SpringLayout.WEST, lblClasses);
		springLayout.putConstraint(SpringLayout.SOUTH, list, 145, SpringLayout.SOUTH, lblClasses);
		springLayout.putConstraint(SpringLayout.EAST, list, 164, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(list);
		
		JButton btnAddClass = new JButton("Add Class");
		btnAddClass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String s = (String)JOptionPane.showInputDialog(frame, "What is your course's name?", "Customized dialog", JOptionPane.PLAIN_MESSAGE, null,null, null);
				if ((s!=null) && (s.length()>0)) {
					controller.addCourse(s);
					return;
				}
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnAddClass, 6, SpringLayout.SOUTH, list);
		springLayout.putConstraint(SpringLayout.WEST, btnAddClass, 10, SpringLayout.WEST, list);
		frame.getContentPane().add(btnAddClass);
		
		JButton btnRemoveClass = new JButton("Remove Class");
		btnRemoveClass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.removeCourse(list.getSelectedIndex());
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnRemoveClass, 10, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(btnRemoveClass);
		
		JLabel lblTodo = new JLabel("ToDo:");
		springLayout.putConstraint(SpringLayout.NORTH, lblTodo, 0, SpringLayout.NORTH, lblClasses);
		frame.getContentPane().add(lblTodo);
		
		JList list_1 = new JList(controller.getAllTasks());
		springLayout.putConstraint(SpringLayout.WEST, lblTodo, 0, SpringLayout.WEST, list_1);
		springLayout.putConstraint(SpringLayout.NORTH, list_1, 0, SpringLayout.NORTH, list);
		springLayout.putConstraint(SpringLayout.WEST, list_1, 43, SpringLayout.EAST, list);
		springLayout.putConstraint(SpringLayout.SOUTH, list_1, 0, SpringLayout.SOUTH, list);
		springLayout.putConstraint(SpringLayout.EAST, list_1, -89, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(list_1);
		
		JButton btnAddTask = new JButton("Add Task");
		btnAddTask.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String s = (String)JOptionPane.showInputDialog(frame, "What is your task?", "Customized dialog", JOptionPane.PLAIN_MESSAGE, null,null, null);
				if ((s!=null) && (s.length()>0)) {
					controller.addTask(s);
					return;
				}
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnAddTask, 6, SpringLayout.SOUTH, list_1);
		springLayout.putConstraint(SpringLayout.WEST, btnAddTask, 0, SpringLayout.WEST, lblTodo);
		frame.getContentPane().add(btnAddTask);
		
		JButton btnRemoveTask = new JButton("Remove Task");
		springLayout.putConstraint(SpringLayout.NORTH, btnRemoveClass, 0, SpringLayout.NORTH, btnRemoveTask);
		springLayout.putConstraint(SpringLayout.NORTH, btnRemoveTask, 6, SpringLayout.SOUTH, btnAddTask);
		springLayout.putConstraint(SpringLayout.WEST, btnRemoveTask, 0, SpringLayout.WEST, lblTodo);
		frame.getContentPane().add(btnRemoveTask);
		btnRemoveTask.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.removeTask(list_1.getSelectedIndex());
			}
		});
		
		JCheckBox chckbxUrgent = new JCheckBox("Urgent?");
		springLayout.putConstraint(SpringLayout.NORTH, chckbxUrgent, 6, SpringLayout.SOUTH, btnRemoveTask);
		springLayout.putConstraint(SpringLayout.EAST, chckbxUrgent, -167, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(chckbxUrgent);
		
		JCheckBox chckbxCompleted = new JCheckBox("Completed?");
		springLayout.putConstraint(SpringLayout.NORTH, chckbxCompleted, 7, SpringLayout.SOUTH, btnRemoveTask);
		springLayout.putConstraint(SpringLayout.WEST, chckbxCompleted, 6, SpringLayout.EAST, chckbxUrgent);
		frame.getContentPane().add(chckbxCompleted);
		
		JButton btnCalculateGpa = new JButton("Calculate GPA");
		springLayout.putConstraint(SpringLayout.NORTH, btnCalculateGpa, 2, SpringLayout.SOUTH, btnRemoveClass);
		springLayout.putConstraint(SpringLayout.WEST, btnCalculateGpa, 10, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(btnCalculateGpa);
	}
}
