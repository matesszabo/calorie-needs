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
	/*private JTextField txtUsername_1;
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
	private JButton btnCancel;*/
	private JLayeredPane layeredPane;
	private JList<Food> list;
	private JButton btnAddFood;
	private JButton btnRemoveFood;
	private JPanel panel_4;
	//private JTextField txtWeight_1;
	//private JTextField txtGoal;
	//private JComboBox comboBox_1;
	//private JComboBox<Food> comboBox_2;
	//private JList<Diet_diary> list_1;
	//private JComboBox<DateTime> comboBox_3;
	public static Map<DateTime,Double>weightmap;
	/*private JLabel lblWeight_1;
	private JLabel lblCalorieInPercent;
	private JLabel lblCarbohydrateInPercent;
	private JLabel lblProteinInPercent;
	private JLabel lblFatInPercent;
	private JLabel lblSinceTheRegistration;*/
	//private JComboBox comboBox;
	/*private JProgressBar progressBar;
	private JProgressBar progressBar_1;
	private JProgressBar progressBar_2;
	private JProgressBar progressBar_3;*/
	public static Person person;
	public static Calorie fulfilled;
	/*private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;*/
	//private JLabel lblYourCurrentWeight;
	//private JTextField txtUnit;
	//private JLabel lblUnit ;
	//private JLabel lblNormal;
	/*private JTextField txtName;
	private JTextField txtCalorie;
	private JTextField txtCarbohydrate;
	private JTextField txtFat;
	private JTextField txtProtein;
	private JTextField txtQuantity;
	private JTextField txtUnit_1;*/
	private int maxFoodId;
	public Main_window panel_2 ;
	public Food_window panel_3;
	
	/**
	 * Launch the application.
	 */
	/**
	 * Activating layer with i parameter.
	 * @param i layer number
	 * @param layeredPane the layered panel
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
					panel_2.progressBar.setValue((int)(fulfilled.getKcal()/person.getNeeds().getKcal()*100));
					panel_2.progressBar_1.setValue((int)(fulfilled.getCarbohydrate()/person.getNeeds().getCarbohydrate()*100));
					panel_2.progressBar_3.setValue((int)(fulfilled.getFat()/person.getNeeds().getFat()*100));
					panel_2.progressBar_2.setValue((int)(fulfilled.getProtein()/person.getNeeds().getProtein()*100));
					panel_2.label.setText(fulfilled.getKcal()+"/"+(int)person.getNeeds().getKcal());
					panel_2.label_1.setText(fulfilled.getCarbohydrate()+"/"+(int)person.getNeeds().getCarbohydrate());
					panel_2.label_2.setText(fulfilled.getProtein()+"/"+(int)person.getNeeds().getProtein());
					panel_2.label_3.setText(fulfilled.getFat()+"/"+(int)person.getNeeds().getFat());
					panel_2.lblNormal.setText(service.calcHealthStatus(person));
					
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
						panel_2.progressBar.setValue((int)(fulfilled.getKcal()/person.getNeeds().getKcal()*100));
						panel_2.progressBar_1.setValue((int)(fulfilled.getCarbohydrate()/person.getNeeds().getCarbohydrate()*100));
						panel_2.progressBar_3.setValue((int)(fulfilled.getFat()/person.getNeeds().getFat()*100));
						panel_2.progressBar_2.setValue((int)(fulfilled.getProtein()/person.getNeeds().getProtein()*100));
						panel_2.label.setText(fulfilled.getKcal()+"/"+(int)person.getNeeds().getKcal());
						panel_2.label_1.setText(fulfilled.getCarbohydrate()+"/"+(int)person.getNeeds().getCarbohydrate());
						panel_2.label_2.setText(fulfilled.getProtein()+"/"+(int)person.getNeeds().getProtein());
						panel_2.label_3.setText(fulfilled.getFat()+"/"+(int)person.getNeeds().getFat());
						panel_2.lblNormal.setText(service.calcHealthStatus(person));
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
					panel_2.progressBar.setValue((int)(fulfilled.getKcal()/person.getNeeds().getKcal()*100));
					panel_2.progressBar_1.setValue((int)(fulfilled.getCarbohydrate()/person.getNeeds().getCarbohydrate()*100));
					panel_2.progressBar_3.setValue((int)(fulfilled.getFat()/person.getNeeds().getFat()*100));
					panel_2.progressBar_2.setValue((int)(fulfilled.getProtein()/person.getNeeds().getProtein()*100));
					panel_2.label.setText(fulfilled.getKcal()+"/"+(int)person.getNeeds().getKcal());
					panel_2.label_1.setText(fulfilled.getCarbohydrate()+"/"+(int)person.getNeeds().getCarbohydrate());
					panel_2.label_2.setText(fulfilled.getProtein()+"/"+(int)person.getNeeds().getProtein());
					panel_2.label_3.setText(fulfilled.getFat()+"/"+(int)person.getNeeds().getFat());
					panel_2.lblNormal.setText(service.calcHealthStatus(person));
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
		
		panel_1 = new Register(layeredPane);
		layeredPane.setLayer(panel_1, 1);
		layeredPane.add(panel_1);
		
		
		
		panel_2 = new Main_window(layeredPane, person);
		layeredPane.setLayer(panel_2, 2);
		layeredPane.add(panel_2);
		
		
		
		panel_3 = new Food_window(layeredPane, person);
		layeredPane.setLayer(panel_3, 3);
		layeredPane.add(panel_3);
		
		
		
		panel_4 = new Change_data_window(layeredPane);
		layeredPane.setLayer(panel_4, 4);
		layeredPane.add(panel_4);
	
		
		
		JPanel panel_5 = new Meal_manager(layeredPane);
		layeredPane.setLayer(panel_5, 5);
		layeredPane.add(panel_5);
		
		
		JPanel panel_6 = new Statistics_window(layeredPane);
		layeredPane.setLayer(panel_6, 6);
		layeredPane.add(panel_6);
		
		
		
		JPanel panel_7 = new Diet_log_window(layeredPane);
		layeredPane.setLayer(panel_7, 7);
		layeredPane.add(panel_7);
		
		
		
		
		JPanel panel_8 = new New_food_window(layeredPane);
		layeredPane.setLayer(panel_8, 8);
		layeredPane.add(panel_8);
		
		
	}
}
