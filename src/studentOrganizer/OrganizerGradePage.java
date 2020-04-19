package studentOrganizer;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Enumeration;

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
		
		JLabel lblYourClassGrades = new JLabel("Your Class Grades");
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
		sl_contentPane.putConstraint(SpringLayout.WEST, tree, 15, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, tree, 196, SpringLayout.SOUTH, lblYourClassGrades);
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
				
				// TODO: if the selected node in the tree was a course: if(selectedNode == Course)
				JTextField categoryName = new JTextField();
				JTextField categoryWeight = new JTextField();
				Object[] message = {
				    "Category name:", categoryName,
				    "Category weight as a decimal from 0 to 1:", categoryWeight
				};

				int option = JOptionPane.showConfirmDialog(null, message, "Select a Course before Adding a Category", JOptionPane.OK_CANCEL_OPTION);
				if (option == JOptionPane.OK_OPTION) {
				    if (!categoryName.getText().equals("") && !categoryWeight.getText().equals("")) {
				        
				        if(selectedNode != null) {
					        System.out.println("Category added");
					        
				        	// Add Category to JTree's model
					        classController.addCategory(selectedNode, categoryName.getText(), Double.parseDouble(categoryWeight.getText()));
				        	DefaultTreeModel model = (DefaultTreeModel)tree.getModel();				        
					        model.reload(selectedNode);
				        	
					        // TODO: sanitize input
				        }
				    } else {
				        System.out.println("Please enter input");
				    }
				} else {
				    System.out.println("Category adding canceled");
				}
			}
		});
		sl_contentPane.putConstraint(SpringLayout.EAST, btnEnterCategoryInfo, 8, SpringLayout.EAST, contentPane);
		contentPane.add(btnEnterCategoryInfo);
		
		JButton btnEnterAssignmentGrade = new JButton("Add Assignment Grade to Class");
		btnEnterAssignmentGrade.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO: if the selected node in the tree was a course: if(selectedNode == Course)
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
				    if (!assignmentName.getText().equals("") && !points.getText().equals("") && !outOf.getText().equals("")) {
				        
				        if(selectedNode != null) {
					        System.out.println("Assignment added");
					        
				        	// add Category to JTree's model
					        classController.addAssignment(selectedNode, assignmentName.getText(), Integer.parseInt(points.getText()), Integer.parseInt(outOf.getText()));
				        	DefaultTreeModel model = (DefaultTreeModel)tree.getModel();				        
					        model.reload(selectedNode);
					        
					        // TODO: sanitize input
				        }
				    } else {
				        System.out.println("Please enter input");
				    }
				} else {
				    System.out.println("Assignment adding canceled");
				}
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnEnterAssignmentGrade, 134, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnEnterCategoryInfo, -22, SpringLayout.NORTH, btnEnterAssignmentGrade);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnEnterAssignmentGrade, -4, SpringLayout.EAST, contentPane);

		contentPane.add(btnEnterAssignmentGrade);
	}
}
