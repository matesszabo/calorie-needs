package hu.unideb.inf.prt.calorie.Service;

import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;

import hu.unideb.inf.prt.calorie.DAO.DAO;
import hu.unideb.inf.prt.calorie.Model.Calorie;
import hu.unideb.inf.prt.calorie.Model.Diet_diary;
import hu.unideb.inf.prt.calorie.Model.Food;
import hu.unideb.inf.prt.calorie.Model.Person;
import hu.unideb.inf.prt.calorie.Model.Person_date;

public class Service {
	
	/*
	 * A how old method would be great
	 */
	public double calcBMR(Person person){
		if(person.getGender().equals("férfi")){
			
			return (66.473 +(13.7516*person.getDaily().getWeight())+(5.0033 *person.getHeight())-(6.7550 *(DateTime.now().minusYears(person.getBorn().getYear()).minusMonths(person.getBorn().getMonthOfYear()).minusDays(person.getBorn().getDayOfMonth()).getYear())));
		}else{
			return (655.0955 +(9.5634 *person.getDaily().getWeight())+(1.8496  *person.getHeight())-(4.6756 *(DateTime.now().minusYears(person.getBorn().getYear()).minusMonths(person.getBorn().getMonthOfYear()).minusDays(person.getBorn().getDayOfMonth()).getYear())));
		}
	}
	
	public double calcBMI(Person person){
		return person.getDaily().getWeight()/Math.pow(((double)person.getHeight())/100, 2);
	}
	
	public Calorie calcNeeds(Person person){
		Calorie calorie=null;
		double modifier=person.getDaily().getGoal()/0.5*500;
		if(person.getDaily().getExcercise()==1){
			calorie= new Calorie(person.getBMR()*1.2+modifier);
			calorie.setCarbohydrate(calorie.getKcal()*0.55);
			calorie.setProtein(calorie.getKcal()*0.15);
			calorie.setFat(calorie.getKcal()*0.3);		
		}
		if(person.getDaily().getExcercise()==2){
			calorie= new Calorie(person.getBMR()*1.375+modifier);
			calorie.setCarbohydrate(calorie.getKcal()*0.55);
			calorie.setProtein(calorie.getKcal()*0.15);
			calorie.setFat(calorie.getKcal()*0.3);		
		}
		if(person.getDaily().getExcercise()==3){
			calorie= new Calorie(person.getBMR()*1.55+modifier);
			calorie.setCarbohydrate(calorie.getKcal()*0.55);
			calorie.setProtein(calorie.getKcal()*0.15);
			calorie.setFat(calorie.getKcal()*0.3);		
		}
		if(person.getDaily().getExcercise()==4){
			calorie= new Calorie(person.getBMR()*1.725+modifier);
			calorie.setCarbohydrate(calorie.getKcal()*0.55);
			calorie.setProtein(calorie.getKcal()*0.15);
			calorie.setFat(calorie.getKcal()*0.3);		
		}
		if(person.getDaily().getExcercise()==5){
			calorie= new Calorie(person.getBMR()*1.9+modifier);
			calorie.setCarbohydrate(calorie.getKcal()*0.55);
			calorie.setProtein(calorie.getKcal()*0.15);
			calorie.setFat(calorie.getKcal()*0.3);		
		}
		return calorie;
	}
	
	public static Person existsUser(String uname, String passw){
		DAO dao= new DAO();
		Person person=dao.getUserId(uname, passw);
		return person;
	}
	
	public boolean existsUserByUname(String uname){
		DAO dao= new DAO();
		return dao.getUserIdByUname(uname)==-1?false:true;
	}
	
	public List<Food>getFoodListByUserId(int id){
		DAO dao= new DAO();
		return dao.getFoodlistByUser(id);
	}
	
	public List<Diet_diary>getDietDiaryByUserId(int id){
		DAO dao = new DAO();
		return dao.getDiet_diarylist(id);
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
	public double averageWeight(List<Double>list){
		double avg=0;
		int i=0;
		for (Double double1 : list) {
			i++;
			avg+=double1;
		}
		return i==0?0:avg/i;
	}
	
	public double getAverageWeightByUser(int id){
		DAO dao=new DAO();
		List<Double>list=dao.getWeightsByUser(id);
		return averageWeight(list);
	}
	
	public Person_date getCurrentInfoByUser(int id){
		DAO dao= new DAO();
		Person_date pd=dao.getLatestPersonInfoById(id);
		return pd;
	}
	
	public Calorie calcFulfilledCalories(List<Calorie>lista){
		Calorie calorie=new Calorie();
		for (Calorie calorie2 : lista) {
			calorie.setKcal(calorie.getKcal()+calorie2.getKcal());
			calorie.setCarbohydrate(calorie.getCarbohydrate()+calorie2.getCarbohydrate());
			calorie.setFat(calorie.getFat()+calorie2.getFat());
			calorie.setProtein(calorie.getProtein()+calorie2.getProtein());
		}
		return calorie;
	}
	
	public String calcHealthStatus(Person person){
		if(person.getBMI()<15)
			return "Very severely underweight";
		if(person.getBMI()>=15 && person.getBMI()<16)
			return "Severely underweight";
		if(person.getBMI()>=16 && person.getBMI()<18.5)
			return "Underweight";
		if(person.getBMI()>=18.5 && person.getBMI()<25)
			return "Normal (healthy weight)";
		if(person.getBMI()>=25 && person.getBMI()<30)
			return "Overweight";
		if(person.getBMI()>=30 && person.getBMI()<35)
			return "Obese Class I (Moderately obese)";
		if(person.getBMI()>=35 && person.getBMI()<40)
			return "Obese Class II (Severely obese)";
		if(person.getBMI()>=40)
			return "Obese Class III (Very severely obese)";
		return "";
		
	}
	
	public Calorie getFulfilledCalories(int id){
		DAO dao=new DAO();
		return calcFulfilledCalories(dao.getDiaryCaloriesByUserToday(id));
		
	}
	
	public void insertUserDiary(Person person){
		DAO dao=new DAO();
		dao.insertUser_Diary(person);
	}
	
	public void insertDietDiary(Diet_diary dd){
		DAO dao=new DAO();
		dao.insertDiary(dd);
	}
	
	public void insertFood(Food food){
		DAO dao= new DAO();
		dao.insertFood(food);
	}
	
	public int getMaxFoodId(){
		DAO dao=new DAO();
		return dao.maxFoodId();
	}
	
	public void deleteFood(Food food,Person person){
		if(food.getUserId()==person.getId()){
		DAO dao= new DAO();
		dao.deleteFood(food);}
	}
	

}
