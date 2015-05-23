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
	}
}
