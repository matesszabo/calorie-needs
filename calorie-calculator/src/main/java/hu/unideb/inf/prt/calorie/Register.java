package hu.unideb.inf.prt.calorie;

import hu.unideb.inf.prt.calorie.Model.Calorie;
import hu.unideb.inf.prt.calorie.Model.Person;
import hu.unideb.inf.prt.calorie.Model.Person_date;
import hu.unideb.inf.prt.calorie.Service.Service;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Register extends JPanel {
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

	/**
	 * Create the panel.
	 */
	public Register(JLayeredPane layeredPane) {
		
		
		setVisible(false);
		
		setBounds(0, 0, 434, 261);
		setLayout(null);
		
		txtUsername_1 = new JTextField();
		txtUsername_1.setEnabled(true);
		txtUsername_1.setEditable(true);
		txtUsername_1.setText("Username");
		txtUsername_1.setBounds(94, 60, 86, 20);
		add(txtUsername_1);
		txtUsername_1.setColumns(10);
		
		txtPassword_1 = new JPasswordField();
		txtPassword_1.setText("Password");
		txtPassword_1.setBounds(94, 101, 86, 20);
		add(txtPassword_1);
		txtPassword_1.setColumns(10);
		
		txtHeight = new JTextField();
		txtHeight.setText("Height");
		txtHeight.setBounds(311, 60, 86, 20);
		add(txtHeight);
		txtHeight.setColumns(10);
		
		txtBorn = new JTextField();
		txtBorn.setText("Born");
		txtBorn.setBounds(311, 101, 86, 20);
		add(txtBorn);
		txtBorn.setColumns(10);
		
		txtGender = new JTextField();
		txtGender.setText("Gender");
		txtGender.setBounds(311, 139, 86, 20);
		add(txtGender);
		txtGender.setColumns(10);
		
		txtWeight = new JTextField();
		txtWeight.setText("Weight");
		txtWeight.setBounds(311, 178, 86, 20);
		add(txtWeight);
		txtWeight.setColumns(10);
		
		lblUsername_1 = new JLabel("Username");
		lblUsername_1.setBounds(10, 63, 74, 14);
		add(lblUsername_1);
		
		lblPassword_1 = new JLabel("Password");
		lblPassword_1.setBounds(10, 104, 74, 14);
		add(lblPassword_1);
		
		lblHeight = new JLabel("Height");
		lblHeight.setBounds(230, 63, 71, 14);
		add(lblHeight);
		
		lblBorn = new JLabel("Born");
		lblBorn.setBounds(230, 104, 71, 14);
		add(lblBorn);
		
		lblGender = new JLabel("Gender");
		lblGender.setBounds(230, 142, 71, 14);
		add(lblGender);
		
		lblWeight = new JLabel("Weight");
		lblWeight.setBounds(230, 181, 71, 14);
		add(lblWeight);
		
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
					View.ActivateLayer(0, layeredPane);
					service.registerUser(tmp);
					service.insertUserDiary(tmp);
				}
				else{
					txtUsername_1.setText("Reserved");
				}
			}
		});
		btnRegister_1.setBounds(65, 152, 89, 23);
		add(btnRegister_1);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				View.ActivateLayer(0, layeredPane);
			}
		});
		btnCancel.setBounds(65, 186, 89, 23);
		add(btnCancel);

	}

}
