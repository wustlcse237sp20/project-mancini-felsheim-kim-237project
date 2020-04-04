package studentOrganizer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class OrganizerListPage extends JFrame {

	private JPanel contentPane;
	private ClassController classController;
	private ScheduleController scheduleController;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrganizerListPage frame = new OrganizerListPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OrganizerListPage() {
	}
	
	public OrganizerListPage(ClassController classController, ScheduleController scheduleController) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblToDoList = new JLabel("To Do List");
		lblToDoList.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblToDoList, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblToDoList, 23, SpringLayout.WEST, contentPane);
		contentPane.add(lblToDoList);
		
		JList list = new JList(classController.getAllTasks());
		sl_contentPane.putConstraint(SpringLayout.NORTH, list, 17, SpringLayout.SOUTH, lblToDoList);
		sl_contentPane.putConstraint(SpringLayout.WEST, list, 20, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, list, -16, SpringLayout.SOUTH, contentPane);
		contentPane.add(list);
		
		JButton btnGoHome = new JButton("Go Home");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnGoHome, 0, SpringLayout.NORTH, lblToDoList);
		btnGoHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OrganizerHome homePage = new OrganizerHome(classController, scheduleController);
				homePage.setVisible(true);
				contentPane.setVisible(false);
				dispose();
			}
		});
		contentPane.add(btnGoHome);
		
		JButton btnNewButton = new JButton("Add New Task");
		sl_contentPane.putConstraint(SpringLayout.EAST, list, -6, SpringLayout.WEST, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 21, SpringLayout.SOUTH, btnGoHome);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String s = (String)JOptionPane.showInputDialog(contentPane, "What is your task?", "Customized dialog", JOptionPane.PLAIN_MESSAGE, null,null, null);
				if ((s!=null) && (s.length()>0)) {
					classController.addTask(s);
					return;
				}
			}
		});
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, -33, SpringLayout.EAST, contentPane);
		contentPane.add(btnNewButton);
		
		JButton btnDeleteTask = new JButton("Delete Task");
		btnDeleteTask.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				classController.removeTask(list.getSelectedIndex());
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnDeleteTask, 22, SpringLayout.SOUTH, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnDeleteTask, 0, SpringLayout.WEST, btnNewButton);
		contentPane.add(btnDeleteTask);
		
		JCheckBox chckbxUrgent = new JCheckBox("Urgent?");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnGoHome, 0, SpringLayout.WEST, chckbxUrgent);
		sl_contentPane.putConstraint(SpringLayout.NORTH, chckbxUrgent, 18, SpringLayout.SOUTH, btnDeleteTask);
		contentPane.add(chckbxUrgent);
		
		JCheckBox chckbxCompleted = new JCheckBox("Completed?");
		sl_contentPane.putConstraint(SpringLayout.NORTH, chckbxCompleted, 20, SpringLayout.SOUTH, chckbxUrgent);
		sl_contentPane.putConstraint(SpringLayout.WEST, chckbxUrgent, 0, SpringLayout.WEST, chckbxCompleted);
		sl_contentPane.putConstraint(SpringLayout.EAST, chckbxCompleted, -52, SpringLayout.EAST, contentPane);
		contentPane.add(chckbxCompleted);
		
	}

}
