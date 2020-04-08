package cit285.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrationDao {
	
	private PreparedStatement pstU;

	public void connect(){
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/book_store?useTimezone=true&serverTimezone=UTC", "root", "Popeyes chicken sandwich"); 
			pstU = con.prepareStatement("insert into user(UserID, FirstName, LastName, EmailAddress, Password, "
					+ "Address, City, State, Zip, Country) values(?,?,?,?,?,?,?,?,?,?)");
		} catch (Exception ex) {
			System.out.print("Error" + ex);
		}
	}
	
	public void addUser(String fname, String lname, String password, String emailAddress,
			String city, String state, int zip, String country, String address) throws SQLException {
		
			int id = idGenerator();
			pstU.setInt(1, id);
			pstU.setString(2, fname);
			pstU.setString(3, lname);
			pstU.setString(4, emailAddress);
			pstU.setString(5, password);
			pstU.setString(6, address);
			pstU.setString(7, city);
			pstU.setString(8, state);
			pstU.setInt(9, zip);
			pstU.setString(10, country);
			pstU.executeUpdate();
			
	} 
	
	public int idGenerator() {
		
		
		return (int) ((Math.random() * ((100000 - 2) + 1)) + 2);
	}
}
