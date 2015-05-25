package hu.unideb.inf.prt.calorie.DAO;

import hu.unideb.inf.prt.calorie.Model.Calorie;
import hu.unideb.inf.prt.calorie.Model.Diet_diary;
import hu.unideb.inf.prt.calorie.Model.Food;
import hu.unideb.inf.prt.calorie.Model.Person;
import hu.unideb.inf.prt.calorie.Model.Person_date;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * A class with database methods.
 * @author mates
 *
 */
public class DAO {
	private static Logger logger = LoggerFactory.getLogger(DAO.class);

	/**
	 * A method for getting the list of foods.
	 * Returns list of food from database.
	 * @return list of food from database
	 */
	public List<Food> getFoodlist(){
		List<Food> foodlist= new ArrayList<Food>();
		try{
		Connection conn= ConnectionFactory.getConnection();
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery("SELECT * FROM KAJAK ORDER BY ID ASC");
		while(rs.next())
		{
			Food food = new Food(rs.getInt(1),rs.getInt(2),rs.getString(3),new Calorie(rs.getDouble(4),rs.getDouble(5),rs.getDouble(6),rs.getDouble(7)),rs.getDouble(8),rs.getString(9));
			foodlist.add(food);
		}
		conn.close();}catch(SQLException e){
			logger.warn("failed to get food list");
			e.printStackTrace();
		}
		logger.debug("got foodlist");
		return foodlist;
	}
	/**
	 * A method for getting map with DateTime key and Double value.
	 * Returns a map with the user's weight history.
	 * @param id of the user
	 * @return a map with the user's weight history
	 */
	public Map<DateTime, Double>getWeightByID(int id){
		Map<DateTime,Double>weightMap=new HashMap<DateTime, Double>();
		try{
			Connection conn=ConnectionFactory.getConnection();
			Statement s=conn.createStatement();
			ResultSet rs=s.executeQuery("SELECT DATUM,TESTSULY FROM FELHASZNALO_NAPLO WHERE FELH_ID="+id);
			while(rs.next()){
				weightMap.put(new DateTime(rs.getDate(1)), rs.getDouble(2));
			}
		conn.close();}catch(SQLException e){
			logger.warn("failed to get weightmap");
			e.printStackTrace();
		}
		logger.debug("got weightmap");
		return weightMap;
	}
	/**
	 * Deprecated method for getting average calories by user is.
	 * Returns the average calories, carbohydrate, fat, protein.
	 * @param id of the user
	 * @return the average calories, carbohydrate, fat, protein
	 */
	public double[] getAverageByUser(int id){
		logger.warn("deprecated");
		double[] info= new double[4];
		try{
			Connection conn=ConnectionFactory.getConnection();
			Statement s=conn.createStatement();
			ResultSet rs=s.executeQuery("SELECT FELH_ID,avg(KALORIA),AVG(SZENHIDRAT),AVG(ZSIR),AVG(FEHERJE) FROM NAPLO INNER JOIN KAJAK ON KAJA_ID=ID where felh_id="+id+" GROUP BY FELH_ID");
			while(rs.next()){
				info[0]=rs.getDouble(2);
				info[1]=rs.getDouble(3);
				info[2]=rs.getDouble(4);
				info[3]=rs.getDouble(5);
			}
		conn.close();}catch(SQLException e){
			e.printStackTrace();
		}
		return info;
	}
	/**
	 * A method for getting the foods' information what the user ate.
	 * Returns a list of Calorie object.
	 * @param id of the user
	 * @return a list of Calorie objects
	 */
	public List<Calorie>getDiaryCaloriesByUser(int id){
		List<Calorie>calorielist=new ArrayList<Calorie>();
		try{
			Connection conn=ConnectionFactory.getConnection();
			Statement s=conn.createStatement();
			ResultSet rs=s.executeQuery("SELECT KALORIA,SZENHIDRAT,ZSIR,FEHERJE FROM NAPLO INNER JOIN KAJAK ON KAJA_ID=ID where felh_id="+id);
			while(rs.next()){
				Calorie calorie= new Calorie(rs.getDouble(1), rs.getDouble(2), rs.getDouble(3), rs.getDouble(4));
				calorielist.add(calorie);
				
			}
			
		conn.close();}catch(SQLException e){
			logger.warn("failed to get calorie list");
			e.printStackTrace();
		}
		logger.debug("got calorie list by user");
		return calorielist;

	}
	/**
	 * A method for getting information about user's meal history for today.
	 * Returns a list of Calorie objects.
	 * @param id of the user
	 * @return a list of Calorie objects
	 */
	public List<Calorie>getDiaryCaloriesByUserToday(int id){
		List<Calorie>calorielist=new ArrayList<Calorie>();
		DateTime dt = DateTime.now();
		DateTimeFormatter fmt = DateTimeFormat.forPattern("dd-MMM-YY");
		String str = fmt.print(dt);
		str="'"+str+"'";
		try{
			Connection conn=ConnectionFactory.getConnection();
			Statement s=conn.createStatement();
			ResultSet rs=s.executeQuery("SELECT DATUM,KALORIA,SZENHIDRAT,ZSIR,FEHERJE,NAPLO.MENNYISEG,KAJAK.MENNYISEG FROM NAPLO INNER JOIN KAJAK ON KAJA_ID=ID where felh_id="+id+" and DATUM="+str);
			while(rs.next()){
				double oszto=rs.getDouble(6)/rs.getDouble(7);
				Calorie calorie= new Calorie(rs.getDouble(2)*oszto, rs.getDouble(3)*oszto, rs.getDouble(4)*oszto, rs.getDouble(5)*oszto);
				calorielist.add(calorie);
				
			}
			
		conn.close();}catch(SQLException e){
			logger.warn("failed to get calorie list for today");
			e.printStackTrace();
		}
		logger.debug("got calorie list for today");
		return calorielist;

	}

