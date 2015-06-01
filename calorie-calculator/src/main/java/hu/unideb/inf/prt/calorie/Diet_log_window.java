package hu.unideb.inf.prt.calorie;

import hu.unideb.inf.prt.calorie.Model.Diet_diary;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

public class Diet_log_window extends JPanel {
	public static JList<Diet_diary> list_1;

	/**
	 * 
	 */
	public Diet_log_window(JLayeredPane layeredPane) {
		setVisible(false);
		setBounds(0, 0, 444, 271);
		setLayout(null);
		
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
		
		add(scrollPane2);
		
		JButton btnBack_2 = new JButton("Back");
		btnBack_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				View.ActivateLayer(2, layeredPane);
			}
		});
		btnBack_2.setBounds(317, 239, 89, 23);
		add(btnBack_2);
	}
	
	
	
	
	

}
