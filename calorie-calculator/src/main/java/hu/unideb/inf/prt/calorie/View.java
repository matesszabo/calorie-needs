package hu.unideb.inf.prt.calorie;

import hu.unideb.inf.prt.calorie.Model.Food;
import hu.unideb.inf.prt.calorie.Service.Service;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
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

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Vector;
import javax.swing.ScrollPaneConstants;

public class View {

	private JFrame frame;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JButton btnLogIn;
	private JButton btnRegister;
	private JPanel panel_1;
	private JTextField txtUsername_1;
	private JPasswordField txtPassword_1;
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
	private JList<Food> list;
	private JButton btnAddFood;
	private JButton btnRemoveFood;
	private JPanel panel_4;
	private JTextField txtWeight_1;
	private JTextField txtGoal;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;

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
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		layeredPane.add(panel);
		panel.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					Service service= new Service();
					if(service.existsUser(txtUsername.getText(), txtPassword.getText()))
					ActivateLayer(2, layeredPane);
					else{
						txtUsername.setText("Try again");
						txtPassword.setText("Try again");
					}
				}
			}
		});
		txtUsername.setBounds(81, 122, 86, 20);
		txtUsername.setText("Username");
		panel.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					Service service= new Service();
					if(service.existsUser(txtUsername.getText(), txtPassword.getText()))
					ActivateLayer(2, layeredPane);
					else{
						txtUsername.setText("Try again");
						txtPassword.setText("Try again");
					}
				}
			}
		});
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
				Service service= new Service();
				if(service.existsUser(txtUsername.getText(), txtPassword.getText()))
				ActivateLayer(2, layeredPane);
				else{
					txtUsername.setText("Try again");
					txtPassword.setText("Try again");
				}
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
		
		txtPassword_1 = new JPasswordField();
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
		btnRegister_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Service service= new Service();
				if(!service.existsUserByUname(txtUsername_1.getText()))
				ActivateLayer(0, layeredPane);
				else{
					txtUsername_1.setText("Reserved");
				}
			}
		});
		btnRegister_1.setBounds(65, 152, 89, 23);
		panel_1.add(btnRegister_1);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ActivateLayer(0, layeredPane);
			}
		});
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
		btnChangeData.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ActivateLayer(4, layeredPane);
			}
		});
		btnChangeData.setBounds(110, 27, 118, 23);
		panel_2.add(btnChangeData);
		
		JButton btnAddMeal = new JButton("Add meal");
		btnAddMeal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ActivateLayer(5, layeredPane);
			}
		});
		btnAddMeal.setBounds(335, 11, 89, 23);
		panel_2.add(btnAddMeal);
		
		JButton btnStatistics = new JButton("Statistics");
		btnStatistics.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ActivateLayer(6, layeredPane);
			}
		});
		btnStatistics.setBounds(335, 45, 89, 23);
		panel_2.add(btnStatistics);
		
		JButton btnRecipes = new JButton("Recipes");
		btnRecipes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Service service=new Service();
				List<Food>tmp=service.getFoodListByUserId(1);
				System.out.println(tmp.size());
				list.setListData(tmp.toArray(new Food[tmp.size()]));
				ActivateLayer(3, layeredPane);
			}
		});
		btnRecipes.setBounds(10, 11, 89, 39);
		panel_2.add(btnRecipes);
		
		JButton btnFoodLog = new JButton("Food log");
		btnFoodLog.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ActivateLayer(7, layeredPane);
			}
		});
		btnFoodLog.setBounds(50, 220, 89, 23);
		panel_2.add(btnFoodLog);
		
		JPanel panel_3 = new JPanel();
		panel_3.setVisible(false);
		layeredPane.setLayer(panel_3, 3);
		panel_3.setBounds(0, 0, 434, 261);
		layeredPane.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setAutoscrolls(true);
		scrollPane.setBounds(0, 0, 434, 225);
		scrollPane.setWheelScrollingEnabled(true);
		//scrollPane.setPreferredSize(preferredSize);
		list = new JList<Food>();
		list.setAutoscrolls(true);
		list.setLocation(10, 5);
		list.setPreferredSize(null);
		//list.setSize(new Dimension(290, 250));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.add(list);
		System.out.println(list.getModel().getSize());
		scrollPane.setViewportView(list);
		scrollPane.setVisible(true);
		panel_3.add(scrollPane);
		
		btnAddFood = new JButton("Add food");
		btnAddFood.setBounds(310, 27, 99, 23);
		panel_3.add(btnAddFood);
		
		btnRemoveFood = new JButton("Remove Food");
		btnRemoveFood.setBounds(310, 61, 99, 23);
		panel_3.add(btnRemoveFood);
		
		JButton btnBack_1 = new JButton("Back");
		btnBack_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ActivateLayer(2, layeredPane);
			}
		});
		btnBack_1.setBounds(310, 95, 99, 23);
		panel_3.add(btnBack_1);
		
		panel_4 = new JPanel();
		panel_4.setVisible(false);
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
		lblYourCurrentWeight.setBounds(10, 65, 150, 14);
		panel_4.add(lblYourCurrentWeight);
		
		JLabel lblTheWeightYou = new JLabel("Weight to gain per week");
		lblTheWeightYou.setBounds(10, 175, 150, 14);
		panel_4.add(lblTheWeightYou);
		
		JLabel lblYourExcerciseLevel = new JLabel("Your excercise level");
		lblYourExcerciseLevel.setBounds(10, 120, 150, 14);
		panel_4.add(lblYourExcerciseLevel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Little to no excercise", "Light excercise(1-3 days per week)", "Moderate excercise(3-5 days per week)", "Heavy excercise(6-7 days per week)", "Very heavy excercise(twice per day, extra heavy workouts)"}));
		comboBox.setBounds(180, 114, 225, 20);
		panel_4.add(comboBox);
		
		JButton btnOkay = new JButton("Okay");
		btnOkay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ActivateLayer(2, layeredPane);
			}
		});
		btnOkay.setBounds(100, 220, 89, 23);
		panel_4.add(btnOkay);
		
		JButton btnCancel_2 = new JButton("Cancel");
		btnCancel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ActivateLayer(2, layeredPane);
			}
		});
		btnCancel_2.setBounds(225, 220, 89, 23);
		panel_4.add(btnCancel_2);
		
		JPanel panel_5 = new JPanel();
		panel_5.setVisible(false);
		layeredPane.setLayer(panel_5, 5);
		panel_5.setBounds(0, 0, 434, 261);
		layeredPane.add(panel_5);
		panel_5.setLayout(null);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Breakfast", "Lunch", "Dinner", "Snack", "Other"}));
		comboBox_1.setBounds(10, 91, 105, 50);
		panel_5.add(comboBox_1);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setBounds(159, 93, 265, 50);
		panel_5.add(comboBox_2);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(182, 203, 89, 23);
		panel_5.add(btnAdd);
		
		JButton btnCancel_1 = new JButton("Cancel");
		btnCancel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ActivateLayer(2, layeredPane);
			}
		});
		btnCancel_1.setBounds(308, 203, 89, 23);
		panel_5.add(btnCancel_1);
		
		JPanel panel_6 = new JPanel();
		panel_6.setVisible(false);
		layeredPane.setLayer(panel_6, 6);
		panel_6.setBounds(0, 0, 444, 271);
		layeredPane.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblAverage = new JLabel("Average");
		lblAverage.setBounds(40, 68, 95, 14);
		panel_6.add(lblAverage);
		
		JLabel lblCalorie = new JLabel("Calorie");
		lblCalorie.setBounds(68, 93, 67, 14);
		panel_6.add(lblCalorie);
		
		JLabel lblCarbohydrate_1 = new JLabel("Carbohydrate");
		lblCarbohydrate_1.setBounds(68, 118, 78, 14);
		panel_6.add(lblCarbohydrate_1);
		
		JLabel lblProtein_1 = new JLabel("Protein");
		lblProtein_1.setBounds(68, 143, 67, 14);
		panel_6.add(lblProtein_1);
		
		JLabel lblFat_1 = new JLabel("Fat");
		lblFat_1.setBounds(68, 168, 67, 14);
		panel_6.add(lblFat_1);
		
		JLabel lblCalorieInPercent = new JLabel("Calorie in percent");
		lblCalorieInPercent.setBounds(168, 93, 124, 14);
		panel_6.add(lblCalorieInPercent);
		
		JLabel lblCarbohydrateInPercent = new JLabel("Carbohydrate in percent");
		lblCarbohydrateInPercent.setBounds(168, 118, 149, 14);
		panel_6.add(lblCarbohydrateInPercent);
		
		JLabel lblProteinInPercent = new JLabel("Protein in percent");
		lblProteinInPercent.setBounds(168, 143, 124, 14);
		panel_6.add(lblProteinInPercent);
		
		JLabel lblFatInPercent = new JLabel("Fat in percent");
		lblFatInPercent.setBounds(168, 168, 124, 14);
		panel_6.add(lblFatInPercent);
		
		JLabel lblPercentOfFoods = new JLabel("Percent of foods");
		lblPercentOfFoods.setBounds(168, 68, 124, 14);
		panel_6.add(lblPercentOfFoods);
		
		JLabel lblAverageWeight = new JLabel("Average weight");
		lblAverageWeight.setBounds(40, 214, 95, 14);
		panel_6.add(lblAverageWeight);
		
		JLabel lblSinceTheRegistration = new JLabel("Since the registration");
		lblSinceTheRegistration.setBounds(145, 214, 124, 14);
		panel_6.add(lblSinceTheRegistration);
		
		JLabel lblWeightOnThe = new JLabel("Weight on the specified date");
		lblWeightOnThe.setBounds(40, 23, 167, 14);
		panel_6.add(lblWeightOnThe);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(217, 20, 138, 20);
		panel_6.add(comboBox_3);
		
		JLabel lblWeight_1 = new JLabel("Weight");
		lblWeight_1.setBounds(365, 23, 46, 14);
		panel_6.add(lblWeight_1);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ActivateLayer(2, layeredPane);
			}
		});
		btnBack.setBounds(335, 227, 89, 23);
		panel_6.add(btnBack);
		
		JPanel panel_7 = new JPanel();
		panel_7.setVisible(false);
		layeredPane.setLayer(panel_7, 7);
		panel_7.setBounds(0, 0, 444, 271);
		layeredPane.add(panel_7);
		panel_7.setLayout(null);
		
		JList list_1 = new JList();
		list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_1.setBounds(10, 11, 424, 217);
		panel_7.add(list_1);
		
		JButton btnBack_2 = new JButton("Back");
		btnBack_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ActivateLayer(2, layeredPane);
			}
		});
		btnBack_2.setBounds(317, 239, 89, 23);
		panel_7.add(btnBack_2);
	}
}
