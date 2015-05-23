package hu.unideb.inf.prt.calorie;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JProgressBar;
import javax.swing.JList;
import java.awt.ComponentOrientation;
import javax.swing.ListSelectionModel;
import java.awt.Dimension;

public class View {

	private JFrame frame;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JButton btnLogIn;
	private JButton btnRegister;
	private JPanel panel_1;
	private JTextField txtUsername_1;
	private JTextField txtPassword_1;
	private JTextField txtHeight;
	private JTextField txtBorn;
	private JTextField txtGender;
	private JTextField txtWeight;
	private JLabel lblUsername_1;
	private JLabel lblPassword_1;
	private JLabel lblHeight;
	private JLabel lblBorn;
	private JLabel lblGender;
	private JLabel lblWeight;
	private JButton btnRegister_1;
	private JButton btnCancel;
	private JLayeredPane layeredPane;
	private JList list;
	private JButton btnAddFood;
	private JButton btnRemoveFood;
	private JPanel panel_4;
	private JTextField txtWeight_1;
	private JTextField txtGoal;

	/**
	 * Launch the application.
	 */
	public static void ActivateLayer(int i, JLayeredPane layeredPane){
		
		for(Component component: layeredPane.getComponents()){
			if(component.equals(layeredPane.getComponentsInLayer(i)[0]))
			component.setVisible(true);
			else{
				component.setVisible(false);
			}
		}
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View window = new View();
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
	public View() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		layeredPane.add(panel);
		panel.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(81, 122, 86, 20);
		txtUsername.setText("Username");
		panel.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(263, 122, 86, 20);
		txtPassword.setText("Password");
		panel.add(txtPassword);
		txtPassword.setColumns(10);
		
		lblUsername = new JLabel("Username");
		lblUsername.setBounds(81, 97, 74, 14);
		panel.add(lblUsername);
		
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(263, 97, 86, 14);
		panel.add(lblPassword);
		
		btnLogIn = new JButton("Log in");
		btnLogIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ActivateLayer(2, layeredPane);
			}
		});
		btnLogIn.setBounds(171, 164, 89, 23);
		panel.add(btnLogIn);
		
		btnRegister = new JButton("Register");
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ActivateLayer(1, layeredPane);
			}
		});
		btnRegister.setBounds(171, 198, 89, 23);
		panel.add(btnRegister);
		
		panel_1 = new JPanel();
		panel_1.setVisible(false);
		layeredPane.setLayer(panel_1, 1);
		panel_1.setBounds(0, 0, 434, 261);
		layeredPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtUsername_1 = new JTextField();
		txtUsername_1.setEnabled(true);
		txtUsername_1.setEditable(true);
		txtUsername_1.setText("Username");
		txtUsername_1.setBounds(94, 60, 86, 20);
		panel_1.add(txtUsername_1);
		txtUsername_1.setColumns(10);
		
		txtPassword_1 = new JTextField();
		txtPassword_1.setText("Password");
		txtPassword_1.setBounds(94, 101, 86, 20);
		panel_1.add(txtPassword_1);
		txtPassword_1.setColumns(10);
		
		txtHeight = new JTextField();
		txtHeight.setText("Height");
		txtHeight.setBounds(311, 60, 86, 20);
		panel_1.add(txtHeight);
		txtHeight.setColumns(10);
		
		txtBorn = new JTextField();
		txtBorn.setText("Born");
		txtBorn.setBounds(311, 101, 86, 20);
		panel_1.add(txtBorn);
		txtBorn.setColumns(10);
		
		txtGender = new JTextField();
		txtGender.setText("Gender");
		txtGender.setBounds(311, 139, 86, 20);
		panel_1.add(txtGender);
		txtGender.setColumns(10);
		
		txtWeight = new JTextField();
		txtWeight.setText("Weight");
		txtWeight.setBounds(311, 178, 86, 20);
		panel_1.add(txtWeight);
		txtWeight.setColumns(10);
		
		lblUsername_1 = new JLabel("Username");
		lblUsername_1.setBounds(10, 63, 74, 14);
		panel_1.add(lblUsername_1);
		
		lblPassword_1 = new JLabel("Password");
		lblPassword_1.setBounds(10, 104, 74, 14);
		panel_1.add(lblPassword_1);
		
		lblHeight = new JLabel("Height");
		lblHeight.setBounds(230, 63, 71, 14);
		panel_1.add(lblHeight);
		
		lblBorn = new JLabel("Born");
		lblBorn.setBounds(230, 104, 71, 14);
		panel_1.add(lblBorn);
		
		lblGender = new JLabel("Gender");
		lblGender.setBounds(230, 142, 71, 14);
		panel_1.add(lblGender);
		
		lblWeight = new JLabel("Weight");
		lblWeight.setBounds(230, 181, 71, 14);
		panel_1.add(lblWeight);
		
		btnRegister_1 = new JButton("Register");
		btnRegister_1.setBounds(65, 152, 89, 23);
		panel_1.add(btnRegister_1);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(65, 186, 89, 23);
		panel_1.add(btnCancel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setVisible(false);
		layeredPane.setLayer(panel_2, 2);
		panel_2.setBounds(0, 0, 434, 261);
		layeredPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblCalories = new JLabel("Calories");
		lblCalories.setBounds(10, 86, 56, 14);
		panel_2.add(lblCalories);
		
		JLabel lblCarbohydrate = new JLabel("Carbohydrate");
		lblCarbohydrate.setBounds(10, 116, 72, 14);
		panel_2.add(lblCarbohydrate);
		
		JLabel lblProtein = new JLabel("Protein");
		lblProtein.setBounds(10, 146, 46, 14);
		panel_2.add(lblProtein);
		
		JLabel lblFat = new JLabel("Fat");
		lblFat.setBounds(10, 176, 46, 14);
		panel_2.add(lblFat);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(110, 86, 190, 14);
		panel_2.add(progressBar);
		
		JProgressBar progressBar_1 = new JProgressBar();
		progressBar_1.setBounds(110, 116, 190, 14);
		panel_2.add(progressBar_1);
		
		JProgressBar progressBar_2 = new JProgressBar();
		progressBar_2.setBounds(110, 146, 190, 14);
		panel_2.add(progressBar_2);
		
		JProgressBar progressBar_3 = new JProgressBar();
		progressBar_3.setBounds(110, 176, 190, 14);
		panel_2.add(progressBar_3);
		
		JLabel label = new JLabel("0/0");
		label.setBounds(320, 86, 104, 14);
		panel_2.add(label);
		
		JLabel label_1 = new JLabel("0/0");
		label_1.setBounds(320, 116, 104, 14);
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel("0/0");
		label_2.setBounds(320, 146, 104, 14);
		panel_2.add(label_2);
		
		JLabel label_3 = new JLabel("0/0");
		label_3.setBounds(320, 176, 104, 14);
		panel_2.add(label_3);
		
		JLabel lblCurrentHealthStatus = new JLabel("Current health status:");
		lblCurrentHealthStatus.setBounds(110, 61, 190, 14);
		panel_2.add(lblCurrentHealthStatus);
		
		JButton btnChangeData = new JButton("Change data");
		btnChangeData.setBounds(110, 27, 118, 23);
		panel_2.add(btnChangeData);
		
		JButton btnAddMeal = new JButton("Add meal");
		btnAddMeal.setBounds(335, 11, 89, 23);
		panel_2.add(btnAddMeal);
		
		JButton btnStatistics = new JButton("Statistics");
		btnStatistics.setBounds(335, 45, 89, 23);
		panel_2.add(btnStatistics);
		
		JButton btnRecipes = new JButton("Recipes");
		btnRecipes.setBounds(10, 11, 89, 39);
		panel_2.add(btnRecipes);
		
		JPanel panel_3 = new JPanel();
		layeredPane.setLayer(panel_3, 3);
		panel_3.setBounds(0, 0, 434, 261);
		layeredPane.add(panel_3);
		panel_3.setLayout(null);
		
		list = new JList();
		list.setLocation(10, 5);
		list.setPreferredSize(new Dimension(200, 250));
		list.setSize(new Dimension(290, 250));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel_3.add(list);
		
		btnAddFood = new JButton("Add food");
		btnAddFood.setBounds(310, 27, 99, 23);
		panel_3.add(btnAddFood);
		
		btnRemoveFood = new JButton("Remove Food");
		btnRemoveFood.setBounds(310, 61, 99, 23);
		panel_3.add(btnRemoveFood);
		
		panel_4 = new JPanel();
		layeredPane.setLayer(panel_4, 4);
		panel_4.setBounds(0, 0, 434, 261);
		layeredPane.add(panel_4);
		panel_4.setLayout(null);
		
		txtWeight_1 = new JTextField();
		txtWeight_1.setText("Weight");
		txtWeight_1.setBounds(233, 62, 86, 20);
		panel_4.add(txtWeight_1);
		txtWeight_1.setColumns(10);
		
		txtGoal = new JTextField();
		txtGoal.setText("Goal");
		txtGoal.setBounds(233, 172, 86, 20);
		panel_4.add(txtGoal);
		txtGoal.setColumns(10);
		
		JLabel lblYourCurrentWeight = new JLabel("Your current weight");
		lblYourCurrentWeight.setBounds(10, 65, 184, 14);
		panel_4.add(lblYourCurrentWeight);
		
		JLabel lblTheWeightYou = new JLabel("The weight you want to gain per week");
		lblTheWeightYou.setBounds(10, 175, 184, 14);
		panel_4.add(lblTheWeightYou);
		
		JLabel lblYourExcerciseLevel = new JLabel("Your excercise level");
		lblYourExcerciseLevel.setBounds(10, 120, 184, 14);
		panel_4.add(lblYourExcerciseLevel);
	}
}
