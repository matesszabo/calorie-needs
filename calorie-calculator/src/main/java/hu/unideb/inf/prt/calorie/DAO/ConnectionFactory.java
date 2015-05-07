package hu.unideb.inf.prt.calorie.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static ConnectionFactory factory = new ConnectionFactory();
	
	static final String URL="";
	static final String USERNAME="";
	static final String PASSWORD="";
	
	private ConnectionFactory(){
		try{
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("Hiba a driver regisztrálása során");
			System.exit(1);
		}
	}
	
	private Connection createConnection(){
		Connection connection=null;
		
		try {
			connection=DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public static Connection getConnection(){
		return factory.createConnection();
	}

}
