package cit285.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import cit285.project.domain.Books;

public class DeleteBookDao {
	
	public void deleteBook(Books book) {
		
		PreparedStatement pstB;
			
			try {
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/book_store?useTimezone=true&serverTimezone=UTC", "root", "Popeyes chicken sandwich"); 
				pstB = con.prepareStatement("delete from book where BookID = " + book.getBookId());
				pstB.executeUpdate();
				//st.setString(1, title);
				//ResultSet rs = st.executeUpdate(); // fix this
				//if(rs.next()) {
				//	return true;
				//}
			}catch (Exception e) {
				System.out.print("You've got an error in DeleteBookDao bro ");
				e.printStackTrace();
			}
		}



}
