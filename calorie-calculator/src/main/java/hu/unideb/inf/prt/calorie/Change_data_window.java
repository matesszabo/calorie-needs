/**
 * 
 */
package hu.unideb.inf.prt.calorie;

import hu.unideb.inf.prt.calorie.Model.Person_date;
import hu.unideb.inf.prt.calorie.Service.Service;
import hu.unideb.inf.prt.calorie.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.joda.time.DateTime;

/**
 * @author mates
 *
 */
public class Change_data_window extends JPanel {

	public static JTextField txtWeight_1;
	public static JTextField txtGoal;
	public static JComboBox comboBox;
	private JLabel lblYourCurrentWeight;
	/**
	 * 
	 */
	public Change_data_window(JLayeredPane layeredPane) {
		setVisible(false);
		setBounds(0, 0, 434, 261);
		setLayout(null);
		
		txtWeight_1 = new JTextField();
		txtWeight_1.setText("Weight");
		txtWeight_1.setBounds(233, 62, 86, 20);
		add(txtWeight_1);
		txtWeight_1.setColumns(10);
		
		txtGoal = new JTextField();
		txtGoal.setText("Goal");
		txtGoal.setBounds(233, 172, 86, 20);
		add(txtGoal);
		txtGoal.setColumns(10);
		
		lblYourCurrentWeight = new JLabel("Your current weight");
		lblYourCurrentWeight.setBounds(10, 65, 150, 14);
		add(lblYourCurrentWeight);
		
		JLabel lblTheWeightYou = new JLabel("Weight to gain per week");
		lblTheWeightYou.setBounds(10, 175, 150, 14);
		add(lblTheWeightYou);
		
		JLabel lblYourExcerciseLevel = new JLabel("Your excercise level");
		lblYourExcerciseLevel.setBounds(10, 120, 150, 14);
		add(lblYourExcerciseLevel);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Little to no excercise", "Light excercise(1-3 days per week)", "Moderate excercise(3-5 days per week)", "Heavy excercise(6-7 days per week)", "Very heavy excercise(twice per day, extra heavy workouts)"}));
		comboBox.setBounds(180, 114, 225, 20);
		add(comboBox);
		
		JButton btnOkay = new JButton("Okay");
		btnOkay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Service service=new Service();
				View.person.setDaily(new Person_date(DateTime.now(), Double.parseDouble(txtWeight_1.getText()), comboBox.getSelectedIndex()+1, Double.parseDouble(txtGoal.getText())));
				service.insertUserDiary(View.person);
				View.person.setBMI(service.calcBMI(View.person));
				View.person.setBMR(service.calcBMR(View.person));
				View.person.setNeeds(service.calcNeeds(View.person));
				Main_window.progressBar.setValue((int)(View.fulfilled.getKcal()/View.person.getNeeds().getKcal()*100));
				Main_window.progressBar_1.setValue((int)(View.fulfilled.getCarbohydrate()/View.person.getNeeds().getCarbohydrate()*100));
				Main_window.progressBar_3.setValue((int)(View.fulfilled.getFat()/View.person.getNeeds().getFat()*100));
				Main_window.progressBar_2.setValue((int)(View.fulfilled.getProtein()/View.person.getNeeds().getProtein()*100));
				Main_window.label.setText(View.fulfilled.getKcal()+"/"+(int)View.person.getNeeds().getKcal());
				Main_window.label_1.setText(View.fulfilled.getCarbohydrate()+"/"+(int)View.person.getNeeds().getCarbohydrate());
				Main_window.label_2.setText(View.fulfilled.getProtein()+"/"+(int)View.person.getNeeds().getProtein());
				Main_window.label_3.setText(View.fulfilled.getFat()+"/"+(int)View.person.getNeeds().getFat());
				Main_window.lblNormal.setText(service.calcHealthStatus(View.person));
				View.ActivateLayer(2, layeredPane);
			}
		});
		btnOkay.setBounds(100, 220, 89, 23);
		add(btnOkay);
		
		JButton btnCancel_2 = new JButton("Cancel");
		btnCancel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				View.ActivateLayer(2, layeredPane);
			}
		});
		btnCancel_2.setBounds(225, 220, 89, 23);
		add(btnCancel_2);
		
	}
	

}