	/**
	 * A method for getting a user's weight history.
	 * Returns a list of Doubles.
	 * @param id of the user
	 * @return a list of Doubles
	 */
	public List<Double>getWeightsByUser(int id){
		List<Double>weights=new ArrayList<Double>();
		try{
			Connection conn= ConnectionFactory.getConnection();
			Statement s=conn.createStatement();
			ResultSet rs=s.executeQuery("select TESTSULY from FELHASZNALO_NAPLO WHERE FELH_ID="+id);
			while(rs.next()){
				weights.add(rs.getDouble(1));
			}
		conn.close();}catch(SQLException e){
			logger.warn("failed to get weight list");
			e.printStackTrace();
		}
		logger.debug("got weight list");
		return weights;
	}
	/**
	 * A method for getting food list by user id.
	 * Returns a list of food what was added by the user or by the admin.
	 * @param id of the user
	 * @return a list of food
	 */
	public List<Food> getFoodlistByUser(int id){
		List<Food> foodlist= new ArrayList<Food>();
		try{
		Connection conn= ConnectionFactory.getConnection();
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery("SELECT * FROM KAJAK WHERE USER_ID=0 OR USER_ID="+id+" ORDER BY ID ASC");
		while(rs.next())
		{
			Food food = new Food(rs.getInt(1),rs.getInt(2),rs.getString(3),new Calorie(rs.getDouble(4),rs.getDouble(5),rs.getDouble(6),rs.getDouble(7)),rs.getDouble(8),rs.getString(9));
			foodlist.add(food);
		}
		conn.close();}catch(SQLException e){
			logger.warn("failed to get food list");
			e.printStackTrace();
		}
		logger.debug("got food list");
		return foodlist;
	}
	/**
	 * Deprecated method for getting the people.
	 * Returns a list of Person objects.
	 * @return a list of Person objects
	 */
	public List<Person> getPersonlist(){
		logger.warn("deprecated, personlist");
		List<Person> personlist= new ArrayList<Person>();
		try{
		Connection conn= ConnectionFactory.getConnection();
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery("SELECT * FROM FELHASZNALO_P");
		while(rs.next())
		{
			int id=rs.getInt(1);
			Person_date pd=new Person_date();
			pd=getLatestPersonInfoById(id);
			Person person= new Person(id,rs.getInt(4),new DateTime(rs.getDate(5)),pd, rs.getString(6),rs.getString(2),rs.getString(3));
			personlist.add(person);
			System.out.println(person);
		}
		conn.close();}catch(SQLException e){
			e.printStackTrace();
		}
		return personlist;
	}
	/**
	 * Unused method.
	 * Returns null.
	 * @return null
	 */
	public List<Person> getPersonListWithAdditional(){
		return null;
		
	}
	
