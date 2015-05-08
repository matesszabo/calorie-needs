package hu.unideb.inf.prt.calorie;

import java.util.List;

import hu.unideb.inf.prt.calorie.DAO.DAO;
import hu.unideb.inf.prt.calorie.Model.Diet_diary;
import hu.unideb.inf.prt.calorie.Model.Food;
import hu.unideb.inf.prt.calorie.Model.Person;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DAO dao = new DAO();
		List<Food> foodlist= dao.getFoodlist();
		
		for (Food food : foodlist) {
			System.out.println(food);
		}

		List<Person> personlist = dao.getPersonlist();
		
		for (Person person : personlist) {
			System.out.println(person);
		}
		
		List<Diet_diary> diarylist= dao.getDiet_diarylist();
		for (Diet_diary diet_diary : diarylist) {
			System.out.println(diet_diary);
		}
	}

}
