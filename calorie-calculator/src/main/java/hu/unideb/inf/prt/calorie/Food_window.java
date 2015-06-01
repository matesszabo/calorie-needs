/**
 * 
 */
package hu.unideb.inf.prt.calorie;

import hu.unideb.inf.prt.calorie.Model.Food;
import hu.unideb.inf.prt.calorie.Model.Person;
import hu.unideb.inf.prt.calorie.Service.Service;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

/**
 * @author mates
 *
 */
public class Food_window extends JPanel {
	public static JList<Food> list;
	private JButton btnAddFood;
	private JButton btnRemoveFood;
	public static int maxFoodId;
	/**
	 * 
	 */
	public Food_window(JLayeredPane layeredPane, Person person) {
		setVisible(false);
		setBounds(0, 0, 434, 261);
		setLayout(null);
		
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
		add(scrollPane);
		
		btnAddFood = new JButton("Add food");
		btnAddFood.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Service service= new Service();
				maxFoodId=service.getMaxFoodId();
				View.ActivateLayer(8, layeredPane);
			}
		});
		btnAddFood.setBounds(310, 27, 99, 23);
		add(btnAddFood);
		
		btnRemoveFood = new JButton("Remove Food");
		btnRemoveFood.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Service service = new Service();
				service.deleteFood(list.getSelectedValue(), View.person);
				List<Food>tmp=service.getFoodListByUserId(View.person.getId());
				System.out.println(tmp.size());
				list.setListData(tmp.toArray(new Food[tmp.size()]));
			}
		});
		btnRemoveFood.setBounds(310, 61, 99, 23);
		add(btnRemoveFood);
		
		JButton btnBack_1 = new JButton("Back");
		btnBack_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				View.ActivateLayer(2, layeredPane);
			}
		});
		btnBack_1.setBounds(310, 95, 99, 23);
		add(btnBack_1);
	}
	
	

}