	public List<Diet_diary> getDiet_diarylist(int id){
		List<Diet_diary> dietlist= new ArrayList<Diet_diary>();
		try{
		Connection conn= ConnectionFactory.getConnection();
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery("SELECT * FROM NAPLO WHERE FELH_ID="+id);
		while(rs.next())
		{
			Diet_diary diary= new Diet_diary(rs.getInt(1),rs.getInt(2),new DateTime(rs.getDate(3)) ,rs.getInt(4),rs.getString(5),rs.getString(6),new Calorie(rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getInt(10)),new Calorie(rs.getInt(11),rs.getInt(12),rs.getInt(13),rs.getInt(14)));
			dietlist.add(diary);
		}
		conn.close();}catch(SQLException e){
			logger.warn("failed to get diet list");
			e.printStackTrace();
		}
		logger.debug("got diet list");
		return dietlist;
	}
	/**
	 * A method for getting the last date of changeable user information.
	 * Returns a date when the information changed.
	 * @param id of the user
	 * @return a date when the information changed
	 */
	public DateTime getDateByUserId(int id){
		DateTime date=null;
		try{
		Connection conn= ConnectionFactory.getConnection();
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery("SELECT FELH_ID,MAX(DATUM) FROM FELHASZNALO_NAPLO WHERE FELH_ID="+id+" GROUP BY FELH_ID");
		while(rs.next())
		{
			date=new DateTime(rs.getDate(2));
		}
		conn.close();}catch(SQLException e){
			logger.warn("failed to get date");
			e.printStackTrace();
		}
		logger.debug("got date");
		return date;
	}
	/**
	 * A method for getting information about a person.
	 * Returns a Person object.
	 * @param uname of the user
	 * @param passw of the user
	 * @return a Person object
	 */
	public Person getUserId(String uname, String passw){
		Person person=null;
		uname="'"+uname+"'";
		passw="'"+passw+"'";
		try{
		Connection conn= ConnectionFactory.getConnection();
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery("SELECT * FROM FELHASZNALO_P INNER JOIN FELHASZNALO_NAPLO ON ID=FELH_ID WHERE FELHNEV="+uname+" AND JELSZO="+passw+" ORDER BY DATUM DESC");
		while(rs.next())
		{
			person=new Person(rs.getInt(1), rs.getInt(4), new DateTime(rs.getDate(5)), new Person_date(new DateTime(rs.getDate(8)), rs.getDouble(9), rs.getInt(10), rs.getDouble(11)), rs.getString(6), rs.getString(2), rs.getString(3));	break;	}
		conn.close();}catch(SQLException e){
			logger.warn("failed to get person");
			e.printStackTrace();
		}
		logger.debug("got person");
		return person;
	}
	/**
	 * A method for getting user id by username.
	 * Returns an int represents the user id
	 * @param uname of the user
	 * @return an int represents the user id
	 */
	public int getUserIdByUname(String uname){
		logger.warn("deprecated");
		int UID=-1;
		uname="'"+uname+"'";
		try{
		Connection conn= ConnectionFactory.getConnection();
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery("SELECT ID FROM FELHASZNALO_P WHERE FELHNEV="+uname);
		while(rs.next())
		{
			UID=rs.getInt(1);
		}
		conn.close();}catch(SQLException e){
			e.printStackTrace();
		}
		return UID;
	}
	/**
	 * A method for getting the maximum food id.
	 * Returns the maximum food id.
	 * @return the maximum food id.
	 */
	public int maxFoodId(){
		int id=Integer.MAX_VALUE;
		try{
			Connection conn=ConnectionFactory.getConnection();
			Statement s= conn.createStatement();
			ResultSet rs=s.executeQuery("select max(id) from kajak ");
			while(rs.next()){
				id=rs.getInt(1);
			}
		conn.close();}catch(SQLException e){
			logger.warn("failed to get food id");
			e.printStackTrace();
		}
		logger.debug("got food id");
		return id;
	}
	/**
	 * A method for getting the maximum person id.
	 * Returns the maximum person id.
	 * @return the maximum person id.
	 */
	public int maxPersonId(){
		int id=Integer.MAX_VALUE;
		try{
			Connection conn=ConnectionFactory.getConnection();
			Statement s= conn.createStatement();
			ResultSet rs=s.executeQuery("select max(id) from FELHASZNALO_P ");
			while(rs.next()){
				id=rs.getInt(1);
			}
		conn.close();}catch(SQLException e){
			logger.warn("failed to get max person id");
			e.printStackTrace();
		}
		logger.debug("got max person id");
		return id;
	}
	/**
	 * A method for getting the latest person info.
	 * Returns a Person_date object.
	 * @param id of the user
	 * @return a Person_date object
	 */
	public Person_date getLatestPersonInfoById(int id){
		Person_date person=null;
		try{
		Connection conn= ConnectionFactory.getConnection();
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery("SELECT FELH_ID,MAX(DATUM),TESTSULY,MOZGAS,CEL FROM FELHASZNALO_NAPLO where felh_id="+id+" GROUP BY FELH_ID,TESTSULY,MOZGAS,CEL");
		while(rs.next())
		{
			 person= new Person_date(new DateTime(rs.getDate(2)),rs.getDouble(3),rs.getInt(4),rs.getDouble(5));
					}
		conn.close();}catch(SQLException e){
			logger.warn("failed to get latest person info");
			e.printStackTrace();
		}
		logger.debug("got latest person info");
		return person;
	}
	/**
	 * A method for inserting new food.
	 * @param food object that needs inserting.
	 */
	public void insertFood(Food food){
		try{
			Connection conn= ConnectionFactory.getConnection();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO KAJAK (ID,USER_ID,NEV,KALORIA,SZENHIDRAT,ZSIR,FEHERJE,MENNYISEG,MERT_E) VALUES(?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, food.getId());
			ps.setInt(2, food.getUserId());
			ps.setString(3, food.getName());
			ps.setDouble(4, food.getCalorie().getKcal());
			ps.setDouble(5, food.getCalorie().getCarbohydrate());
			ps.setDouble(6, food.getCalorie().getFat());
			ps.setDouble(7, food.getCalorie().getProtein());
			ps.setDouble(8, food.getQuantity());
			ps.setString(9, food.getUnit());
			ps.executeUpdate();
			conn.close();
			
			}catch(SQLException e){
				logger.warn("failed to insert food");
				e.printStackTrace();
			}
		logger.debug("food inserted");
	}
	/**
	 * A method for inserting user.	
	 * @param person that needs to be inserted
	 */
	public void insertUser(Person person){
		logger.warn("deprecated");
		try{
			Connection conn= ConnectionFactory.getConnection();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO FELHASZNALO (ID,FELHNEV,JELSZO,MAGASSAG,SULY,EV,MOZGAS,NEM,CEL) VALUES(?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, person.getId());
			ps.setString(2, person.getUname());
			ps.setString(3, person.getPassword());
			ps.setDouble(4, 1);
			ps.setDouble(5, 1);
			ps.setDouble(6, 1);
			ps.setDouble(7, 1);
			ps.setString(8, "Male");
			ps.setDouble(9, 1);
			ps.executeUpdate();
			
			}catch(SQLException e){
				logger.warn("failed to insert user");
				e.printStackTrace();
			}
		logger.debug("user inserted");
	}
	/**
	 * A method for inserting new user.
	 * @param person that needs to be inserted
	 */
	public void insertUser_P(Person person){
		try{
			Connection conn= ConnectionFactory.getConnection();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO FELHASZNALO_P (ID,FELHNEV,JELSZO,MAGASSAG,SZUL,NEM) VALUES(?,?,?,?,?,?)");
			ps.setInt(1, person.getId());
			ps.setString(2, person.getUname());
			ps.setString(3, person.getPassword());
			ps.setDouble(4, person.getHeight());
			ps.setDate(5,new Date( person.getBorn().getMillis()));
			ps.setString(6, person.getGender());
			ps.executeUpdate();
			conn.close();
			
			}catch(SQLException e){
				logger.warn("failed to insert user");
				e.printStackTrace();
			}
		logger.debug("user inserted");
	}
	/**
	 * A method for inserting recent information about a user.
	 * @param person object with more recent information
	 */
	public void insertUser_Diary(Person person){
		try{
			Connection conn= ConnectionFactory.getConnection();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO FELHASZNALO_NAPLO (FELH_ID,DATUM,TESTSULY,MOZGAS,CEL) VALUES(?,?,?,?,?)");
			ps.setInt(1, person.getId());
			ps.setDate(2, new Date(person.getDaily().getDate().getMillis()));
			ps.setDouble(3, person.getDaily().getWeight());
			ps.setInt(4, person.getDaily().getExcercise());
			ps.setDouble(5, person.getDaily().getGoal());
			ps.executeUpdate();
			conn.close();
			
			}catch(SQLException e){
				logger.warn("failed to insert into user diary");
				e.printStackTrace();
			}
		logger.debug("inserted into diary");
	}
	/**
	 * A method for inserting into diary.
	 * @param diary that needs to be inserted
	 */
	public void insertDiary(Diet_diary diary){
		try{
			Connection conn= ConnectionFactory.getConnection();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO NAPLO (FELH_ID,KAJA_ID,DATUM,MENNYISEG,MERT_E,ETK_TIPUS,KAL_SZUK,SZENH_SZUK,ZSIR_SZUK,FEH_SZUK,KAL_TELJ,SZENH_TELJ,ZSIR_TELJ,FEH_TELJ) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1,diary.getUserId());
			ps.setInt(2, diary.getFoodId());
			ps.setDate(3,new Date( diary.getDate().getMillis()));
			ps.setDouble(4, diary.getQuantity());
			ps.setString(5, diary.getUnit());
			ps.setString(6, diary.getMeal());
			ps.setDouble(7, diary.getNeeds().getKcal());
			ps.setDouble(8, diary.getNeeds().getCarbohydrate());
			ps.setDouble(9, diary.getNeeds().getFat());
			ps.setDouble(10, diary.getNeeds().getProtein());
			ps.setDouble(11, diary.getRemaining().getKcal());
			ps.setDouble(12, diary.getRemaining().getCarbohydrate());
			ps.setDouble(13, diary.getRemaining().getFat());
			ps.setDouble(14, diary.getRemaining().getProtein());
			ps.executeUpdate();
			conn.close();
			
			}catch(SQLException e){
				logger.warn("failed to insert into diet diary");
				e.printStackTrace();
			}
		logger.debug("inserted into diet_diary");
	}
	/**
	 * A method for removing unwanted foods from the database.
	 * @param food that needs to be removed
	 */
	public void deleteFood(Food food){
		try{
			Connection conn=ConnectionFactory.getConnection();
			PreparedStatement ps=conn.prepareStatement("DELETE FROM KAJAK WHERE ID="+food.getId());
			ps.executeQuery();
			conn.close();
			
			
		}catch(SQLException e){
			logger.warn("failed to delete food");
			e.printStackTrace();
		}
		logger.debug("food deleted");
	}
	/**
	 * Unused method for updating food.
	 * @param food that needs to be updated.
	 */
	public void updateFood(Food food){
		logger.warn("deprecated");
		try{
			Connection conn=ConnectionFactory.getConnection();
			PreparedStatement ps=conn.prepareStatement("UPDATE KAJAK SET NEV=? , KALORIA=? , SZENHIDRAT=? , ZSIR=? , FEHERJE=? , MENNYISEG=? , MERT_E=? WHERE ID=? AND USER_ID!=0");
			
			ps.setString(1, food.getName());
			ps.setDouble(2, food.getCalorie().getKcal());
			ps.setDouble(3, food.getCalorie().getCarbohydrate());
			ps.setDouble(4, food.getCalorie().getFat());
			ps.setDouble(5, food.getCalorie().getProtein());
			ps.setDouble(6, food.getQuantity());
			ps.setString(7, food.getUnit());
			ps.setInt(8, food.getId());
			
			ps.executeUpdate();
			conn.close();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	/*public void updateUser(Person person){
		try{
			Connection conn= ConnectionFactory.getConnection();
			PreparedStatement ps = conn.prepareStatement("UPDATE FELHASZNALO SET MAGASSAG=? , SULY=? , EV=? , MOZGAS=? , NEM=? , CEL=? WHERE ID=?");
			ps.setDouble(1, person.getHeight());
			ps.setDouble(2, person.getWeight());
			ps.setDouble(3, person.getYear());
			ps.setDouble(4, person.getExcercise());
			ps.setString(5, person.getGender());
			ps.setDouble(6, person.getGoal());
			ps.setInt(7, person.getId());
			ps.executeUpdate();
			
			}catch(SQLException e){
				e.printStackTrace();
			}
	}*/


	

}
