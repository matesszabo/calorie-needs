package hu.unideb.inf.prt.calorie.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionFactory {
	private static ConnectionFactory factory = new ConnectionFactory();
	//private static Logger logger = LoggerFactory.getLogger(ConnectionFactory.class);

	
	static final String URL="";
	static final String USERNAME="";
	static final String PASSWORD="";
	
	private ConnectionFactory(){
		try{
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			//logger.debug("driver registered");
		}catch(SQLException e){
			e.printStackTrace();
			//logger.error("failed to register driver");
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
		//logger.debug("connection created");
		return connection;
	}
	
	public static Connection getConnection(){
		return factory.createConnection();
	}

}
