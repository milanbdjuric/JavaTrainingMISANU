package djuric;

import java.sql.*;

public class DatabaseConnection {
	
	private static Connection connection;
	
	public static Connection getConnection() {
		
		try {
			String url = "jdbc:mysql://localhost:3306/biblioteka";
			String username = "root";
			String password = "";
		
			connection = DriverManager.getConnection(url, username, password);
		
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Radi veza! ");
		
		return connection;
	}
}
