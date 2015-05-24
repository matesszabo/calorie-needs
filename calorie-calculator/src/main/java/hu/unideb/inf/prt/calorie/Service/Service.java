package hu.unideb.inf.prt.calorie.Service;

import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;

import hu.unideb.inf.prt.calorie.DAO.DAO;
import hu.unideb.inf.prt.calorie.Model.Calorie;
import hu.unideb.inf.prt.calorie.Model.Diet_diary;
import hu.unideb.inf.prt.calorie.Model.Food;
import hu.unideb.inf.prt.calorie.Model.Person;

public class Service {
	
	/*
	 * A how old method would be great
	 */
	public void calcBMR(Person person){
		if(person.getGender().equals("férfi")){
			person.setBMR(66.473 +(13.7516*person.getDaily().getWeight())+(5.0033 *person.getHeight())-(6.7550 *(DateTime.now().minusYears(person.getBorn().getYear()).minusMonths(person.getBorn().getMonthOfYear()).minusDays(person.getBorn().getDayOfMonth()).getYear())));
		}else{
			person.setBMR(655.0955 +(9.5634 *person.getDaily().getWeight())+(1.8496  *person.getHeight())-(4.6756 *(DateTime.now().minusYears(person.getBorn().getYear()).minusMonths(person.getBorn().getMonthOfYear()).minusDays(person.getBorn().getDayOfMonth()).getYear())));
		}
	}
	
	public void calcBMI(Person person){
		person.setBMI(person.getDaily().getWeight()/Math.pow(((double)person.getHeight())/100, 2));
	}
	
	public void calcNeeds(Person person){
		if(person.getDaily().getExcercise()==1){
			Calorie calorie= new Calorie(person.getBMR()*1.2);
			calorie.setCarbohydrate(calorie.getKcal()*0.55);
			calorie.setProtein(calorie.getKcal()*0.15);
			calorie.setFat(calorie.getKcal()*0.3);
			person.setNeeds(calorie);
		}
	}
	
	public boolean existsUser(String uname, String passw){
		DAO dao= new DAO();
		return dao.getUserId(uname, passw)==-1?false:true;
	}
	
	public boolean existsUserByUname(String uname){
		DAO dao= new DAO();
		return dao.getUserIdByUname(uname)==-1?false:true;
	}
	
	public List<Food>getFoodListByUserId(int id){
		DAO dao= new DAO();
		return dao.getFoodlistByUser(id);
	}
	
	public List<Diet_diary>getDietDiaryByUserId(){
		DAO dao = new DAO();
		return dao.getDiet_diarylist();
	}
	
	public Map<DateTime,Double>getWeightMapById(int id){
		DAO dao= new DAO();
		return dao.getWeightByID(id);
	}
	
	public double[] getAverageByUserId(int id){
		DAO dao= new DAO();
		return dao.getAverageByUser(id);
	}
	
	public Calorie averageCalorie(List<Calorie>list){
		int i=0;
		Calorie calorie=new Calorie(0,0,0,0);
		for (Calorie calorie2 : list) {
			i++;
			calorie.setKcal(calorie.getKcal()+calorie2.getKcal());
			calorie.setCarbohydrate(calorie.getCarbohydrate()+calorie2.getCarbohydrate());
			calorie.setFat(calorie.getFat()+calorie2.getFat());
			calorie.setProtein(calorie.getProtein()+calorie2.getProtein());
		}
		if(i!=0){
		calorie.setKcal(calorie.getKcal()/i);
		calorie.setCarbohydrate(calorie.getCarbohydrate()/i);
		calorie.setFat(calorie.getFat()/i);
		calorie.setProtein(calorie.getProtein()/i);}
		else{
			calorie.setKcal(calorie.getKcal());
			calorie.setCarbohydrate(calorie.getCarbohydrate());
			calorie.setFat(calorie.getFat());
			calorie.setProtein(calorie.getProtein());
		}
		return calorie;
	}
	
	public Calorie getAverageCalorieByUser(int id){
		DAO dao = new DAO();
		List<Calorie>list=dao.getDiaryCaloriesByUser(id);
		return averageCalorie(list);
		
	}
	

}
