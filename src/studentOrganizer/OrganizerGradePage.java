package studentOrganizer;

import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OrganizerGradePage extends JFrame {

	private JPanel contentPane;
	private DefaultMutableTreeNode selectedNode;
  
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
	public OrganizerGradePage() {}
	
	public OrganizerGradePage(ClassController classController, ScheduleController scheduleController) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblYourClassGrades = new JLabel("Your Semester GPA: " + classController.calculateGPA());
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblYourClassGrades, 20, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblYourClassGrades, 25, SpringLayout.WEST, contentPane);
		contentPane.add(lblYourClassGrades);
		
	    JTree tree = new JTree(classController.getRoot());

	    // Listen for when the selection changes.
	    tree.addTreeSelectionListener(new TreeSelectionListener() {
	        public void valueChanged(TreeSelectionEvent e) {
	            selectedNode = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
	            if (selectedNode == null) return;	            	            
	        }
	    });

	    // Add tree to frame
		sl_contentPane.putConstraint(SpringLayout.NORTH, tree, 11, SpringLayout.SOUTH, lblYourClassGrades);
		sl_contentPane.putConstraint(SpringLayout.WEST, tree, 5, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, tree, 220, SpringLayout.SOUTH, lblYourClassGrades);
		sl_contentPane.putConstraint(SpringLayout.EAST, tree, 180, SpringLayout.WEST, contentPane);
	    contentPane.add(tree);
		
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
		
		JButton btnEnterCategoryInfo = new JButton("Enter Category Information to Class");
		btnEnterCategoryInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// if the selected node in the tree was null or not a course
				if(selectedNode == null || selectedNode.getLevel() != 1) {
					JOptionPane.showMessageDialog(null, "Please select a course before adding a category.");
				} else {
					JTextField categoryName = new JTextField();
					JTextField categoryWeight = new JTextField();
					Object[] message = {
					    "Category name:", categoryName,
					    "Category weight as a decimal from 0 to 1:", categoryWeight
					};

					int option = JOptionPane.showConfirmDialog(null, message, "Select a Course before Adding a Category", JOptionPane.OK_CANCEL_OPTION);
					if (option == JOptionPane.OK_OPTION) {
						try {
							double weight = Double.parseDouble(categoryWeight.getText());
							if(weight > 1 || weight < 0) {
								throw new Exception();
							}
						} catch(Exception numberFormatException) {
							JOptionPane.showMessageDialog(null, "Please enter a decimal from 0 to 1 as the weight.");
							return;
						}
					    if (!categoryName.getText().equals("") && !categoryWeight.getText().equals("")) {
					        	// Add Category to JTree's model
						        classController.addCategory(selectedNode, categoryName.getText(), Double.parseDouble(categoryWeight.getText()));
					        	DefaultTreeModel model = (DefaultTreeModel)tree.getModel();		
						        model.reload(classController.getRoot());
					    } else {
							JOptionPane.showMessageDialog(null, "Please enter input.");
					    }
					}
				}

			}
		});
		sl_contentPane.putConstraint(SpringLayout.EAST, btnEnterCategoryInfo, 8, SpringLayout.EAST, contentPane);
		contentPane.add(btnEnterCategoryInfo);
		
		JButton btnEnterAssignmentGrade = new JButton("Add Assignment Grade to Category");
		btnEnterAssignmentGrade.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// if the selected node in the tree was null or not a category
				if(selectedNode == null || selectedNode.getLevel() != 2) {
					JOptionPane.showMessageDialog(null, "Please select a category before adding an assignment.");
				} else {
					JTextField assignmentName = new JTextField();
					JTextField points = new JTextField();
					JTextField outOf = new JTextField();
					Object[] message = {
					    "Assignment name:                                 ", assignmentName,
					    "Points:", points,
					    "Out of:", outOf
					};

					int option = JOptionPane.showConfirmDialog(null, message, "Select a Category before Adding an Assignment", JOptionPane.OK_CANCEL_OPTION);
					if (option == JOptionPane.OK_OPTION) {
						try {
							Integer.parseInt(points.getText());
							Integer.parseInt(outOf.getText());
						} catch(Exception numberFormatException) {
							JOptionPane.showMessageDialog(null, "Please enter valid values.");							
							return;
						}
					    if (!assignmentName.getText().equals("") && !points.getText().equals("") && !outOf.getText().equals("")) {
						        classController.addAssignment(selectedNode, assignmentName.getText(), Integer.parseInt(points.getText()), Integer.parseInt(outOf.getText()));
					        	DefaultTreeModel model = (DefaultTreeModel)tree.getModel();				        
						        model.reload(classController.getRoot());
						        lblYourClassGrades.setText("Your Semester GPA: " + classController.calculateGPA());
					    } else {
							JOptionPane.showMessageDialog(null, "Please enter input.");
					    }
					}
				}

			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnEnterAssignmentGrade, 134, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnEnterCategoryInfo, -22, SpringLayout.NORTH, btnEnterAssignmentGrade);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnEnterAssignmentGrade, 4, SpringLayout.EAST, contentPane);
		contentPane.add(btnEnterAssignmentGrade);
		
		JButton btnRemoveAssignmentGrade = new JButton("Delete Assignment Grade");
		btnRemoveAssignmentGrade.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// if the selected node in the tree was null or not an assignment
				if(selectedNode == null || selectedNode.getLevel() != 3) {
					JOptionPane.showMessageDialog(null, "Please select an assignment to delete.");
				} else {
					// delete assignment
			        classController.deleteAssignment(selectedNode);
		        	DefaultTreeModel model = (DefaultTreeModel)tree.getModel();				        
			        model.reload(classController.getRoot());
			        // reload JLabel
			        lblYourClassGrades.setText("Your Semester GPA: " + classController.calculateGPA());
				}
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnRemoveAssignmentGrade, 22, SpringLayout.SOUTH, btnEnterAssignmentGrade);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnRemoveAssignmentGrade, -20, SpringLayout.EAST, contentPane);
		contentPane.add(btnRemoveAssignmentGrade);
	}
}
