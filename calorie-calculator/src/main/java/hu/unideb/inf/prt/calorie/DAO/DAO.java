package hu.unideb.inf.prt.calorie.DAO;

import hu.unideb.inf.prt.calorie.Model.Calorie;
import hu.unideb.inf.prt.calorie.Model.Diet_diary;
import hu.unideb.inf.prt.calorie.Model.Food;
import hu.unideb.inf.prt.calorie.Model.Person;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

public class DAO {
	public List<Food> getFoodlist(){
		List<Food> foodlist= new ArrayList<Food>();
		try{
		Connection conn= ConnectionFactory.getConnection();
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery("SELECT * FROM KAJAK");
		while(rs.next())
		{
			Food food = new Food(rs.getInt(1),rs.getInt(2),rs.getString(3),new Calorie(rs.getDouble(4),rs.getDouble(5),rs.getDouble(6),rs.getDouble(7)),rs.getDouble(8),rs.getString(9));
			foodlist.add(food);
		}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return foodlist;
	}
	
	public List<Person> getPersonlist(){
		List<Person> personlist= new ArrayList<Person>();
		try{
		Connection conn= ConnectionFactory.getConnection();
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery("SELECT * FROM FELHASZNALO");
		while(rs.next())
		{
			Person person = new Person(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getString(8),rs.getInt(9));
			personlist.add(person);
		}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return personlist;
	}
	
	public List<Diet_diary> getDiet_diarylist(){
		List<Diet_diary> dietlist= new ArrayList<Diet_diary>();
		try{
		Connection conn= ConnectionFactory.getConnection();
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery("SELECT * FROM NAPLO");
		while(rs.next())
		{
			Diet_diary diary= new Diet_diary(rs.getInt(1),rs.getInt(2),new DateTime(rs.getDate(3)) ,rs.getInt(4),rs.getString(5),rs.getString(6),new Calorie(rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getInt(10)),new Calorie(rs.getInt(11),rs.getInt(12),rs.getInt(13),rs.getInt(14)));
			dietlist.add(diary);
		}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return dietlist;
	}
	
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
			
			}catch(SQLException e){
				e.printStackTrace();
			}
	}
		
	public void insertUser(Person person){
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
			ps.setString(8, "férfi");
			ps.setDouble(9, 1);
			ps.executeUpdate();
			
			}catch(SQLException e){
				e.printStackTrace();
			}
	}
	
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
			
			}catch(SQLException e){
				e.printStackTrace();
			}
	}


	

}
