package cit285.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import cit285.project.domain.User;

public class GetUserDao {
	

public User getUser(String userEmail) {
	
	User user = new User();
		
	try {
			
		Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/book_store?useTimezone=true&serverTimezone=UTC", "root", "Popeyes chicken sandwich");

        java.sql.Statement st = con.createStatement();
        
        System.out.println(userEmail);

        ResultSet rs = st.executeQuery("select * from user where EmailAddress = '" + userEmail +"'");

        System.out.println("  Estoy en GetBookDao User getUser ");
        
        if(rs.next()) {
        	
        	System.out.print("User's been found");
        	
        	user.setId(rs.getInt(1));
			user.setFirstname(rs.getString(2));
			user.setLastname(rs.getString(3));
			user.setEmail(rs.getString(4));
			user.setPassword(rs.getString(5));
			user.setAddress(rs.getString(6));
			user.setCity(rs.getString(7));
			user.setState(rs.getString(8));
			user.setZip(rs.getInt(9));
			user.setCountry(rs.getString(10));
        	
        }
        else {
        	System.out.print("User not  found");
		}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.print("  QLQ ");
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.print(" QLQ1  ");
		e.printStackTrace();
	}
		return user;
	}
}
		
		
				// Iterate through the result and print
				/*if(rs.next()) {
					System.out.print("  Estoy en LoginDao User getUser Hello ");
					user.setId(rs.getInt(1));
					user.setFirstname(rs.getString(2));
					user.setLastname(rs.getString(3));
					user.setEmail(rs.getString(4));
					user.setPassword(rs.getString(5));
					user.setAddress(rs.getString(6));
					user.setCity(rs.getString(7));
					user.setState(rs.getString(8));
					user.setZip(rs.getInt(9));
					user.setCountry(rs.getString(10));
					
					System.out.print("  Estoy en LoginDao User getUser (ABAJO) ");
					System.out.print(user.getFirstname() + " ");
				}*/