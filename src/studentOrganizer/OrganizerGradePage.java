package studentOrganizer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Font;

public class OrganizerGradePage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrganizerGradePage frame = new OrganizerGradePage();
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
	public OrganizerGradePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblYourClassGrades = new JLabel("Your Class Grades");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblYourClassGrades, 20, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblYourClassGrades, 25, SpringLayout.WEST, contentPane);
		contentPane.add(lblYourClassGrades);
		
		JList list = new JList();
		sl_contentPane.putConstraint(SpringLayout.NORTH, list, 11, SpringLayout.SOUTH, lblYourClassGrades);
		sl_contentPane.putConstraint(SpringLayout.WEST, list, 15, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, list, 196, SpringLayout.SOUTH, lblYourClassGrades);
		sl_contentPane.putConstraint(SpringLayout.EAST, list, 180, SpringLayout.WEST, contentPane);
		contentPane.add(list);
		
		JButton btnGoHome = new JButton("Go Home");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnGoHome, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnGoHome, -10, SpringLayout.EAST, contentPane);
		contentPane.add(btnGoHome);
		
		JButton btnNewButton = new JButton("Add Class to Gradebook");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 19, SpringLayout.SOUTH, btnGoHome);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, -28, SpringLayout.EAST, contentPane);
		contentPane.add(btnNewButton);
		
		JButton btnChangeExistingClass = new JButton("Change Information for Existing Class");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnChangeExistingClass, 21, SpringLayout.SOUTH, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnChangeExistingClass, 50, SpringLayout.SOUTH, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnChangeExistingClass, -10, SpringLayout.EAST, contentPane);
		btnChangeExistingClass.setFont(new Font("Kohinoor Telugu", Font.PLAIN, 11));
		contentPane.add(btnChangeExistingClass);
		
		JButton btnEnterHypotheticalGrades = new JButton("Enter Hypothetical Grades");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnEnterHypotheticalGrades, 16, SpringLayout.SOUTH, btnChangeExistingClass);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnEnterHypotheticalGrades, 0, SpringLayout.WEST, btnNewButton);
		contentPane.add(btnEnterHypotheticalGrades);
	}
}
