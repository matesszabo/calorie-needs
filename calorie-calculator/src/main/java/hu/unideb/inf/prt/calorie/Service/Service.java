package hu.unideb.inf.prt.calorie.Service;

import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hu.unideb.inf.prt.calorie.DAO.ConnectionFactory;
import hu.unideb.inf.prt.calorie.DAO.DAO;
import hu.unideb.inf.prt.calorie.Model.Calorie;
import hu.unideb.inf.prt.calorie.Model.Diet_diary;
import hu.unideb.inf.prt.calorie.Model.Food;
import hu.unideb.inf.prt.calorie.Model.Person;
import hu.unideb.inf.prt.calorie.Model.Person_date;
/**
 * Service class for calculating and calling dao methods.
 * @author mates
 *
 */
public class Service {
	private static Logger logger = LoggerFactory.getLogger(Service.class);

	
	/*
	 * A how old method would be great
	 */
	/**
	 * A method for calculating BMR
	 * Returns the BMR value.
	 * @param person who provides the information
	 * @return BMR value
	 */
	public double calcBMR(Person person){
		logger.debug("calculating bmr");
		if(person.getGender().equals("férfi") || person.getGender().equals("Male")){
			
			return (66.473 +(13.7516*person.getDaily().getWeight())+(5.0033 *person.getHeight())-(6.7550 *(DateTime.now().minusYears(person.getBorn().getYear()).minusMonths(person.getBorn().getMonthOfYear()).minusDays(person.getBorn().getDayOfMonth()).getYear())));
		}else{
			return (655.0955 +(9.5634 *person.getDaily().getWeight())+(1.8496  *person.getHeight())-(4.6756 *(DateTime.now().minusYears(person.getBorn().getYear()).minusMonths(person.getBorn().getMonthOfYear()).minusDays(person.getBorn().getDayOfMonth()).getYear())));
		}
	}
	/**
	 * A method for calculating BMI
	 * Returns the BMI value.
	 * @param person who provides the information
	 * @return BMI value
	 */
	public double calcBMI(Person person){
		logger.debug("calculating bmi");
		return person.getDaily().getWeight()/Math.pow(((double)person.getHeight())/100, 2);
	}
	/**
	 * A method for calculating daily needs in kcal,carbohydrate,fat,protein.
	 * Returns calorie object that represents the needs.
	 * @param person who provides the information
	 * @return calorie object that represents the needs
	 */
	public Calorie calcNeeds(Person person){
		logger.debug("calculating needs");
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
	/**
	 * A method for getting person object from database.
	 * Returns a person object.
	 * @param uname of the person
	 * @param passw of the person
	 * @return person object from database
	 */
	public static Person existsUser(String uname, String passw){
		logger.debug("getting user");
		DAO dao= new DAO();
		Person person=dao.getUserId(uname, passw);
		return person;
	}
	/**
	 * A method for checking if the user exists or not.
	 * Returns  boolean answer.
	 * @param uname of the user
	 * @return boolean answer
	 */
	public boolean existsUserByUname(String uname){
		logger.debug("checking username");
		DAO dao= new DAO();
		return dao.getUserIdByUname(uname)==-1?false:true;
	}
	/**
	 * A method for getting the food list by user id.
	 * Returns food list.
	 * @param id of the user
	 * @return list of foods
	 */
	public List<Food>getFoodListByUserId(int id){
		logger.debug("getting food list");
		DAO dao= new DAO();
		return dao.getFoodlistByUser(id);
	}
	/**
	 * A method for getting diet diary by user id.
	 * Returns a list of diet_diary object.
	 * @param id of the user
	 * @return list of Diet_diary objects
	 */
	public List<Diet_diary>getDietDiaryByUserId(int id){
		logger.debug("getting diet list");
		DAO dao = new DAO();
		return dao.getDiet_diarylist(id);
	}
	/**
	 * A method for getting weight map by user id.
	 * Returns a map with DateTime keys and double values.
	 * @param id of the user
	 * @return map with DateTime keys and weight as double values
	 */
	public Map<DateTime,Double>getWeightMapById(int id){
		logger.debug("getting the weight map");
		DAO dao= new DAO();
		return dao.getWeightByID(id);
	}
	
	/**
	 * A method for calculating average from a list of Calorie objects.
	 * Returns a calorie object represents the averages.
	 * @param list of Calorie objects
	 * @return Calorie object represents the averages
	 */
	public Calorie averageCalorie(List<Calorie>list){
		logger.debug("calculating average calorie");
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
	/**
	 * A method for getting average calorie by user id.
	 * Returns a Calorie object represents the averages.
	 * @param id of the user.
	 * @return Calorie object represents the averages
	 */
	public Calorie getAverageCalorieByUser(int id){
		DAO dao = new DAO();
		List<Calorie>list=dao.getDiaryCaloriesByUser(id);
		return averageCalorie(list);
		
	}
	/**
	 * A method for calculating average weight.
	 * Returns average weight.
	 * @param list of Double values
	 * @return average weight
	 */
	public double averageWeight(List<Double>list){
		logger.debug("calculating average weight");
		double avg=0;
		int i=0;
		for (Double double1 : list) {
			i++;
			avg+=double1;
		}
		return i==0?0:avg/i;
	}
	/**
	 * A method for getting average weight by user id.
	 * Returns average weight.
	 * @param id of the user
	 * @return average weight
	 */
	public double getAverageWeightByUser(int id){
		DAO dao=new DAO();
		List<Double>list=dao.getWeightsByUser(id);
		return averageWeight(list);
	}
	
	/**
	 * A method for getting current info by user id.
	 * Returns a Person_date object.
	 * @param id of the user
	 * @return Person_date object with the latest data
	 */
	public Person_date getCurrentInfoByUser(int id){
		logger.debug("getting current user info");
		DAO dao= new DAO();
		Person_date pd=dao.getLatestPersonInfoById(id);
		return pd;
	}
	/**
	 * A method for calculating fulfilled calories.
	 * Returns a Calorie object represents the fulfilled kcal,carbohydrate,fat,protein.
	 * @param list of Calorie objects
	 * @return a Calorie object represents the fulfilled kcal,carbohydrate,fat,protein
	 */
	public Calorie calcFulfilledCalories(List<Calorie>lista){
		logger.debug("calculating fulfilled calories");
		Calorie calorie=new Calorie();
		for (Calorie calorie2 : lista) {
			calorie.setKcal(calorie.getKcal()+calorie2.getKcal());
			calorie.setCarbohydrate(calorie.getCarbohydrate()+calorie2.getCarbohydrate());
			calorie.setFat(calorie.getFat()+calorie2.getFat());
			calorie.setProtein(calorie.getProtein()+calorie2.getProtein());
		}
		return calorie;
	}
	/**
	 * A method for calculating health status.
	 * Returns a String with the person's health status.
	 * @param person who provides the information
	 * @return a String with the person's health status
	 */
	public String calcHealthStatus(Person person){
		logger.debug("checking the BMI");
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
	/**
	 * A method for getting fulfilled calories by user id
	 * Returns a Calorie object representing kcal,carbohydrate,fat,protein.
	 * @param id of the user
	 * @return a Calorie object representing kcal,carbohydrate,fat,protein
	 */
	public Calorie getFulfilledCalories(int id){
		DAO dao=new DAO();
		return calcFulfilledCalories(dao.getDiaryCaloriesByUserToday(id));
		
	}
	/**
	 * A method for inserting current user information.
	 * @param person that provides current user information
	 */
	public void insertUserDiary(Person person){
		DAO dao=new DAO();
		dao.insertUser_Diary(person);
	}
	/**
	 * A method for inserting Diet_diary object to database.
	 * @param dd is the object that needs to be inserted
	 */
	public void insertDietDiary(Diet_diary dd){
		DAO dao=new DAO();
		dao.insertDiary(dd);
	}
	/**
	 * A method for inserting food.
	 * @param food that needs to be inserted
	 */
	public void insertFood(Food food){
		DAO dao= new DAO();
		dao.insertFood(food);
	}
	/**
	 * A method for getting maximum food id.
	 * Returns maximum food id.
	 * @return maximum food id
	 */
	public int getMaxFoodId(){
		DAO dao=new DAO();
		return dao.maxFoodId();
	}
	/**
	 * A method for deleting food.
	 * @param food that needs to be deleted
	 * @param person who wants to delete
	 */
	public void deleteFood(Food food,Person person){
		logger.debug("attempting to delete food");
		if(food.getUserId()==person.getId()){
		DAO dao= new DAO();
		dao.deleteFood(food);
		logger.debug("food deleted");}
		else
			logger.warn("unable to delete food");
	}
	/**
	 * A method for registering a new user.
	 * @param person who needs to be registered
	 */
	public void registerUser(Person person){
		logger.debug("registering a new user");
		DAO dao= new DAO();
		dao.insertUser_P(person);
		dao.insertUser_Diary(person);
	}
	/**
	 * A method for getting maximum person id.
	 * Returns maximum person id.
	 * @return maximum person id
	 */
	public int getMaxPersonId(){
		DAO dao= new DAO();
		return dao.maxPersonId();
	}
	

}
