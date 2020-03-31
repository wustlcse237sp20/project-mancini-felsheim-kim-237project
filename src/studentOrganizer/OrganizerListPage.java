package studentOrganizer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JButton;

public class OrganizerListPage extends JFrame {

	private JPanel contentPane;

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
		
		JList list = new JList();
		sl_contentPane.putConstraint(SpringLayout.NORTH, list, 12, SpringLayout.SOUTH, lblToDoList);
		sl_contentPane.putConstraint(SpringLayout.WEST, list, 15, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, list, 215, SpringLayout.SOUTH, lblToDoList);
		sl_contentPane.putConstraint(SpringLayout.EAST, list, 217, SpringLayout.WEST, contentPane);
		contentPane.add(list);
		
		JButton btnGoHome = new JButton("Go Home");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnGoHome, 0, SpringLayout.NORTH, lblToDoList);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnGoHome, -10, SpringLayout.EAST, contentPane);
		contentPane.add(btnGoHome);
		
		JButton btnNewButton = new JButton("Add New Task");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 21, SpringLayout.SOUTH, btnGoHome);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, -33, SpringLayout.EAST, contentPane);
		contentPane.add(btnNewButton);
		
		JButton btnDeleteTask = new JButton("Delete Task");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnDeleteTask, 22, SpringLayout.SOUTH, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnDeleteTask, 0, SpringLayout.WEST, btnNewButton);
		contentPane.add(btnDeleteTask);
		
		JButton btnChangeCurrentTask = new JButton("Change Current Task ");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnChangeCurrentTask, 23, SpringLayout.SOUTH, btnDeleteTask);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnChangeCurrentTask, 0, SpringLayout.EAST, btnGoHome);
		contentPane.add(btnChangeCurrentTask);
	}

}
