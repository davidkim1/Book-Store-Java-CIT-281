package cit285.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cit285.project.domain.Books;

public class AddBookDao {
	
	private PreparedStatement pstB;

	public void connect(){
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/book_store", "root", "Popeyes chicken sandwich"); 
			pstB = con.prepareStatement("insert into book(AuthorFirstName, AuthorLastName, "
					+ "ISBN, Title, Editor, Edition, Year, Price) values(?,?,?,?,?,?,?,?)");
		} catch (Exception ex) {
			System.out.print("Error" + ex);
		}
	}
	
	public void addBook(Books book/*String authorFN, String authorLN,
			String ISBN, String Title, String Editor, String Edition, int year, int price*/) throws SQLException {
		
			connect();
			
			//pstU.setString(1, authorID);
			pstB.setString(1, book.getAuthorFName());
			pstB.setString(2, book.getAuthorLName());
			//pstU.setString(1, bookID);
			pstB.setString(3, book.getIsbn());
			pstB.setString(4, book.getTitle());
			pstB.setString(5, book.getEditor());
			pstB.setString(6, book.getEdition());
			pstB.setInt(7, book.getYear());
			pstB.setInt(8, book.getPrice());
			pstB.executeUpdate();
			//pstA.executeUpdate();
	}

}
