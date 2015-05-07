package hu.unideb.inf.prt.calorie.DAO;

import hu.unideb.inf.prt.calorie.Model.Calorie;
import hu.unideb.inf.prt.calorie.Model.Food;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAO {
	public List<Food> getFoodlist(){
		List<Food> foodlist= new ArrayList<Food>();
		try{
		Connection conn= ConnectionFactory.getConnection();
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery("SELECT * FROM KAJAK");
		while(rs.next())
		{
			Food food = new Food(rs.getInt(1),rs.getString(2),new Calorie(rs.getDouble(3),rs.getDouble(4),rs.getDouble(5),rs.getDouble(6)),rs.getDouble(7),rs.getString(8));
			foodlist.add(food);
		}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return foodlist;
	}
		
	

}
