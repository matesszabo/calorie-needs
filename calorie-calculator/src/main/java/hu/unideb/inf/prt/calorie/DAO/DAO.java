package hu.unideb.inf.prt.calorie.DAO;

import hu.unideb.inf.prt.calorie.Model.Calorie;
import hu.unideb.inf.prt.calorie.Model.Diet_diary;
import hu.unideb.inf.prt.calorie.Model.Food;
import hu.unideb.inf.prt.calorie.Model.Person;

import java.sql.Connection;
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
			Person person = new Person(rs.getInt(1),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getString(8),rs.getInt(9));
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
		
	

}
