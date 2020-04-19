package studentOrganizer;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalTime;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

public class OrganizerHome extends JFrame {

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
					OrganizerHome frame = new OrganizerHome();
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
	public OrganizerHome() {}
	
	public OrganizerHome(ClassController classController, ScheduleController scheduleController) {
		this.scheduleController = scheduleController;
		this.classController = classController;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblStayOrganized = new JLabel("Stay Organized!");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblStayOrganized, 148, SpringLayout.WEST, contentPane);
		lblStayOrganized.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		contentPane.add(lblStayOrganized);
		
		JButton btnNewButton_1 = new JButton("Classes");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_1, 38, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -185, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_1, -22, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblStayOrganized, -6, SpringLayout.NORTH, btnNewButton_1);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				OrganizerClassPage classesPage = new OrganizerClassPage(classController, scheduleController);
				classesPage.setVisible(true);
				
			}
		});
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Schedule");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_1_1, 15, SpringLayout.SOUTH, btnNewButton_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_1_1, 0, SpringLayout.WEST, btnNewButton_1);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton_1_1, -123, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_1_1, -22, SpringLayout.EAST, contentPane);
		
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[] scheduleButtons = { "Cancel", "Add event to schedule", "View schedule" };
			    int action = JOptionPane.showOptionDialog(null, "What do you want to do?", "Customized dialog",
			        JOptionPane.YES_NO_CANCEL_OPTION, 1, null, scheduleButtons, null);
			    if (scheduleButtons[action] == "Add event to schedule") {
			    	addEventToSchedule();
			    } 
			    else if (scheduleButtons[action] == "View schedule") {
			    	selectDayToView();
			    }
			}
		});
		btnNewButton_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_2 = new JButton("Grade Calculator");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_2, 22, SpringLayout.SOUTH, btnNewButton_1_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_2, 0, SpringLayout.WEST, btnNewButton_1);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton_2, -49, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_2, -22, SpringLayout.EAST, contentPane);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				contentPane.setVisible(false);
				OrganizerGradePage gradePage = new OrganizerGradePage(classController, scheduleController);
				gradePage.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		contentPane.add(btnNewButton_2);
		
		JList list = new JList(classController.getAllTasks());
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_1, 40, SpringLayout.EAST, list);
		sl_contentPane.putConstraint(SpringLayout.WEST, list, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, list, -45, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, list, 184, SpringLayout.WEST, contentPane);
		contentPane.add(list);
		
		JButton btnNewButton = new JButton("Modify Tasks");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 25, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, 0, SpringLayout.SOUTH, contentPane);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				contentPane.setVisible(false);
				OrganizerListPage listPage = new OrganizerListPage(classController, scheduleController);
				listPage.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("To-do:");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 35, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, list, 2, SpringLayout.SOUTH, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 0, SpringLayout.NORTH, btnNewButton_1);
		contentPane.add(lblNewLabel_1);
		
	
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
					LocalTime[] eventMeetingTime = parseStringEventTimeToLocalTime(stringEventTime);
					
					addSpecifiedEventsToSchedule(eventTitle, allBoxes, eventMeetingTime);
					
					JOptionPane.showMessageDialog(null, eventTitle + " added to schedule");
				}
				catch (Exception exception){
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
			contentPane.setVisible(false);
			dispose();
		}
		else if (day=="Tuesday") {
			TuesdaySchedule schedulePage = new TuesdaySchedule(scheduleController, classController);
			schedulePage.setVisible(true);
			contentPane.setVisible(false);
			dispose();
		}
		else if (day=="Wednesday") {
			WednesdaySchedule schedulePage = new WednesdaySchedule(scheduleController, classController);
			schedulePage.setVisible(true);
			contentPane.setVisible(false);
			dispose();
		}
		else if (day=="Thursday") {
			ThursdaySchedule schedulePage = new ThursdaySchedule(scheduleController, classController);
			schedulePage.setVisible(true);
			contentPane.setVisible(false);
			dispose();
		}
		else if (day=="Friday") {
			FridaySchedule schedulePage = new FridaySchedule(scheduleController, classController);
			schedulePage.setVisible(true);
			contentPane.setVisible(false);
			dispose();
		}
		else if (day=="Saturday") {
			SaturdaySchedule schedulePage = new SaturdaySchedule(scheduleController, classController);
			schedulePage.setVisible(true);
			contentPane.setVisible(false);
			dispose();
			
		}
		else if (day=="Sunday") {
			SundaySchedule schedulePage = new SundaySchedule(scheduleController, classController);
			schedulePage.setVisible(true);
			contentPane.setVisible(false);
			dispose();
		}
	}
	
	private void addSpecifiedEventsToSchedule(String eventTitle, JCheckBox[] dayBoxes, LocalTime[] eventTime) {
		String [] weekday = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		for (int i = 0; i < 7; i++) {
			if(dayBoxes[i].isSelected()) {
				scheduleController.addEvent(eventTitle, weekday[i], eventTime);
			}
		}
	}
	
	private LocalTime[] parseStringEventTimeToLocalTime(String stringEventTime) {
		String startString = stringEventTime.split("-")[0];
		String endString = stringEventTime.split("-")[1];
		
		int startHour = Integer.parseInt(startString.split(":")[0]);
		int startMinute = Integer.parseInt(startString.split(":")[1]);
		int endHour = Integer.parseInt(endString.split(":")[0]);
		int endMinute = Integer.parseInt(endString.split(":")[1]);
		
		LocalTime[] eventMeetingTime = new LocalTime[]{LocalTime.of(startHour, startMinute),
				LocalTime.of(endHour, endMinute)};
		
		return eventMeetingTime;
	}
}



