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

public class OrganizerSchedulePage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrganizerSchedulePage frame = new OrganizerSchedulePage();
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
	public OrganizerSchedulePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblTodaysSchedule = new JLabel("Today's Schedule:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblTodaysSchedule, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblTodaysSchedule, 29, SpringLayout.WEST, contentPane);
		contentPane.add(lblTodaysSchedule);
		
		JList list = new JList();
		sl_contentPane.putConstraint(SpringLayout.NORTH, list, 17, SpringLayout.SOUTH, lblTodaysSchedule);
		sl_contentPane.putConstraint(SpringLayout.WEST, list, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, list, 193, SpringLayout.SOUTH, lblTodaysSchedule);
		sl_contentPane.putConstraint(SpringLayout.EAST, list, 199, SpringLayout.WEST, contentPane);
		contentPane.add(list);
		
		JButton btnGoHome = new JButton("Go Home");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnGoHome, -5, SpringLayout.NORTH, lblTodaysSchedule);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnGoHome, -10, SpringLayout.EAST, contentPane);
		contentPane.add(btnGoHome);
		
		JButton btnViewADifferent = new JButton("View a Different Day");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnViewADifferent, 24, SpringLayout.SOUTH, btnGoHome);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnViewADifferent, -37, SpringLayout.EAST, contentPane);
		contentPane.add(btnViewADifferent);
		
		JButton btnNewButton = new JButton("Add a Class Meeting Time");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 17, SpringLayout.SOUTH, btnViewADifferent);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 6, SpringLayout.EAST, list);
		contentPane.add(btnNewButton);
		
		JButton btnDeleteAClass = new JButton("Delete A Class Meeting Time");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnDeleteAClass, 21, SpringLayout.SOUTH, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnDeleteAClass, 6, SpringLayout.EAST, list);
		contentPane.add(btnDeleteAClass);
	}

}
