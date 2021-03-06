package studentOrganizer;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OrganizerClassPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrganizerClassPage frame = new OrganizerClassPage();
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
	public OrganizerClassPage() {}
	
	public OrganizerClassPage(ClassController classController, ScheduleController scheduleController) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Your Classes:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, 40, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, 135, SpringLayout.WEST, contentPane);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		contentPane.add(lblNewLabel);
		
		JList list = new JList(classController.getAllCourses());
		sl_contentPane.putConstraint(SpringLayout.NORTH, list, 6, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, list, 0, SpringLayout.WEST, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, list, -34, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, list, 253, SpringLayout.WEST, contentPane);
		contentPane.add(list);
		
		JButton btnNewButton = new JButton("Add Class");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String courseName = (String)JOptionPane.showInputDialog(contentPane, "What is your course's name?", "Customized dialog", JOptionPane.PLAIN_MESSAGE, null,null, null);
				if ((courseName!=null) && (courseName.length()>0)) {
					classController.addCourse(courseName);
					return;
				}
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 67, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, -135, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, 128, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, -21, SpringLayout.EAST, contentPane);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Remove Class");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					classController.removeCourse(list.getSelectedIndex());
				}
				catch (Exception exception) {
					JOptionPane.showMessageDialog(null, "Please Select a class to remove", "Warning", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_1, 34, SpringLayout.SOUTH, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_1, 0, SpringLayout.WEST, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -45, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_1, -5, SpringLayout.EAST, btnNewButton);
		contentPane.add(btnNewButton_1);
		
		JButton btnGoHome = new JButton("Go home ");
		btnGoHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OrganizerHome homePage = new OrganizerHome(classController,scheduleController);
				homePage.setVisible(true);
				dispose();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnGoHome, 4, SpringLayout.NORTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnGoHome, 0, SpringLayout.WEST, btnNewButton);
		contentPane.add(btnGoHome); 
		
		
	}
	
	

}
