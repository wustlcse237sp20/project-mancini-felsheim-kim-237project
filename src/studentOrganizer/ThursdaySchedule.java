package studentOrganizer;

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
	public ThursdaySchedule() {}
	
	public ThursdaySchedule(ScheduleController scheduleController, ClassController classController) {
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
		
		JList list = new JList(scheduleController.getEventsByDay("Thursday"));
		sl_contentPane.putConstraint(SpringLayout.NORTH, list, 43, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, list, -28, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblTodaysSchedule, -6, SpringLayout.NORTH, list);
		sl_contentPane.putConstraint(SpringLayout.WEST, list, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, list, 290, SpringLayout.WEST, contentPane);
		contentPane.add(list); 
		
		JButton buttonGoHome = new JButton("Go Home");
		buttonGoHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OrganizerHome homePage = new OrganizerHome(classController, scheduleController);
				homePage.setVisible(true);
				contentPane.setVisible(false);
				dispose();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, buttonGoHome, 5, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, buttonGoHome, -10, SpringLayout.EAST, contentPane);
		contentPane.add(buttonGoHome);
		
		JButton buttonRemove = new JButton("Remove Event");
		buttonRemove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					scheduleController.removeEvent("Thursday", list.getSelectedIndex());
					ThursdaySchedule thursdaySchedule = new ThursdaySchedule(scheduleController, classController);
					thursdaySchedule.setVisible(true);
					contentPane.setVisible(false);
					dispose();
				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, "You must select an event to remove.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, buttonRemove, 30, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, buttonRemove, -10, SpringLayout.EAST, contentPane);
		contentPane.add(buttonRemove);
		
		JButton buttonUpdate = new JButton("Update Event");
		buttonUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String[] updateOptions = { "Cancel", "Update event title", "Update meeting time" };
				    int action = JOptionPane.showOptionDialog(null, "What do you want to update?", "Customized dialog",
				        JOptionPane.YES_NO_CANCEL_OPTION, 1, null, updateOptions, null);
				    if (updateOptions[action] == "Update event title") {
				    	updateEventTitle(scheduleController, list.getSelectedIndex());
				    } 
				    else if (updateOptions[action] == "Update meeting time") {
				    	updateMeetingTime(scheduleController, list.getSelectedIndex());
				    }
				    ThursdaySchedule thursdaySchedule = new ThursdaySchedule(scheduleController, classController);
					thursdaySchedule.setVisible(true);
					contentPane.setVisible(false);
					dispose();
				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, "You must select an event to update.", "Warning",
					        JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, buttonUpdate, 55, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, buttonUpdate, -10, SpringLayout.EAST, contentPane);
		contentPane.add(buttonUpdate);
		
		JButton buttonAddEvent = new JButton("Add Event");
		buttonAddEvent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String eventTitle = (String)JOptionPane.showInputDialog(null, "What is the name of the event?", 
						"Customized dialog", JOptionPane.PLAIN_MESSAGE, null, null, null);
				if ((eventTitle!=null) && (eventTitle.length()>0)) {
					String stringEventTime = (String)JOptionPane.showInputDialog(null, 
							"What time does the event occur? \n\nEnter as HH:MM-HH:MM, where HH refers to hour "
							+ "(ranging from 00 to 23) \nand MM refers to minute (ranging from 00 to 59).", 
							"Customized dialog", JOptionPane.PLAIN_MESSAGE, null, null, null);
					try {
						scheduleController.addEvent(eventTitle, "Thursday", stringEventTime);
						JOptionPane.showMessageDialog(null, eventTitle + " added to schedule");
					}
					catch (Exception exception){
						JOptionPane.showMessageDialog(null, "Invalid time of event entered. \n\nMake sure to "
								+ "enter as HH:MM-HH:MM, where HH refers to hour (ranging from 00 to "
								+ "23) \nand MM refers to minute (ranging from 00 to 59).", "Warning",
						        JOptionPane.WARNING_MESSAGE);
					}
				}
			    ThursdaySchedule thursdaySchedule = new ThursdaySchedule(scheduleController, classController);
				thursdaySchedule.setVisible(true);
				contentPane.setVisible(false);
				dispose();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, buttonAddEvent, 80, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, buttonAddEvent, -10, SpringLayout.EAST, contentPane);
		contentPane.add(buttonAddEvent);
	}
	
	private void updateEventTitle(ScheduleController scheduleController, int index) {
		String newEventTitle = (String)JOptionPane.showInputDialog(null, "What is the updated name of the event?", 
				"Customized dialog", JOptionPane.PLAIN_MESSAGE, null, null, null);
		if ((newEventTitle!=null) && (newEventTitle.length()>0)) {
			scheduleController.updateEventTitle("Thursday", index, newEventTitle);
		}
	}
	
	private void updateMeetingTime(ScheduleController scheduleController, int index) {
		String newStringEventTime = (String)JOptionPane.showInputDialog(null, 
				"What time does the event occur? \n\nEnter as HH:MM-HH:MM, where HH refers to hour "
				+ "(ranging from 00 to 23) \nand MM refers to minute (ranging from 00 to 59).", 
				"Customized dialog", JOptionPane.PLAIN_MESSAGE, null, null, null);
		if ((newStringEventTime!=null) && (newStringEventTime.length()>0)) {
			try {
				scheduleController.updateMeetingTime("Thursday", index, newStringEventTime);
			}
			catch (Exception exception){
				JOptionPane.showMessageDialog(null, "Invalid time of event entered. \n\nMake sure to "
						+ "enter as HH:MM-HH:MM, where HH refers to hour (ranging from 00 to "
						+ "23) \nand MM refers to minute (ranging from 00 to 59).", "Warning",
				        JOptionPane.WARNING_MESSAGE);
			}
		}
	}

}
