package djuric;

import java.sql.*;

public class Biblioteka {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/biblioteka";
		String user = "root";
		String pass = "";
		
		try(Connection connection = DriverManager.getConnection(url, user, pass)){
			
		System.out.println("Radi veza!");
		
		// CREATE
		
		String insert = "INSERT INTO autori(ime, prezime, bibliotekaID) VALUES (?, ?, ?)";
		
		PreparedStatement preparedStatement = connection.prepareCall(insert);
		
		preparedStatement.setString(1, "Branko");
		preparedStatement.setString(2, "Copic");
		preparedStatement.setInt(3, 1);
		
		int exec = preparedStatement.executeUpdate();
		
		if(exec > 0)
			System.out.println("Podaci uneti!");
		
		
		// READ
		
		
		String select = "SELECT * FROM autori";
		
		Statement statement = connection.createStatement();
		
		ResultSet resultSet = statement.executeQuery(select);
		
		while(resultSet.next()) {
			
			String ime = resultSet.getString(2);
			String prezime = resultSet.getString(3);
			
			StringBuilder sBuilder = new StringBuilder();
			
			sBuilder.append("Ime: ");
			sBuilder.append(ime);
			sBuilder.append("\nPrezime: ");
			sBuilder.append(prezime);

			
			System.out.println(sBuilder.toString());
		}
		
		
		
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

}