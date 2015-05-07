package hu.unideb.inf.prt.calorie;

import java.util.List;

import hu.unideb.inf.prt.calorie.DAO.DAO;
import hu.unideb.inf.prt.calorie.Model.Food;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DAO dao = new DAO();
		List<Food> foodlist= dao.getFoodlist();
		
		for (Food food : foodlist) {
			System.out.println(food);
		}

	}

}
