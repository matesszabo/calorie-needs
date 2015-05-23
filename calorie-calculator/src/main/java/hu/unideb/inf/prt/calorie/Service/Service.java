package hu.unideb.inf.prt.calorie.Service;

import org.joda.time.DateTime;

import hu.unideb.inf.prt.calorie.Model.Calorie;
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
	
	

}
