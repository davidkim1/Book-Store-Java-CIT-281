package cit285.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
//import cit285.project.domain.User;

public class LoginDao {
	
	public int checkLogIn(String uname, String password) {
		
		System.out.println(" Estoy en checking log in ");
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/book_store?useTimezone=true&serverTimezone=UTC", "root", "Popeyes chicken sandwich");

            java.sql.Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("select * from user");

            while (rs.next()) {

                if ((rs.getString("EmailAddress").equals(uname)) && rs.getString("Password").equals(password)) {

                    int stp = rs.getInt("UserID");

                    if (stp == 1) {

                        return 1;

                    } else {

                        return 2;

                    }

                }

            }
		}
			catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
