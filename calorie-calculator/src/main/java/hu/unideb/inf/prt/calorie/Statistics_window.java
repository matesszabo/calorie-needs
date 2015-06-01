package hu.unideb.inf.prt.calorie;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import org.joda.time.DateTime;

public class Statistics_window extends JPanel {
	public static JLabel lblWeight_1;
	public static JLabel lblCalorieInPercent;
	public static JLabel lblCarbohydrateInPercent;
	public static JLabel lblProteinInPercent;
	public static JLabel lblFatInPercent;
	public static JLabel lblSinceTheRegistration;
	public static JComboBox<DateTime> comboBox_3;

	/**
	 * 
	 */
	public Statistics_window(JLayeredPane layeredPane) {
		
		setVisible(false);
		setBounds(0, 0, 444, 271);
		setLayout(null);
		
		JLabel lblAverage = new JLabel("Average");
		lblAverage.setBounds(40, 68, 95, 14);
		add(lblAverage);
		
		JLabel lblCalorie = new JLabel("Calorie");
		lblCalorie.setBounds(68, 93, 67, 14);
		add(lblCalorie);
		
		JLabel lblCarbohydrate_1 = new JLabel("Carbohydrate");
		lblCarbohydrate_1.setBounds(68, 118, 78, 14);
		add(lblCarbohydrate_1);
		
		JLabel lblProtein_1 = new JLabel("Protein");
		lblProtein_1.setBounds(68, 143, 67, 14);
		add(lblProtein_1);
		
		JLabel lblFat_1 = new JLabel("Fat");
		lblFat_1.setBounds(68, 168, 67, 14);
		add(lblFat_1);
		
		lblCalorieInPercent = new JLabel("Calorie in percent");
		lblCalorieInPercent.setBounds(168, 93, 124, 14);
		add(lblCalorieInPercent);
		
		lblCarbohydrateInPercent = new JLabel("Carbohydrate in percent");
		lblCarbohydrateInPercent.setBounds(168, 118, 149, 14);
		add(lblCarbohydrateInPercent);
		
		lblProteinInPercent = new JLabel("Protein in percent");
		lblProteinInPercent.setBounds(168, 143, 124, 14);
		add(lblProteinInPercent);
		
		lblFatInPercent = new JLabel("Fat in percent");
		lblFatInPercent.setBounds(168, 168, 124, 14);
		add(lblFatInPercent);
		
		JLabel lblPercentOfFoods = new JLabel("Average per food");
		lblPercentOfFoods.setBounds(168, 68, 124, 14);
		add(lblPercentOfFoods);
		
		JLabel lblAverageWeight = new JLabel("Average weight");
		lblAverageWeight.setBounds(40, 214, 95, 14);
		add(lblAverageWeight);
		
		lblSinceTheRegistration = new JLabel("Since the registration");
		lblSinceTheRegistration.setBounds(145, 214, 124, 14);
		add(lblSinceTheRegistration);
		
		JLabel lblWeightOnThe = new JLabel("Weight on the specified date");
		lblWeightOnThe.setBounds(40, 23, 167, 14);
		add(lblWeightOnThe);
		
		comboBox_3 = new JComboBox();
		comboBox_3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				lblWeight_1.setText(Main_window.weightmap.get(comboBox_3.getSelectedItem()).toString());			}
		});
		comboBox_3.setBounds(217, 20, 138, 20);
		add(comboBox_3);
		
		lblWeight_1 = new JLabel("Weight");
		lblWeight_1.setBounds(365, 23, 46, 14);
		add(lblWeight_1);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				View.ActivateLayer(2, layeredPane);
			}
		});
		btnBack.setBounds(335, 227, 89, 23);
		add(btnBack);
		
	}

	
}
