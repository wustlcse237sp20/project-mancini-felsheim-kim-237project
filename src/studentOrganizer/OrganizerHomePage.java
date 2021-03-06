package studentOrganizer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalTime;

import javax.swing.JList;
import javax.swing.JOptionPane;
public class OrganizerHomePage {

	private JFrame frame;
	private ClassController classController;
	private ScheduleController scheduleController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrganizerHomePage window = new OrganizerHomePage();
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
	public OrganizerHomePage() {
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
		
		classController = new ClassController();
		scheduleController = new ScheduleController();
		
		JLabel lblNewLabel = new JLabel("Stay Organized!");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 110, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, 45, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -110, SpringLayout.EAST, frame.getContentPane());
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 29));
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Modify Tasks");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose(); 
				OrganizerListPage listPage = new OrganizerListPage(classController, scheduleController);
				listPage.setVisible(true);
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 20, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, -6, SpringLayout.SOUTH, frame.getContentPane());
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Classes");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				OrganizerClassPage classesPage = new OrganizerClassPage(classController, scheduleController);
				classesPage.setVisible(true);
			}
		});
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_1, -29, SpringLayout.EAST, frame.getContentPane());
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_1, 6, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_1, 67, SpringLayout.SOUTH, lblNewLabel);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Schedule");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String[] scheduleButtons = { "Cancel", "Add event(s) to schedule", "View schedule" };
			    int action = JOptionPane.showOptionDialog(null, "What do you want to do?", "Customized dialog",
			        JOptionPane.YES_NO_CANCEL_OPTION, 1, null, scheduleButtons, null);
			    if (scheduleButtons[action] == "Add event(s) to schedule") {
			    	addEventToSchedule();
			    } 
			    else if (scheduleButtons[action] == "View schedule") {
			    	selectDayToView();
			    }
				
				
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_1_1, 232, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_1_1, -29, SpringLayout.EAST, frame.getContentPane());
		btnNewButton_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_1_1, 17, SpringLayout.SOUTH, btnNewButton_1);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_1_1, -88, SpringLayout.SOUTH, frame.getContentPane());
		frame.getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_2 = new JButton("Grade Calculator");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				OrganizerGradePage gradePage = new OrganizerGradePage(classController, scheduleController);
				gradePage.setVisible(true);
			}
		});
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, -71, SpringLayout.WEST, btnNewButton_2);
		btnNewButton_2.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_2, 16, SpringLayout.SOUTH, btnNewButton_1_1);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_2, 0, SpringLayout.WEST, btnNewButton_1);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_2, -16, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_2, -24, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("To-do:");
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_1, 107, SpringLayout.EAST, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 166, SpringLayout.SOUTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 6, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 61, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, 22, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_1, 125, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(lblNewLabel_1);
		
		JList list = new JList();
		springLayout.putConstraint(SpringLayout.NORTH, list, 9, SpringLayout.SOUTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.WEST, list, 20, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, list, 148, SpringLayout.SOUTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.EAST, list, 168, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(list);
	}
	
	private void addEventToSchedule() {
		String eventTitle = (String)JOptionPane.showInputDialog(null, "What is the name of the event?", 
				"Customized dialog", JOptionPane.PLAIN_MESSAGE, null, null, null);
		if ((eventTitle!=null) && (eventTitle.length()>0)) {
			
			JCheckBox sundayBox = new JCheckBox("Sunday");
			JCheckBox mondayBox = new JCheckBox("Monday");
			JCheckBox tuesdayBox = new JCheckBox("Tuesday");
			JCheckBox wednesdayBox = new JCheckBox("Wednesday");
			JCheckBox thursdayBox = new JCheckBox("Thursday");
			JCheckBox fridayBox = new JCheckBox("Friday");
			JCheckBox saturdayBox = new JCheckBox("Saturday");
			
			String message = "What day(s) of the week does the event occur?";
			Object[] weekdayParameters = {message, sundayBox, mondayBox, tuesdayBox, wednesdayBox, 
					thursdayBox, fridayBox, saturdayBox};
			int weekdaySelected = JOptionPane.showConfirmDialog(null, weekdayParameters, 
					"Customized dialog", JOptionPane.OK_CANCEL_OPTION);
			JCheckBox[] allBoxes = new JCheckBox[]{sundayBox, mondayBox, tuesdayBox, 
					wednesdayBox, thursdayBox, fridayBox, saturdayBox};
			
			if (weekdaySelected == 0 && isAnyBoxSelected(allBoxes)) {
				String stringEventTime = (String)JOptionPane.showInputDialog(null, 
						"What time does the event occur? \n\nEnter as HH:MM-HH:MM, where HH refers to hour "
						+ "(ranging from 00 to 23) \nand MM refers to minute (ranging from 00 to 59).", 
						"Customized dialog", JOptionPane.PLAIN_MESSAGE, null, null, null);
				try {
					scheduleController.addSpecifiedEventsToSchedule(eventTitle, allBoxes, stringEventTime);					
					JOptionPane.showMessageDialog(null, eventTitle + " added to schedule");
				}
				catch (Exception exception) {
					JOptionPane.showMessageDialog(null, "Invalid time of event entered. \n\nMake sure to "
							+ "enter as HH:MM-HH:MM, where HH refers to hour (ranging from 00 to "
							+ "23) \nand MM refers to minute (ranging from 00 to 59).", "Warning",
					        JOptionPane.WARNING_MESSAGE);
				}
				
				
			} else if (!isAnyBoxSelected(allBoxes)) {
				JOptionPane.showMessageDialog(null, "You must select at least one day.", "Warning",
				        JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	
	private boolean isAnyBoxSelected(JCheckBox[] allBoxes) {
		for (JCheckBox checkbox: allBoxes) {
			if (checkbox.isSelected()) {
				return true;
			}
		}
		return false;
	}
	
	private void selectDayToView() {
		String [] dayOptions = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    	String day = (String)JOptionPane.showInputDialog(null, "What day do you want to view?", "Customized dialog", 
				JOptionPane.QUESTION_MESSAGE, null, dayOptions, dayOptions[0]);
    	
		if (day=="Monday") {
			MondaySchedule schedulePage = new MondaySchedule(scheduleController, classController);
			schedulePage.setVisible(true);
			frame.dispose();
		}
		else if (day=="Tuesday") {
			TuesdaySchedule schedulePage = new TuesdaySchedule(scheduleController, classController);
			schedulePage.setVisible(true);
			frame.dispose();
		}
		else if (day=="Wednesday") {
			WednesdaySchedule schedulePage = new WednesdaySchedule(scheduleController, classController);
			schedulePage.setVisible(true);
			frame.dispose();
		}
		else if (day=="Thursday") {
			ThursdaySchedule schedulePage = new ThursdaySchedule(scheduleController, classController);
			schedulePage.setVisible(true);
			frame.dispose();
		}
		else if (day=="Friday") {
			FridaySchedule schedulePage = new FridaySchedule(scheduleController, classController);
			schedulePage.setVisible(true);
			frame.dispose();
		}
		else if (day=="Saturday") {
			SaturdaySchedule schedulePage = new SaturdaySchedule(scheduleController, classController);
			schedulePage.setVisible(true);
			frame.dispose();
			
		}
		else if (day=="Sunday") {
			SundaySchedule schedulePage = new SundaySchedule(scheduleController, classController);
			schedulePage.setVisible(true);
			frame.dispose();
		}
	}
	
}
