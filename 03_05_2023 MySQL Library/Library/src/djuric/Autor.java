package djuric;

import java.io.*;
import java.sql.*;
	
public class Autor {
	
	private String ime, prezime;
	private int autorID;
	private static Connection connection = DatabaseConnection.getConnection();
	
	public static void readTable() throws SQLException {
		
		String select = "SELECT * FROM autori";
		
		Statement statement = connection.createStatement();
		
		ResultSet resultSet = statement.executeQuery(select);
		
		System.out.println("\nIzgled tabele 'Autori':\n");
		
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
	}	
	
	public Autor create() throws Exception {
		
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	System.out.print("\nUnesite ime novog autora: ");   	
    	this.ime = br.readLine();
    	
    	System.out.print("\nUnesite prezime novog autora: ");   	
    	this.prezime = br.readLine();
    	
		String insert = "INSERT INTO autori (ime, prezime) VALUES (?, ?)";
    	
    	PreparedStatement preparedStatement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
    	
    	preparedStatement.setString(1, ime);
    	preparedStatement.setString(2, prezime);
    	
    	int executeUpdate = preparedStatement.executeUpdate();
    	
    	if(executeUpdate > 0) {
    		System.out.println("\nPodaci su uspesno uneti! ");
    		ResultSet rs = preparedStatement.getGeneratedKeys();
    		if (rs.next()) {
    			this.autorID = rs.getInt(1);
    		}
    	}
    	   	
    	preparedStatement.close();
    	
    	return this;
	}
    
    public void update() throws Exception {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	System.out.print("\nDa li zelite da promenite ime autora? y/n ");
    	char odgovor = br.readLine().charAt(0);
    	
    	if(odgovor == 'y') {
    		System.out.print("\nUnesite novo ime: ");   	
        	ime = br.readLine();
        	
        	String update = "UPDATE autori SET ime = ? WHERE autorID = ?";    	
        	PreparedStatement preparedStatement = connection.prepareStatement(update);
        	
        	preparedStatement.setString(1, ime);
        	preparedStatement.setInt(2, autorID);
        	
        	int executeUpdate = preparedStatement.executeUpdate();
        	
        	if(executeUpdate > 0)
        		System.out.println("\nIme autora je uspesno promenjeno! ");
    	}
    	
    	System.out.print("\nDa li zelite da promenite prezime autora? y/n ");
    	odgovor = br.readLine().charAt(0);
    	
    	if(odgovor == 'y') {
    		System.out.print("\nUnesite novo prezime: ");   	
        	prezime = br.readLine();
        	
        	String update = "UPDATE autori SET prezime = ? WHERE autorID = ?";    	
        	PreparedStatement preparedStatement = connection.prepareStatement(update);
        	
        	preparedStatement.setString(1, prezime);
        	preparedStatement.setInt(2, autorID);
        	
        	int executeUpdate = preparedStatement.executeUpdate();
        	
        	if(executeUpdate > 0) 
        		System.out.println("\nPrezime autora je uspesno promenjeno! ");
    	}

    }
    
    public void delete() throws Exception {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	System.out.print("\nDa ga brisemo? y/n ");
    	char odgovor = br.readLine().charAt(0);
    	
    	if(odgovor == 'y') {
    
	    	String delete = "DELETE FROM autori WHERE autorID = ?";
	    	
	    	PreparedStatement preparedStatement = connection.prepareStatement(delete);
	    	
	        preparedStatement.setInt(1, autorID);
	        
	        int executeDelete = preparedStatement.executeUpdate();
	        
	        if (executeDelete > 0) {
	        	System.out.println("\nAutor je uspesno obrisan iz baze! ");
	        }
    	}
    	else
    		System.out.println("\nOnda nista :)");
    }
}
