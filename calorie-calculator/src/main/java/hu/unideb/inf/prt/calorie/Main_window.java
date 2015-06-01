/**
 * 
 */
package hu.unideb.inf.prt.calorie;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import hu.unideb.inf.prt.calorie.Model.Calorie;
import hu.unideb.inf.prt.calorie.Model.Diet_diary;
import hu.unideb.inf.prt.calorie.Model.Food;
import hu.unideb.inf.prt.calorie.Model.Person;
import hu.unideb.inf.prt.calorie.Model.Person_date;
import hu.unideb.inf.prt.calorie.Service.Service;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import org.joda.time.DateTime;

/**
 * @author mates
 *
 */
public class Main_window extends JPanel {
	public static JProgressBar progressBar;
	public static JProgressBar progressBar_1;
	public static JProgressBar progressBar_2;
	public static JProgressBar progressBar_3;
	public static JLabel label;
	public static JLabel label_1;
	public static JLabel label_2;
	public static JLabel label_3;
	public static Map<DateTime,Double>weightmap;
	public static JLabel lblNormal;
	/**
	 * 
	 */
	public Main_window(JLayeredPane layeredPane,Person person) {
		setVisible(false);
		setBounds(0, 0, 434, 261);
		setLayout(null);
		
		
		JLabel lblCalories = new JLabel("Calories");
		lblCalories.setBounds(10, 86, 56, 14);
		add(lblCalories);
		
		JLabel lblCarbohydrate = new JLabel("Carbohydrate");
		lblCarbohydrate.setBounds(10, 116, 72, 14);
		add(lblCarbohydrate);
		
		JLabel lblProtein = new JLabel("Protein");
		lblProtein.setBounds(10, 146, 46, 14);
		add(lblProtein);
		
		JLabel lblFat = new JLabel("Fat");
		lblFat.setBounds(10, 176, 46, 14);
		add(lblFat);
		
		progressBar = new JProgressBar();
		progressBar.setBounds(110, 86, 190, 14);
		add(progressBar);
		
		progressBar_1 = new JProgressBar();
		progressBar_1.setBounds(110, 116, 190, 14);
		add(progressBar_1);
		
		progressBar_2 = new JProgressBar();
		progressBar_2.setBounds(110, 146, 190, 14);
		add(progressBar_2);
		
		progressBar_3 = new JProgressBar();
		progressBar_3.setBounds(110, 176, 190, 14);
		add(progressBar_3);
		
		label = new JLabel("0/0");
		label.setBounds(320, 86, 104, 14);
		add(label);
		
		label_1=new JLabel("0/0");
		label_1.setBounds(320, 116, 104, 14);
		add(label_1);
		
		label_2 = new JLabel("0/0");
		label_2.setBounds(320, 146, 104, 14);
		add(label_2);
		
		label_3 = new JLabel("0/0");
		label_3.setBounds(320, 176, 104, 14);
		add(label_3);
		
		JLabel lblCurrentHealthStatus = new JLabel("Current health status:");
		lblCurrentHealthStatus.setBounds(110, 61, 130, 14);
		add(lblCurrentHealthStatus);
		
		JButton btnChangeData = new JButton("Change data");
		btnChangeData.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Service service = new Service();
				Person_date pd=service.getCurrentInfoByUser(View.person.getId());
				Change_data_window.txtWeight_1.setText(pd.getWeight()+"");
				Change_data_window.txtGoal.setText(pd.getGoal()+"");
				switch (pd.getExcercise()) {
				case 1:
					Change_data_window.comboBox.setSelectedIndex(0);
					break;
				case 2:
					Change_data_window.comboBox.setSelectedIndex(1);
					break;
				case 3:
					Change_data_window.comboBox.setSelectedIndex(2);
					break;
				case 4:
					Change_data_window.comboBox.setSelectedIndex(3);
					break;
				case 5:
					Change_data_window.comboBox.setSelectedIndex(4);
					break;
				}
				View.ActivateLayer(4, layeredPane);
			}
		});
		btnChangeData.setBounds(110, 27, 118, 23);
		add(btnChangeData);
		
		JButton btnAddMeal = new JButton("Add meal");
		btnAddMeal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Service service=new Service();
				List<Food>tmp=service.getFoodListByUserId(View.person.getId());
				Meal_manager.comboBox_2.setModel(new DefaultComboBoxModel<Food>(tmp.toArray(new Food[tmp.size()])));
				View.ActivateLayer(5, layeredPane);
			}
		});
		btnAddMeal.setBounds(335, 11, 89, 23);
		add(btnAddMeal);
		
		JButton btnStatistics = new JButton("Statistics");
		btnStatistics.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Service service=new Service();
				List<DateTime>tmp=new ArrayList<DateTime>();
				weightmap=service.getWeightMapById(View.person.getId());
				for(DateTime date:weightmap.keySet()){
					tmp.add(date);
				}
				
				Statistics_window.comboBox_3.setModel(new DefaultComboBoxModel<DateTime>(tmp.toArray(new DateTime[tmp.size()])));
				Statistics_window.lblWeight_1.setText(weightmap.get(Statistics_window.comboBox_3.getSelectedItem()).toString());
				Calorie tmp2=service.getAverageCalorieByUser(View.person.getId());
				Statistics_window.lblCalorieInPercent.setText(tmp2.getKcal()+"");
				Statistics_window.lblCarbohydrateInPercent.setText(tmp2.getCarbohydrate()+"");
				Statistics_window.lblFatInPercent.setText(tmp2.getFat()+"");
				Statistics_window.lblProteinInPercent.setText(tmp2.getProtein()+"");
				Statistics_window.lblSinceTheRegistration.setText(service.getAverageWeightByUser(View.person.getId())+"");
				View.ActivateLayer(6, layeredPane);
			}
		});
		btnStatistics.setBounds(335, 45, 89, 23);
		add(btnStatistics);
		
		JButton btnRecipes = new JButton("Recipes");
		btnRecipes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Service service=new Service();
				
				List<Food>tmp=service.getFoodListByUserId(View.person.getId());
				System.out.println(tmp.size());
				Food_window.list.setListData(tmp.toArray(new Food[tmp.size()]));
				View.ActivateLayer(3, layeredPane);
			}
		});
		btnRecipes.setBounds(10, 11, 89, 39);
		add(btnRecipes);
		
		JButton btnFoodLog = new JButton("Food log");
		btnFoodLog.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Service service=new Service();
				List<Diet_diary>tmp=service.getDietDiaryByUserId(View.person.getId());
				Diet_log_window.list_1.setListData(tmp.toArray(new Diet_diary[tmp.size()]));
				View.ActivateLayer(7, layeredPane);
			}
		});
		btnFoodLog.setBounds(50, 220, 89, 23);
		add(btnFoodLog);
		
		lblNormal = new JLabel("Normal");
		lblNormal.setBounds(260, 61, 150, 14);
		add(lblNormal);
		
	}
	

}
