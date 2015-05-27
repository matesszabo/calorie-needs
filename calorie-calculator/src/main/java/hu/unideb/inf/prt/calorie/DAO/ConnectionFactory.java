package hu.unideb.inf.prt.calorie.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A class for registering driver and creating a connection.
 * @author matesszabo
 *
 */
public class ConnectionFactory {
	/**
	 * A new instance of the ConnectionFactory.
	 */
	private static ConnectionFactory factory = new ConnectionFactory();

	/**
	 * URL of the database.
	 */
	static final String URL="";
	/**
	 * Connect to database with this username.
	 */
	static final String USERNAME="";
	/**
	 * Connect to database with this password.
	 */
	static final String PASSWORD="";
	/**
	 * Constructor of ConnectionFactory.
	 */
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
	
	/**
	 * A method to create a connection.
	 * Returns a connection.
	 * @return connection from DriverManager
	 */
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
	
	/**
	 * A method to get connection.
	 * Returns a connection from ConnectionFactory.
	 * @return a connection from ConnectionFactory
	 */
	public static Connection getConnection(){
		return factory.createConnection();
	}

}
