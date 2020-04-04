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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OrganizerGradePage extends JFrame {

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
		btnGoHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OrganizerHome homePage = new OrganizerHome(classController, scheduleController);
				homePage.setVisible(true);
				contentPane.setVisible(false);
				dispose();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnGoHome, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnGoHome, -10, SpringLayout.EAST, contentPane);
		contentPane.add(btnGoHome);
		
		JButton btnNewButton = new JButton("Add Class with Grade Information");
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, 0, SpringLayout.EAST, contentPane);
		contentPane.add(btnNewButton);
		
		JButton btnEnterHypotheticalGrades = new JButton("Enter Grades For Class");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnEnterHypotheticalGrades, 134, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, -22, SpringLayout.NORTH, btnEnterHypotheticalGrades);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnEnterHypotheticalGrades, -36, SpringLayout.EAST, contentPane);
		contentPane.add(btnEnterHypotheticalGrades);
	}
	public OrganizerGradePage(ClassController classController, ScheduleController scheduleController) {
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
		btnGoHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OrganizerHome homePage = new OrganizerHome(classController, scheduleController);
				homePage.setVisible(true);
				contentPane.setVisible(false);
				dispose();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnGoHome, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnGoHome, -10, SpringLayout.EAST, contentPane);
		contentPane.add(btnGoHome);
		
		JButton btnNewButton = new JButton("Add Class with Grade Information");
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, 0, SpringLayout.EAST, contentPane);
		contentPane.add(btnNewButton);
		
		JButton btnEnterHypotheticalGrades = new JButton("Enter Grades For Class");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnEnterHypotheticalGrades, 134, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, -22, SpringLayout.NORTH, btnEnterHypotheticalGrades);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnEnterHypotheticalGrades, -36, SpringLayout.EAST, contentPane);
		contentPane.add(btnEnterHypotheticalGrades);
	}
}
