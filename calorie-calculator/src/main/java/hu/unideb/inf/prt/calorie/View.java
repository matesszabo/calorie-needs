package hu.unideb.inf.prt.calorie;

import hu.unideb.inf.prt.calorie.Model.Calorie;
import hu.unideb.inf.prt.calorie.Model.Diet_diary;
import hu.unideb.inf.prt.calorie.Model.Food;
import hu.unideb.inf.prt.calorie.Model.Person;
import hu.unideb.inf.prt.calorie.Model.Person_date;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.ScrollPaneConstants;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

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
	private JComboBox<Food> comboBox_2;
	private JList<Diet_diary> list_1;
	private JComboBox<DateTime> comboBox_3;
	private Map<DateTime,Double>weightmap;
	private JLabel lblWeight_1;
	private JLabel lblCalorieInPercent;
	private JLabel lblCarbohydrateInPercent;
	private JLabel lblProteinInPercent;
	private JLabel lblFatInPercent;
	private JLabel lblSinceTheRegistration;
	private JComboBox comboBox;
	private JProgressBar progressBar;
	private JProgressBar progressBar_1;
	private JProgressBar progressBar_2;
	private JProgressBar progressBar_3;
	private Person person;
	private Calorie fulfilled;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel lblYourCurrentWeight;
	private JTextField txtUnit;
	private JLabel lblUnit ;
	private JLabel lblNormal;
	private JTextField txtName;
	private JTextField txtCalorie;
	private JTextField txtCarbohydrate;
	private JTextField txtFat;
	private JTextField txtProtein;
	private JTextField txtQuantity;
	private JTextField txtUnit_1;
	private int maxFoodId;
	
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
					Person tmp=service.existsUser(txtUsername.getText(), txtPassword.getText());
					
					if(tmp!=null){
					person=tmp;
					person.setBMI(service.calcBMI(person));
					person.setBMR(service.calcBMR(person));
					person.setNeeds(service.calcNeeds(person));
					fulfilled=service.getFulfilledCalories(person.getId());
					System.out.println(fulfilled.getFat());
					System.out.println(person.getNeeds().getFat());
					progressBar.setValue((int)(fulfilled.getKcal()/person.getNeeds().getKcal()*100));
					progressBar_1.setValue((int)(fulfilled.getCarbohydrate()/person.getNeeds().getCarbohydrate()*100));
					progressBar_3.setValue((int)(fulfilled.getFat()/person.getNeeds().getFat()*100));
					progressBar_2.setValue((int)(fulfilled.getProtein()/person.getNeeds().getProtein()*100));
					label.setText(fulfilled.getKcal()+"/"+(int)person.getNeeds().getKcal());
					label_1.setText(fulfilled.getCarbohydrate()+"/"+(int)person.getNeeds().getCarbohydrate());
					label_2.setText(fulfilled.getProtein()+"/"+(int)person.getNeeds().getProtein());
					label_3.setText(fulfilled.getFat()+"/"+(int)person.getNeeds().getFat());
					lblNormal.setText(service.calcHealthStatus(person));
					
					ActivateLayer(2, layeredPane);}
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
					Person tmp=service.existsUser(txtUsername.getText(), txtPassword.getText());
					if(tmp!=null){
						person=tmp;
						person.setBMI(service.calcBMI(person));
						person.setBMR(service.calcBMR(person));
						person.setNeeds(service.calcNeeds(person));
						fulfilled=service.getFulfilledCalories(person.getId());
						System.out.println(fulfilled.getFat());
						System.out.println(person.getNeeds().getFat());
						progressBar.setValue((int)(fulfilled.getKcal()/person.getNeeds().getKcal()*100));
						progressBar_1.setValue((int)(fulfilled.getCarbohydrate()/person.getNeeds().getCarbohydrate()*100));
						progressBar_3.setValue((int)(fulfilled.getFat()/person.getNeeds().getFat()*100));
						progressBar_2.setValue((int)(fulfilled.getProtein()/person.getNeeds().getProtein()*100));
						label.setText(fulfilled.getKcal()+"/"+(int)person.getNeeds().getKcal());
						label_1.setText(fulfilled.getCarbohydrate()+"/"+(int)person.getNeeds().getCarbohydrate());
						label_2.setText(fulfilled.getProtein()+"/"+(int)person.getNeeds().getProtein());
						label_3.setText(fulfilled.getFat()+"/"+(int)person.getNeeds().getFat());
						lblNormal.setText(service.calcHealthStatus(person));
					ActivateLayer(2, layeredPane);}
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
				Person tmp=service.existsUser(txtUsername.getText(), txtPassword.getText());
				if(tmp!=null){
					person=tmp;
					person.setBMI(service.calcBMI(person));
					person.setBMR(service.calcBMR(person));
					person.setNeeds(service.calcNeeds(person));
					fulfilled=service.getFulfilledCalories(person.getId());
					System.out.println(fulfilled.getFat());
					System.out.println(person.getNeeds().getFat());
					progressBar.setValue((int)(fulfilled.getKcal()/person.getNeeds().getKcal()*100));
					progressBar_1.setValue((int)(fulfilled.getCarbohydrate()/person.getNeeds().getCarbohydrate()*100));
					progressBar_3.setValue((int)(fulfilled.getFat()/person.getNeeds().getFat()*100));
					progressBar_2.setValue((int)(fulfilled.getProtein()/person.getNeeds().getProtein()*100));
					label.setText(fulfilled.getKcal()+"/"+(int)person.getNeeds().getKcal());
					label_1.setText(fulfilled.getCarbohydrate()+"/"+(int)person.getNeeds().getCarbohydrate());
					label_2.setText(fulfilled.getProtein()+"/"+(int)person.getNeeds().getProtein());
					label_3.setText(fulfilled.getFat()+"/"+(int)person.getNeeds().getFat());
					lblNormal.setText(service.calcHealthStatus(person));
				ActivateLayer(2, layeredPane);}
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
				{
					DateTimeFormatter fmt = DateTimeFormat.forPattern("dd-MMM-YY");
					DateTime dt = DateTime.parse(txtBorn.getText(), fmt);
					//String str = fmt.print(dt);
					Person tmp=new Person(service.getMaxPersonId()+1,Integer.parseInt(txtHeight.getText()) , dt, new Person_date(DateTime.now(), Double.parseDouble(txtWeight.getText()), 1, 0), txtGender.getText(), txtUsername_1.getText(), txtPassword_1.getText(), 0, 0, new Calorie(0,0,0,0));
					ActivateLayer(0, layeredPane);
					service.registerUser(tmp);
					service.insertUserDiary(tmp);
				}
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
		
		progressBar = new JProgressBar();
		progressBar.setBounds(110, 86, 190, 14);
		panel_2.add(progressBar);
		
		progressBar_1 = new JProgressBar();
		progressBar_1.setBounds(110, 116, 190, 14);
		panel_2.add(progressBar_1);
		
		progressBar_2 = new JProgressBar();
		progressBar_2.setBounds(110, 146, 190, 14);
		panel_2.add(progressBar_2);
		
		progressBar_3 = new JProgressBar();
		progressBar_3.setBounds(110, 176, 190, 14);
		panel_2.add(progressBar_3);
		
		label = new JLabel("0/0");
		label.setBounds(320, 86, 104, 14);
		panel_2.add(label);
		
		label_1=new JLabel("0/0");
		label_1.setBounds(320, 116, 104, 14);
		panel_2.add(label_1);
		
		label_2 = new JLabel("0/0");
		label_2.setBounds(320, 146, 104, 14);
		panel_2.add(label_2);
		
		label_3 = new JLabel("0/0");
		label_3.setBounds(320, 176, 104, 14);
		panel_2.add(label_3);
		
		JLabel lblCurrentHealthStatus = new JLabel("Current health status:");
		lblCurrentHealthStatus.setBounds(110, 61, 130, 14);
		panel_2.add(lblCurrentHealthStatus);
		
		JButton btnChangeData = new JButton("Change data");
		btnChangeData.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Service service = new Service();
				Person_date pd=service.getCurrentInfoByUser(person.getId());
				txtWeight_1.setText(pd.getWeight()+"");
				txtGoal.setText(pd.getGoal()+"");
				switch (pd.getExcercise()) {
				case 1:
					comboBox.setSelectedIndex(0);
					break;
				case 2:
					comboBox.setSelectedIndex(1);
					break;
				case 3:
					comboBox.setSelectedIndex(2);
					break;
				case 4:
					comboBox.setSelectedIndex(3);
					break;
				case 5:
					comboBox.setSelectedIndex(4);
					break;
				}
				ActivateLayer(4, layeredPane);
			}
		});
		btnChangeData.setBounds(110, 27, 118, 23);
		panel_2.add(btnChangeData);
		
		JButton btnAddMeal = new JButton("Add meal");
		btnAddMeal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Service service=new Service();
				List<Food>tmp=service.getFoodListByUserId(person.getId());
				comboBox_2.setModel(new DefaultComboBoxModel<Food>(tmp.toArray(new Food[tmp.size()])));
				ActivateLayer(5, layeredPane);
			}
		});
		btnAddMeal.setBounds(335, 11, 89, 23);
		panel_2.add(btnAddMeal);
		
		JButton btnStatistics = new JButton("Statistics");
		btnStatistics.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Service service=new Service();
				List<DateTime>tmp=new ArrayList<DateTime>();
				weightmap=service.getWeightMapById(person.getId());
				for(DateTime date:weightmap.keySet()){
					tmp.add(date);
				}
				
				comboBox_3.setModel(new DefaultComboBoxModel<DateTime>(tmp.toArray(new DateTime[tmp.size()])));
				lblWeight_1.setText(weightmap.get(comboBox_3.getSelectedItem()).toString());
				Calorie tmp2=service.getAverageCalorieByUser(person.getId());
				lblCalorieInPercent.setText(tmp2.getKcal()+"");
				lblCarbohydrateInPercent.setText(tmp2.getCarbohydrate()+"");
				lblFatInPercent.setText(tmp2.getFat()+"");
				lblProteinInPercent.setText(tmp2.getProtein()+"");
				lblSinceTheRegistration.setText(service.getAverageWeightByUser(person.getId())+"");
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
				List<Food>tmp=service.getFoodListByUserId(person.getId());
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
				Service service=new Service();
				List<Diet_diary>tmp=service.getDietDiaryByUserId(person.getId());
				list_1.setListData(tmp.toArray(new Diet_diary[tmp.size()]));
				ActivateLayer(7, layeredPane);
			}
		});
		btnFoodLog.setBounds(50, 220, 89, 23);
		panel_2.add(btnFoodLog);
		
		lblNormal = new JLabel("Normal");
		lblNormal.setBounds(260, 61, 150, 14);
		panel_2.add(lblNormal);
		
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
		scrollPane.setBounds(0, 0, 300, 260);
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
		btnAddFood.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Service service= new Service();
				maxFoodId=service.getMaxFoodId();
				ActivateLayer(8, layeredPane);
			}
		});
		btnAddFood.setBounds(310, 27, 99, 23);
		panel_3.add(btnAddFood);
		
		btnRemoveFood = new JButton("Remove Food");
		btnRemoveFood.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Service service = new Service();
				service.deleteFood(list.getSelectedValue(), person);
				List<Food>tmp=service.getFoodListByUserId(person.getId());
				System.out.println(tmp.size());
				list.setListData(tmp.toArray(new Food[tmp.size()]));
			}
		});
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
		
		lblYourCurrentWeight = new JLabel("Your current weight");
		lblYourCurrentWeight.setBounds(10, 65, 150, 14);
		panel_4.add(lblYourCurrentWeight);
		
		JLabel lblTheWeightYou = new JLabel("Weight to gain per week");
		lblTheWeightYou.setBounds(10, 175, 150, 14);
		panel_4.add(lblTheWeightYou);
		
		JLabel lblYourExcerciseLevel = new JLabel("Your excercise level");
		lblYourExcerciseLevel.setBounds(10, 120, 150, 14);
		panel_4.add(lblYourExcerciseLevel);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Little to no excercise", "Light excercise(1-3 days per week)", "Moderate excercise(3-5 days per week)", "Heavy excercise(6-7 days per week)", "Very heavy excercise(twice per day, extra heavy workouts)"}));
		comboBox.setBounds(180, 114, 225, 20);
		panel_4.add(comboBox);
		
		JButton btnOkay = new JButton("Okay");
		btnOkay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Service service=new Service();
				person.setDaily(new Person_date(DateTime.now(), Double.parseDouble(txtWeight_1.getText()), comboBox.getSelectedIndex()+1, Double.parseDouble(txtGoal.getText())));
				service.insertUserDiary(person);
				person.setBMI(service.calcBMI(person));
				person.setBMR(service.calcBMR(person));
				person.setNeeds(service.calcNeeds(person));
				progressBar.setValue((int)(fulfilled.getKcal()/person.getNeeds().getKcal()*100));
				progressBar_1.setValue((int)(fulfilled.getCarbohydrate()/person.getNeeds().getCarbohydrate()*100));
				progressBar_3.setValue((int)(fulfilled.getFat()/person.getNeeds().getFat()*100));
				progressBar_2.setValue((int)(fulfilled.getProtein()/person.getNeeds().getProtein()*100));
				label.setText(fulfilled.getKcal()+"/"+(int)person.getNeeds().getKcal());
				label_1.setText(fulfilled.getCarbohydrate()+"/"+(int)person.getNeeds().getCarbohydrate());
				label_2.setText(fulfilled.getProtein()+"/"+(int)person.getNeeds().getProtein());
				label_3.setText(fulfilled.getFat()+"/"+(int)person.getNeeds().getFat());
				lblNormal.setText(service.calcHealthStatus(person));
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
		comboBox_2.addItemListener(new ItemListener() {
			 public void itemStateChanged(ItemEvent arg0) {
				 lblUnit.setText(((Food)comboBox_2.getSelectedItem()).getUnit());
			}
		});
		comboBox_2.setBounds(159, 93, 265, 50);
		panel_5.add(comboBox_2);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Service service=new Service();
				
				fulfilled=new Calorie(fulfilled.getKcal()+((Food)comboBox_2.getSelectedItem()).getCalorie().getKcal(), fulfilled.getCarbohydrate()+((Food)comboBox_2.getSelectedItem()).getCalorie().getCarbohydrate(), fulfilled.getFat()+((Food)comboBox_2.getSelectedItem()).getCalorie().getFat(), fulfilled.getProtein()+((Food)comboBox_2.getSelectedItem()).getCalorie().getProtein());
				service.insertDietDiary(new Diet_diary(person.getId(), ((Food)comboBox_2.getSelectedItem()).getId(), DateTime.now(), Double.parseDouble(txtUnit.getText()), lblUnit.getText(), (String)comboBox_1.getSelectedItem(), new Calorie(person.getNeeds().getKcal(), person.getNeeds().getCarbohydrate(), person.getNeeds().getFat(), person.getNeeds().getProtein()), new Calorie(fulfilled.getKcal(),fulfilled.getCarbohydrate(),fulfilled.getFat(),fulfilled.getProtein())));
				progressBar.setValue((int)(fulfilled.getKcal()/person.getNeeds().getKcal()*100));
				progressBar_1.setValue((int)(fulfilled.getCarbohydrate()/person.getNeeds().getCarbohydrate()*100));
				progressBar_3.setValue((int)(fulfilled.getFat()/person.getNeeds().getFat()*100));
				progressBar_2.setValue((int)(fulfilled.getProtein()/person.getNeeds().getProtein()*100));
				label.setText(fulfilled.getKcal()+"/"+(int)person.getNeeds().getKcal());
				label_1.setText(fulfilled.getCarbohydrate()+"/"+(int)person.getNeeds().getCarbohydrate());
				label_2.setText(fulfilled.getProtein()+"/"+(int)person.getNeeds().getProtein());
				label_3.setText(fulfilled.getFat()+"/"+(int)person.getNeeds().getFat());
				ActivateLayer(2, layeredPane);
			}
		});
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
		
		txtUnit = new JTextField();
		txtUnit.setText("0");
		txtUnit.setBounds(182, 154, 86, 20);
		panel_5.add(txtUnit);
		txtUnit.setColumns(10);
		
		lblUnit = new JLabel("Unit");
		lblUnit.setBounds(308, 154, 46, 20);
		panel_5.add(lblUnit);
		
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
		
		lblCalorieInPercent = new JLabel("Calorie in percent");
		lblCalorieInPercent.setBounds(168, 93, 124, 14);
		panel_6.add(lblCalorieInPercent);
		
		lblCarbohydrateInPercent = new JLabel("Carbohydrate in percent");
		lblCarbohydrateInPercent.setBounds(168, 118, 149, 14);
		panel_6.add(lblCarbohydrateInPercent);
		
		lblProteinInPercent = new JLabel("Protein in percent");
		lblProteinInPercent.setBounds(168, 143, 124, 14);
		panel_6.add(lblProteinInPercent);
		
		lblFatInPercent = new JLabel("Fat in percent");
		lblFatInPercent.setBounds(168, 168, 124, 14);
		panel_6.add(lblFatInPercent);
		
		JLabel lblPercentOfFoods = new JLabel("Average per food");
		lblPercentOfFoods.setBounds(168, 68, 124, 14);
		panel_6.add(lblPercentOfFoods);
		
		JLabel lblAverageWeight = new JLabel("Average weight");
		lblAverageWeight.setBounds(40, 214, 95, 14);
		panel_6.add(lblAverageWeight);
		
		lblSinceTheRegistration = new JLabel("Since the registration");
		lblSinceTheRegistration.setBounds(145, 214, 124, 14);
		panel_6.add(lblSinceTheRegistration);
		
		JLabel lblWeightOnThe = new JLabel("Weight on the specified date");
		lblWeightOnThe.setBounds(40, 23, 167, 14);
		panel_6.add(lblWeightOnThe);
		
		comboBox_3 = new JComboBox();
		comboBox_3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				lblWeight_1.setText(weightmap.get(comboBox_3.getSelectedItem()).toString());			}
		});
		comboBox_3.setBounds(217, 20, 138, 20);
		panel_6.add(comboBox_3);
		
		lblWeight_1 = new JLabel("Weight");
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
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane2.setAutoscrolls(true);
		scrollPane2.setBounds(0, 0, 440, 220);
		scrollPane2.setWheelScrollingEnabled(true);
		
		list_1 = new JList<Diet_diary>();
		list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_1.setBounds(10, 11, 424, 217);
		
		list_1.setAutoscrolls(true);
		list_1.setPreferredSize(null);
		scrollPane2.add(list_1);
		scrollPane2.setViewportView(list_1);
		scrollPane2.setVisible(true);
		//panel_3.add(scrollPane);
		
		panel_7.add(scrollPane2);
		
		JButton btnBack_2 = new JButton("Back");
		btnBack_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ActivateLayer(2, layeredPane);
			}
		});
		btnBack_2.setBounds(317, 239, 89, 23);
		panel_7.add(btnBack_2);
		
		JPanel panel_8 = new JPanel();
		panel_8.setVisible(false);
		layeredPane.setLayer(panel_8, 8);
		panel_8.setBounds(0, 0, 444, 271);
		layeredPane.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(63, 60, 87, 14);
		panel_8.add(lblName);
		
		JLabel lblCalorie_1 = new JLabel("Calorie");
		lblCalorie_1.setBounds(63, 85, 87, 14);
		panel_8.add(lblCalorie_1);
		
		JLabel lblCarbohydrate_2 = new JLabel("Carbohydrate");
		lblCarbohydrate_2.setBounds(63, 110, 87, 14);
		panel_8.add(lblCarbohydrate_2);
		
		JLabel lblFat_2 = new JLabel("Fat");
		lblFat_2.setBounds(63, 135, 46, 14);
		panel_8.add(lblFat_2);
		
		JLabel lblProtein_2 = new JLabel("Protein");
		lblProtein_2.setBounds(63, 160, 87, 14);
		panel_8.add(lblProtein_2);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(63, 185, 87, 14);
		panel_8.add(lblQuantity);
		
		JLabel lblUnit_1 = new JLabel("Unit");
		lblUnit_1.setBounds(63, 210, 46, 14);
		panel_8.add(lblUnit_1);
		
		txtName = new JTextField();
		txtName.setText("Name");
		txtName.setBounds(160, 57, 178, 20);
		panel_8.add(txtName);
		txtName.setColumns(10);
		
		txtCalorie = new JTextField();
		txtCalorie.setText("Calorie");
		txtCalorie.setBounds(160, 82, 86, 20);
		panel_8.add(txtCalorie);
		txtCalorie.setColumns(10);
		
		txtCarbohydrate = new JTextField();
		txtCarbohydrate.setText("Carbohydrate");
		txtCarbohydrate.setBounds(160, 107, 86, 20);
		panel_8.add(txtCarbohydrate);
		txtCarbohydrate.setColumns(10);
		
		txtFat = new JTextField();
		txtFat.setText("Fat");
		txtFat.setBounds(160, 132, 86, 20);
		panel_8.add(txtFat);
		txtFat.setColumns(10);
		
		txtProtein = new JTextField();
		txtProtein.setText("Protein");
		txtProtein.setBounds(160, 157, 86, 20);
		panel_8.add(txtProtein);
		txtProtein.setColumns(10);
		
		txtQuantity = new JTextField();
		txtQuantity.setText("Quantity");
		txtQuantity.setBounds(160, 182, 86, 20);
		panel_8.add(txtQuantity);
		txtQuantity.setColumns(10);
		
		txtUnit_1 = new JTextField();
		txtUnit_1.setText("Unit");
		txtUnit_1.setBounds(160, 207, 86, 20);
		panel_8.add(txtUnit_1);
		txtUnit_1.setColumns(10);
		
		JButton btnAdd_1 = new JButton("Add");
		btnAdd_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Service service=new Service();
				service.insertFood(new Food(maxFoodId+1, person.getId(), txtName.getText(), new Calorie(Double.parseDouble(txtCalorie.getText()) , Double.parseDouble(txtCarbohydrate.getText()), Double.parseDouble(txtFat.getText()), Double.parseDouble(txtProtein.getText())), Double.parseDouble(txtQuantity.getText()), txtUnit_1.getText()));
				List<Food>tmp=service.getFoodListByUserId(person.getId());
				list.setListData(tmp.toArray(new Food[tmp.size()]));
				ActivateLayer(3, layeredPane);
			}
		});
		btnAdd_1.setBounds(332, 181, 89, 23);
		panel_8.add(btnAdd_1);
		
		JButton btnBack_3 = new JButton("Back");
		btnBack_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ActivateLayer(3, layeredPane);
			}
		});
		btnBack_3.setBounds(332, 206, 89, 23);
		panel_8.add(btnBack_3);
	}
}
