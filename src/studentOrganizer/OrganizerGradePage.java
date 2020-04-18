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
	
	// **
	//private JTree tree;
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
		
		// initialize JTree with classController
//		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Courses");
//		for(Object course : classController.getAllCourses().toArray()) {
//		    root.add(new DefaultMutableTreeNode(course.toString()));
//		    for(Category category : classController.getGPACalculator().categories) {
//		    	Enumeration e = root.children();
//		    	while(e.hasMoreElements()) {
//		    		DefaultMutableTreeNode child = (DefaultMutableTreeNode) e.nextElement();
//			    	if(child.toString().equals(category.c)) {
//			    		child.add(new DefaultMutableTreeNode(category));
//			    	}
//		    	}
//		    }
//		}
//		DefaultMutableTreeNode t = new DefaultMutableTreeNode();
	    JTree tree = new JTree(classController.getRoot());
		//DefaultTreeModel treeModel = (DefaultTreeModel) this.tree.getModel();


	    //Listen for when the selection changes.
	    tree.addTreeSelectionListener(new TreeSelectionListener() {
	        public void valueChanged(TreeSelectionEvent e) {
	            selectedNode = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();

	            // if nothing is selected
	            if (selectedNode == null) return;

	            // retrieve the node that was selected
	            Object selectedNodeObject = selectedNode.getUserObject();

	            // React to the node selection.
	            // allow the user to enter categories and weights
	            
	        }
	    });

	    // add tree to frame
		sl_contentPane.putConstraint(SpringLayout.NORTH, tree, 11, SpringLayout.SOUTH, lblYourClassGrades);
		sl_contentPane.putConstraint(SpringLayout.WEST, tree, 15, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, tree, 196, SpringLayout.SOUTH, lblYourClassGrades);
		sl_contentPane.putConstraint(SpringLayout.EAST, tree, 180, SpringLayout.WEST, contentPane);
	    contentPane.add(tree);
	    
//		JList list = new JList(classController.getAllCourses());
//		list.addListSelectionListener(new ListSelectionListener() {
//		    public void valueChanged(ListSelectionEvent event) {
//		        if (!event.getValueIsAdjusting()){
//		            JList source = (JList)event.getSource();
//		            String selected = source.getSelectedValue().toString();
//		            System.out.println("selected: " + selected);
//		        }
//		    }
//		});
//		sl_contentPane.putConstraint(SpringLayout.NORTH, list, 11, SpringLayout.SOUTH, lblYourClassGrades);
//		sl_contentPane.putConstraint(SpringLayout.WEST, list, 15, SpringLayout.WEST, contentPane);
//		sl_contentPane.putConstraint(SpringLayout.SOUTH, list, 196, SpringLayout.SOUTH, lblYourClassGrades);
//		sl_contentPane.putConstraint(SpringLayout.EAST, list, 180, SpringLayout.WEST, contentPane);
//		contentPane.add(list);
		
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
		
		JButton btnNewButton = new JButton("Add Grade Information to Class");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// if the selected node in the tree was a course
				//if(selectedNode == Course)
				JTextField categoryName = new JTextField();
				JTextField categoryWeight = new JTextField();
				Object[] message = {
				    "Category name:", categoryName,
				    "Category weight:", categoryWeight
				};

				int option = JOptionPane.showConfirmDialog(null, message, "Add a category to a course", JOptionPane.OK_CANCEL_OPTION);
				if (option == JOptionPane.OK_OPTION) {
				    if (!categoryName.getText().equals("") && !categoryWeight.getText().equals("")) {
				        // !! check if selectedNode is null; if it is, tell user to select a course
				        // if I first select, then unselect, it is null
				        
				        if(selectedNode != null) {
					        System.out.println("Category added");
					        
				        	// add Category to JTree's model
					        classController.addCategory(selectedNode, categoryName.getText(), Double.parseDouble(categoryWeight.getText()));
				        	DefaultTreeModel model = (DefaultTreeModel)tree.getModel();				        
					        model.reload(selectedNode);
					        //model.setRoot(classController.getRoot());
				        	
//					        classController.addCategory(selectedNode, categoryName.getText(), Double.parseDouble(categoryWeight.getText()));
//					        classController.getGPAModel().reload(selectedNode);
				        	
				        	// add Category to the model
				        	//!! sanitize input
				        }
				    } else {
				        System.out.println("Please enter input");
				    }
				} else {
				    System.out.println("Category adding canceled");
				}
			}
		});
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, 0, SpringLayout.EAST, contentPane);
		contentPane.add(btnNewButton);
		
		JButton btnEnterHypotheticalGrades = new JButton("Enter Grades For Class");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnEnterHypotheticalGrades, 134, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, -22, SpringLayout.NORTH, btnEnterHypotheticalGrades);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnEnterHypotheticalGrades, -36, SpringLayout.EAST, contentPane);
		contentPane.add(btnEnterHypotheticalGrades);
	}
}
