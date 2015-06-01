package hu.unideb.inf.prt.calorie;

import hu.unideb.inf.prt.calorie.Model.Calorie;
import hu.unideb.inf.prt.calorie.Model.Food;
import hu.unideb.inf.prt.calorie.Service.Service;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class New_food_window extends JPanel {
	private JTextField txtName;
	private JTextField txtCalorie;
	private JTextField txtCarbohydrate;
	private JTextField txtFat;
	private JTextField txtProtein;
	private JTextField txtQuantity;
	private JTextField txtUnit_1;

	/**
	 * 
	 */
	public New_food_window(JLayeredPane layeredPane) {

		
		setVisible(false);
		setBounds(0, 0, 444, 271);
		setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(63, 60, 87, 14);
		add(lblName);
		
		JLabel lblCalorie_1 = new JLabel("Calorie");
		lblCalorie_1.setBounds(63, 85, 87, 14);
		add(lblCalorie_1);
		
		JLabel lblCarbohydrate_2 = new JLabel("Carbohydrate");
		lblCarbohydrate_2.setBounds(63, 110, 87, 14);
		add(lblCarbohydrate_2);
		
		JLabel lblFat_2 = new JLabel("Fat");
		lblFat_2.setBounds(63, 135, 46, 14);
		add(lblFat_2);
		
		JLabel lblProtein_2 = new JLabel("Protein");
		lblProtein_2.setBounds(63, 160, 87, 14);
		add(lblProtein_2);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(63, 185, 87, 14);
		add(lblQuantity);
		
		JLabel lblUnit_1 = new JLabel("Unit");
		lblUnit_1.setBounds(63, 210, 46, 14);
		add(lblUnit_1);
		
		txtName = new JTextField();
		txtName.setText("Name");
		txtName.setBounds(160, 57, 178, 20);
		add(txtName);
		txtName.setColumns(10);
		
		txtCalorie = new JTextField();
		txtCalorie.setText("Calorie");
		txtCalorie.setBounds(160, 82, 86, 20);
		add(txtCalorie);
		txtCalorie.setColumns(10);
		
		txtCarbohydrate = new JTextField();
		txtCarbohydrate.setText("Carbohydrate");
		txtCarbohydrate.setBounds(160, 107, 86, 20);
		add(txtCarbohydrate);
		txtCarbohydrate.setColumns(10);
		
		txtFat = new JTextField();
		txtFat.setText("Fat");
		txtFat.setBounds(160, 132, 86, 20);
		add(txtFat);
		txtFat.setColumns(10);
		
		txtProtein = new JTextField();
		txtProtein.setText("Protein");
		txtProtein.setBounds(160, 157, 86, 20);
		add(txtProtein);
		txtProtein.setColumns(10);
		
		txtQuantity = new JTextField();
		txtQuantity.setText("Quantity");
		txtQuantity.setBounds(160, 182, 86, 20);
		add(txtQuantity);
		txtQuantity.setColumns(10);
		
		txtUnit_1 = new JTextField();
		txtUnit_1.setText("Unit");
		txtUnit_1.setBounds(160, 207, 86, 20);
		add(txtUnit_1);
		txtUnit_1.setColumns(10);
		
		JButton btnAdd_1 = new JButton("Add");
		btnAdd_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Service service=new Service();
				service.insertFood(new Food(Food_window.maxFoodId+1, View.person.getId(), txtName.getText(), new Calorie(Double.parseDouble(txtCalorie.getText()) , Double.parseDouble(txtCarbohydrate.getText()), Double.parseDouble(txtFat.getText()), Double.parseDouble(txtProtein.getText())), Double.parseDouble(txtQuantity.getText()), txtUnit_1.getText()));
				List<Food>tmp=service.getFoodListByUserId(View.person.getId());
				Food_window.list.setListData(tmp.toArray(new Food[tmp.size()]));
				View.ActivateLayer(3, layeredPane);
			}
		});
		btnAdd_1.setBounds(332, 181, 89, 23);
		add(btnAdd_1);
		
		JButton btnBack_3 = new JButton("Back");
		btnBack_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				View.ActivateLayer(3, layeredPane);
			}
		});
		btnBack_3.setBounds(332, 206, 89, 23);
		add(btnBack_3);
	}
	

}
