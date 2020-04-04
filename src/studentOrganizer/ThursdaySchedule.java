package studentOrganizer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class ThursdaySchedule extends JFrame {

	private JPanel contentPane;
	private ScheduleController controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThursdaySchedule frame = new ThursdaySchedule();
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
	public ThursdaySchedule() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblTodaysSchedule = new JLabel("Thursday's Schedule:");
		sl_contentPane.putConstraint(SpringLayout.EAST, lblTodaysSchedule, 276, SpringLayout.WEST, contentPane);
		lblTodaysSchedule.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblTodaysSchedule, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblTodaysSchedule, 29, SpringLayout.WEST, contentPane);
		contentPane.add(lblTodaysSchedule);
		
		controller = new ScheduleController();
		JList list = new JList(controller.getMondayCourses());
		sl_contentPane.putConstraint(SpringLayout.NORTH, list, 43, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, list, -28, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblTodaysSchedule, -6, SpringLayout.NORTH, list);
		sl_contentPane.putConstraint(SpringLayout.WEST, list, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, list, 408, SpringLayout.WEST, contentPane);
		contentPane.add(list); 
		
		JButton btnGoHome = new JButton("Go Home");
		btnGoHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OrganizerHome homePage = new OrganizerHome();
				homePage.setVisible(true);
				contentPane.setVisible(false);
				dispose();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnGoHome, 5, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnGoHome, -10, SpringLayout.EAST, contentPane);
		contentPane.add(btnGoHome);
		String [] dayOptions = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
	}

}
