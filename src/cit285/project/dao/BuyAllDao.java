package cit285.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cit285.project.domain.Buy;

public class BuyAllDao {
	
	private PreparedStatement pstU;

	public void connect(){
		
		/*
		 	InvoiceID INT NOT NULL AUTO_INCREMENT,
		 	UserID INT NOT NULL,
			InvoiceDate DATE NOT NULL,
            TotalAmount INT NOT NULL,
            IsProcessed VARCHAR(50) NOT NULL,
		 */
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/book_store?useTimezone=true&serverTimezone=UTC", "root", "Popeyes chicken sandwich"); 
			pstU = con.prepareStatement("insert into invoice(UserID, TotalAmount, IsProcessed) values(?,?,?)");
		} catch (Exception ex) {
			System.out.print("Error" + ex);
		}
	}
	
	public void buyAll(Buy buy) throws SQLException {
		
			connect();
			
			System.out.print("\nPassed Through the database at BuyAllDao\n");
		
			pstU.setInt(1, buy.getUserId());
			pstU.setInt(2, buy.getTotalAmount());
			pstU.setString(3, buy.getIsProcessed());
			pstU.executeUpdate();
			
	} 
	
	public int idGenerator() {
		
		
		return (int) ((Math.random() * ((100000 - 2) + 1)) + 2);
	}

}
