package djuric;

import java.sql.*;

public class Biblioteka {

	public static void read() {
		
		// READ
		
		String url = "jdbc:mysql://localhost:3306/biblioteka";
		String user = "root";
		String pass = "";
		
		try(Connection connection = DriverManager.getConnection(url, user, pass)){
		
		String select = "SELECT * FROM autori";
		
		Statement statement = connection.createStatement();
		
		ResultSet resultSet = statement.executeQuery(select);
		
		System.out.println("\nIzgled tabele:\n");
		
		while(resultSet.next()) {
			
			String ime = resultSet.getString(2);
			String prezime = resultSet.getString(3);
			
			StringBuilder stringBuilder = new StringBuilder();
			
			stringBuilder.append("Ime: ");
			stringBuilder.append(ime);
			stringBuilder.append(", Prezime: ");
			stringBuilder.append(prezime);

			
			System.out.println(stringBuilder.toString());
			}	
		}catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/biblioteka";
		String user = "root";
		String pass = "";
		
		try(Connection connection = DriverManager.getConnection(url, user, pass)){
			
		System.out.println("Radi veza!");
		
		read();
		
		
		// CREATE
		
		
		String insert = "INSERT INTO autori(ime, prezime) VALUES (?, ?)";
		
		PreparedStatement preparedStatement = connection.prepareCall(insert);
		
		preparedStatement.setString(1, "Branko");
		preparedStatement.setString(2, "Copic");
		
		int executeInsert = preparedStatement.executeUpdate();
		
		if(executeInsert > 0)
			System.out.println("\nPodaci uneti!");
		
		
		read();
		
		
		// UPDATE
		
		
		String update = "UPDATE autori SET prezime = ? WHERE prezime = ?";
		
		preparedStatement = connection.prepareCall(update);
		
		preparedStatement.setString(1, "Kockica");
		preparedStatement.setString(2, "Copic");
		
		int executeUpdate = preparedStatement.executeUpdate();
		
		if(executeUpdate > 0)
			System.out.println("\nIzmena je uneta!");
		
		
		read();
		
		
		// DELETE
		
		
		String delete = "DELETE from autori WHERE prezime = ?";
		
		preparedStatement = connection.prepareCall(delete);
		
		preparedStatement.setString(1, "Kockica");
		
		int executeDelete = preparedStatement.executeUpdate();
		
		if(executeDelete > 0)
			System.out.println("\nPodatak je obrisan!");
		
		read();
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
