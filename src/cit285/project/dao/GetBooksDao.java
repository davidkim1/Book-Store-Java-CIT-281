package cit285.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import cit285.project.domain.Books;

public class GetBooksDao {
	
	public Books getBooks(int bookId)
			throws SQLException, ClassNotFoundException {
		
		Books book = new Books();

        Connection con = connect();

        java.sql.Statement st = con.createStatement();

        ResultSet rs = st.executeQuery("select * from book where BookID = " + bookId);
		
		// Iterate through the result and print
		if(rs.next()) {
			
			book.setBookId(rs.getInt(1));
			book.setAuthorFName(rs.getString(2));
			book.setAuthorLName(rs.getString(3));
			book.setIsbn(rs.getString(4));
			book.setTitle(rs.getString(5));
			book.setEditor(rs.getString(6));
			book.setEdition(rs.getString(7));
			book.setYear(rs.getInt(8));
			book.setPrice(rs.getInt(9));
		}
		else {
			book = null;
		}
		
		return book;
	}
	
	public Books getBook(String title)
			throws SQLException, ClassNotFoundException {
		
		Books book = new Books();

        Connection con = connect();

        java.sql.Statement st = con.createStatement();
        System.out.print(title);

        ResultSet rs = st.executeQuery("select * from book where Title = '" + title +"'");

		if(rs.next()) {
			book.setBookId(rs.getInt(1));
			book.setAuthorFName(rs.getString(2));
			book.setAuthorLName(rs.getString(3));
			book.setIsbn(rs.getString(4));
			book.setTitle(rs.getString(5));
			book.setEditor(rs.getString(6));
			book.setEdition(rs.getString(7));
			book.setYear(rs.getInt(8));
			book.setPrice(rs.getInt(9));
		}
		else {
			book = null;
		}
		
		return book;
	}
	
	public ArrayList<Books> getBooksList() {
		System.out.print("Hello");
		
		ArrayList<Books> booksList = new ArrayList<>();
		
		Connection connection;
		try {
			
			System.out.print("ArrayList");
			connection = connect();

			// Create statement
			Statement statement = connection.createStatement();
			
			// Execute statement
			ResultSet rs = statement.executeQuery("select * from book");
			
			// Iterate through the result and print
			while(rs.next()) {
				Books book = new Books();
				book.setBookId(rs.getInt(1));
				book.setAuthorFName(rs.getString(2));
				book.setAuthorLName(rs.getString(3));
				book.setIsbn(rs.getString(4));
				book.setTitle(rs.getString(5));
				book.setEditor(rs.getString(6));
				book.setEdition(rs.getString(7));
				book.setYear(rs.getInt(8));
				book.setPrice(rs.getInt(9));
				
				booksList.add(book);
				
			}
			return booksList;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return booksList;
	}
	
	private Connection connect() 
			throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// Connect to the database
		Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost/book_store", "root", "Popeyes chicken sandwich");
		
		return connection;
	}
}
