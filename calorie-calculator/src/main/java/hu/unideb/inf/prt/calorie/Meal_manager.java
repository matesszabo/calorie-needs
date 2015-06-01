package hu.unideb.inf.prt.calorie;

import hu.unideb.inf.prt.calorie.Model.Calorie;
import hu.unideb.inf.prt.calorie.Model.Diet_diary;
import hu.unideb.inf.prt.calorie.Model.Food;
import hu.unideb.inf.prt.calorie.Service.Service;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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

public class Meal_manager extends JPanel {
	private JComboBox comboBox_1;
	public static JComboBox<Food> comboBox_2;
	private JTextField txtUnit;
	private JLabel lblUnit ;

	/**
	 * 
	 */
	public Meal_manager(JLayeredPane layeredPane) {
		
		
		setVisible(false);
		setBounds(0, 0, 434, 261);
		setLayout(null);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Breakfast", "Lunch", "Dinner", "Snack", "Other"}));
		comboBox_1.setBounds(10, 91, 105, 50);
		add(comboBox_1);
		
		comboBox_2 = new JComboBox();
		comboBox_2.addItemListener(new ItemListener() {
			 public void itemStateChanged(ItemEvent arg0) {
				 lblUnit.setText(((Food)comboBox_2.getSelectedItem()).getUnit());
			}
		});
		comboBox_2.setBounds(159, 93, 265, 50);
		add(comboBox_2);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Service service=new Service();
				
				View.fulfilled=new Calorie(View.fulfilled.getKcal()+((Food)comboBox_2.getSelectedItem()).getCalorie().getKcal(), View.fulfilled.getCarbohydrate()+((Food)comboBox_2.getSelectedItem()).getCalorie().getCarbohydrate(), View.fulfilled.getFat()+((Food)comboBox_2.getSelectedItem()).getCalorie().getFat(), View.fulfilled.getProtein()+((Food)comboBox_2.getSelectedItem()).getCalorie().getProtein());
				service.insertDietDiary(new Diet_diary(View.person.getId(), ((Food)comboBox_2.getSelectedItem()).getId(), DateTime.now(), Double.parseDouble(txtUnit.getText()), lblUnit.getText(), (String)comboBox_1.getSelectedItem(), new Calorie(View.person.getNeeds().getKcal(), View.person.getNeeds().getCarbohydrate(), View.person.getNeeds().getFat(), View.person.getNeeds().getProtein()), new Calorie(View.fulfilled.getKcal(),View.fulfilled.getCarbohydrate(),View.fulfilled.getFat(),View.fulfilled.getProtein())));
				Main_window.progressBar.setValue((int)(View.fulfilled.getKcal()/View.person.getNeeds().getKcal()*100));
				Main_window.progressBar_1.setValue((int)(View.fulfilled.getCarbohydrate()/View.person.getNeeds().getCarbohydrate()*100));
				Main_window.progressBar_3.setValue((int)(View.fulfilled.getFat()/View.person.getNeeds().getFat()*100));
				Main_window.progressBar_2.setValue((int)(View.fulfilled.getProtein()/View.person.getNeeds().getProtein()*100));
				Main_window.label.setText(View.fulfilled.getKcal()+"/"+(int)View.person.getNeeds().getKcal());
				Main_window.label_1.setText(View.fulfilled.getCarbohydrate()+"/"+(int)View.person.getNeeds().getCarbohydrate());
				Main_window.label_2.setText(View.fulfilled.getProtein()+"/"+(int)View.person.getNeeds().getProtein());
				Main_window.label_3.setText(View.fulfilled.getFat()+"/"+(int)View.person.getNeeds().getFat());
				View.ActivateLayer(2, layeredPane);
			}
		});
		btnAdd.setBounds(182, 203, 89, 23);
		add(btnAdd);
		
		JButton btnCancel_1 = new JButton("Cancel");
		btnCancel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				View.ActivateLayer(2, layeredPane);
			}
		});
		btnCancel_1.setBounds(308, 203, 89, 23);
		add(btnCancel_1);
		
		txtUnit = new JTextField();
		txtUnit.setText("0");
		txtUnit.setBounds(182, 154, 86, 20);
		add(txtUnit);
		txtUnit.setColumns(10);
		
		lblUnit = new JLabel("Unit");
		lblUnit.setBounds(308, 154, 46, 20);
		add(lblUnit);
		
	}
	
	

}
