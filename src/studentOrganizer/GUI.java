package studentOrganizer;

import javax.swing.*;

public class GUI {
	public static void main(String args[]){
	       JFrame frame = new JFrame("Student Organizer");
	       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       frame.setSize(300,300);
	       JButton button = new JButton("Press Here!");
	       frame.getContentPane().add(button);
	       frame.setVisible(true);
	    }
}
