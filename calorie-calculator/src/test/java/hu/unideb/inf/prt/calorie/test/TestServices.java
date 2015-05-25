/**
 * 
 */
package hu.unideb.inf.prt.calorie.test;

import static org.junit.Assert.*;
import hu.unideb.inf.prt.calorie.DAO.DAO;
import hu.unideb.inf.prt.calorie.Model.*;
import hu.unideb.inf.prt.calorie.Service.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.junit.*;

/**
 * @author mates
 *
 */
public class TestServices {
	@Test
	public void testAverageCalorie(){
		Service service=new Service();
		List<Calorie>list=new ArrayList<Calorie>();
		List<Calorie>list2=new ArrayList<Calorie>();
		List<Calorie>list3=new ArrayList<Calorie>();
		list.add(new Calorie(0,0,0,0));
		list2.add(new Calorie(1, 2, 3, 4));
		list2.add(new Calorie(2, 1, 4, 3));
		list2.add(new Calorie(3, 4, 2, 1));
		list2.add(new Calorie(4, 3, 1, 2));
		
		assertEquals("0 must remain 0", new Calorie(0.0,0.0,0.0,0.0), service.averageCalorie(list));
		assertEquals("average of 1 2 3 4 is 2.5", new Calorie(2.5,2.5,2.5,2.5), service.averageCalorie(list2));
		assertEquals("null must be converted to 0", new Calorie(0,0,0,0), service.averageCalorie(list3));
		
	}
	
	@Test
	public void testCalcHealthStatus(){
		Service service= new Service();
		Person person=new Person(0, 150, DateTime.now(), new Person_date(), "", "", "", 10, 500, new Calorie());
		Person person1=new Person(0, 150, DateTime.now(), new Person_date(), "", "", "", 15, 500, new Calorie());
		Person person2=new Person(0, 150, DateTime.now(), new Person_date(), "", "", "", 16, 500, new Calorie());
		Person person3=new Person(0, 150, DateTime.now(), new Person_date(), "", "", "", 20, 500, new Calorie());
		Person person4=new Person(0, 150, DateTime.now(), new Person_date(), "", "", "", 25, 500, new Calorie());
		Person person5=new Person(0, 150, DateTime.now(), new Person_date(), "", "", "", 30, 500, new Calorie());
		Person person6=new Person(0, 150, DateTime.now(), new Person_date(), "", "", "", 35, 500, new Calorie());
		Person person7=new Person(0, 150, DateTime.now(), new Person_date(), "", "", "", 40, 500, new Calorie());
		
		assertEquals("Very severely underweight", service.calcHealthStatus(person));
		assertEquals("Severely underweight", service.calcHealthStatus(person1));
		assertEquals("Underweight", service.calcHealthStatus(person2));
		assertEquals("Normal (healthy weight)", service.calcHealthStatus(person3));
		assertEquals("Overweight", service.calcHealthStatus(person4));
		assertEquals("Obese Class I (Moderately obese)", service.calcHealthStatus(person5));
		assertEquals("Obese Class II (Severely obese)", service.calcHealthStatus(person6));
		assertEquals("Obese Class III (Very severely obese)", service.calcHealthStatus(person7));	
		
	}
	@Test
	public void testFulfilledCalories(){
		Service service=new Service();
		List<Calorie>list1=new ArrayList<Calorie>();
		List<Calorie>list2=new ArrayList<Calorie>();
		List<Calorie>list3=new ArrayList<Calorie>();
		
		list1.add(new Calorie(0, 0, 0, 0));
		
		list2.add(new Calorie(1, 2, 3, 4));
		list2.add(new Calorie(2, 1, 4, 3));
		list2.add(new Calorie(3, 4, 2, 1));
		list2.add(new Calorie(4, 3, 1, 2));
		
		assertEquals("0 must remain 0", new Calorie(0.0,0.0,0.0,0.0), service.calcFulfilledCalories(list1));
		assertEquals("sum of 1 2 3 4 is 10", new Calorie(10,10,10,10), service.calcFulfilledCalories(list2));
		assertEquals("null must be converted to 0", new Calorie(0,0,0,0), service.calcFulfilledCalories(list3));
		
	}
	@Test
	public void testAverageWeight(){
		Service service= new Service();
		List<Double>list1=new ArrayList<Double>();
		List<Double>list2=new ArrayList<Double>();
		List<Double>list3=new ArrayList<Double>();
		
		list1.add(0.0);
		
		list2.add(1.0);
		list2.add(2.0);
		list2.add(3.0);
		list2.add(4.0);
		
		assertEquals("0 must remain 0", 0.0, service.averageWeight(list1),10);
		assertEquals("average of 1 2 3 4 is 2.5", 2.5, service.averageWeight(list2),10);
		assertEquals("null must be converted to 0", 0.0, service.averageWeight(list3),10);
	}
	@Test
	public void testCalcNeeds(){
		Service service=new Service();
		Person person=new Person(0, 150, new DateTime(1994, 9, 16, 11, 42), new Person_date(DateTime.now(), 65, 3, 0), "Male", "", "", 10, 1570, new Calorie());
		Person person2=new Person(0, 150, new DateTime(1994, 9, 16, 11, 42), new Person_date(DateTime.now(), 65, 2, -0.5), "Female", "", "", 10, 1455, new Calorie());		
		Calorie cal1=new Calorie(2433.28, 1338.85, 730.28, 365.14);
		Calorie cal2=new Calorie(1500.63, 825.84, 450.19, 225.59);
		
		
		assertEquals((int)cal1.getKcal(), (int)service.calcNeeds(person).getKcal());
		assertEquals((int)cal1.getCarbohydrate(), (int)service.calcNeeds(person).getCarbohydrate());
		assertEquals((int)cal1.getFat(), (int)service.calcNeeds(person).getFat());
		assertEquals((int)cal1.getProtein(), (int)service.calcNeeds(person).getProtein());
		assertEquals((int)cal2.getKcal(), (int)service.calcNeeds(person2).getKcal());
		assertEquals((int)cal2.getCarbohydrate(), (int)service.calcNeeds(person2).getCarbohydrate());
		assertEquals((int)cal2.getFat(), (int)service.calcNeeds(person2).getFat());
		assertEquals((int)cal2.getProtein(), (int)service.calcNeeds(person2).getProtein());


		
	}

