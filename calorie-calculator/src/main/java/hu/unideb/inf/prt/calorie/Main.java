package hu.unideb.inf.prt.calorie;

import java.time.LocalDate;
import java.util.List;

import org.joda.time.DateTime;

import hu.unideb.inf.prt.calorie.DAO.DAO;
import hu.unideb.inf.prt.calorie.Model.Calorie;
import hu.unideb.inf.prt.calorie.Model.Diet_diary;
import hu.unideb.inf.prt.calorie.Model.Food;
import hu.unideb.inf.prt.calorie.Model.Person;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DAO dao = new DAO();
		
		
		/*Person persontest= new Person(2, "test", "test");
		dao.insertUser(persontest);
		Diet_diary diary= new Diet_diary(1, 2, DateTime.now(), 300, "g", "reggeli", new Calorie(100.5,50.4, 20.9, 7.4), new Calorie(200, 100, 30, 15));
		dao.insertDiary(diary);*/
		/*Person person=dao.getPersonlist().get(1);
		person.setHeight(180);
		person.setWeight(90);
		person.setYear(30);
		person.setExcercise(3);
		person.setGender("nö");
		person.setGoal(0-1);
		dao.updateUser(person);
		
		Food somefood=dao.getFoodlist().get(2);
		somefood.setName(somefood.getName()+"átírtam");
		dao.updateFood(somefood);*/
		
		List<Food> foodlist= dao.getFoodlist();
		
		for (Food food : foodlist) {
			System.out.println(food);
		}

		List<Person> personlist = dao.getPersonlist();
		
		for (Person ppl : personlist) {
			System.out.println(ppl);
		}
		
		List<Diet_diary> diarylist= dao.getDiet_diarylist();
		for (Diet_diary diet_diary : diarylist) {
			System.out.println(diet_diary);
		}
		
		System.out.println(dao.getDateByUserId(1));
		
		System.out.println(dao.getUserId("admin", "admin"));
	}

}