	@Test
	public void testCalcBmi(){
		Service service=new Service();
		Person person=new Person(0, 190, new DateTime(1994, 9, 16, 11, 42), new Person_date(DateTime.now(), 65, 3, 0), "Male", "", "", 10, 1570, new Calorie());
		Person person2=new Person(0, 150, new DateTime(1994, 9, 16, 11, 42), new Person_date(DateTime.now(), 55, 2, -0.5), "Female", "", "", 10, 1455, new Calorie());		
		
		assertEquals(18.0, service.calcBMI(person),1);
		assertEquals(24.4, service.calcBMI(person2),1);
	}
	
	@Test
	public void testCalcBmr(){
		Service service=new Service();
		Person person=new Person(0, 190, new DateTime(1994, 9, 16, 11, 42), new Person_date(DateTime.now(), 65, 3, 0), "Male", "", "", 10, 1570, new Calorie());
		Person person2=new Person(0, 150, new DateTime(1994, 9, 16, 11, 42), new Person_date(DateTime.now(), 55, 2, -0.5), "Female", "", "", 10, 1455, new Calorie());		
		
		assertEquals(1775.0, service.calcBMR(person),1);
		assertEquals(1365.0, service.calcBMR(person2),1);
	}
	
	@Test
	public void testExistUser(){
		assertEquals(0, Service.existsUser("admin", "admin").getId());
		
	}
	@Test
	public void testExistByUName(){
		Service service=new Service();
		assertEquals(true, service.existsUserByUname("admin"));
	}
	
	@Test
	public void testGetFoodListByUserId(){
		Service service=new Service();
		List<Food> list=service.getFoodListByUserId(-1);
		List<Food> list2=service.getFoodListByUserId(0);
		assertArrayEquals(list.toArray(new Food[list2.size()]), list2.toArray(new Food[list2.size()]));
		//assertNotEquals(service.getFoodListByUserId(0), service.getFoodListByUserId(1));

	}
	
	@Test
	public void testDiaryListByUserId(){
		Service service=new Service();
		List<Diet_diary>list=service.getDietDiaryByUserId(-1);
		List<Diet_diary>list2=service.getDietDiaryByUserId(0);
		
		assertNotEquals(list, list2);
		
	}
	
	@Test
	public void testGetWeightMapById(){
		Service service=new Service();
		Map<DateTime,Double>map1=service.getWeightMapById(0);
		Map<DateTime,Double>map2=service.getWeightMapById(-1);
		assertNotEquals(map1, map2);
	
	}
	@Test
	public void testGetAverageCalorieByUserId(){
		Service service=new Service();
		Calorie calorie1=new Calorie(0, 0, 0, 0);
		
		assertEquals(calorie1, service.getAverageCalorieByUser(-1));
		
	}
	
	@Test
	public void testGetAverageWeightByUserId(){
		Service service=new Service();
		
		assertEquals(0.0, service.getAverageWeightByUser(-1),0);
	}
	
	@Test
	public void testGetCurrentInfoByUser(){
		Service service=new Service();
		
		assertEquals(null, service.getCurrentInfoByUser(-1));
		
	}
	@Test
	public void testGetFulfilledCalories(){
		Service service=new Service();
		assertEquals(new Calorie(0,0,0,0), service.getFulfilledCalories(-1));
	}
	
	
	
}
