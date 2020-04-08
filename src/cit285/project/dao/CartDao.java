package cit285.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import cit285.project.domain.Books;
import cit285.project.domain.Cart;

public class CartDao {
	private PreparedStatement crt; // for addToCart
	
	public void addToCart(Cart cart)
			throws SQLException, ClassNotFoundException {
		/*
		 
		          CartID INT NOT NULL AUTO_INCREMENT,
				  UserID INT NOT NULL,
				  BookID BIGINT NOT NULL,
				  BookTitle
				  Quantity INT NOT NULL,
		 */
		
		Set<Books> books = cart.getBookss();
		
		System.out.print("Hello Motto");
		
		int qty = 1;

        Connection con = connect();

        crt = con.prepareStatement("insert into Cart(UserID, BookID, BookTitle, Quantity, Price) values(?,?,?,?,?)");
        
        for(Books b: books) {
        	//crt.setInt(1, cart.getUserId());
    		crt.setInt(2, b.getBookId());
    		crt.setString(3, b.getTitle());
    		crt.setInt(4, qty);
    		crt.setInt(5, b.getPrice());
    		crt.executeUpdate();
    		
    		System.out.print(b.getBookId() +"BOB"+ b.getTitle());
        }
		
		System.out.print("Hello maria bonita");
	}
	

	public Set<Cart> getCartBooksList(int userId) {
		System.out.print(" Estoy en getCartBooksList en CartDao ");
		
		Set<Cart> cartBooksList = new HashSet<>();
		//Books book = null;
		
		// Get Db connection
		Connection connection;
		try {
			
			System.out.print("Hola");
			connection = connect();

			// Create statement
			java.sql.Statement statement = connection.createStatement();
			
			// Execute statement
			ResultSet rs =  statement.executeQuery("select * from Cart where UserID = " + userId);
	
			while(rs.next()) {
				Cart cart = new Cart();
				//cart.setCartId(rs.getInt(1));
				//cart.setUserId(rs.getInt(2));
				//cart.setBookId(rs.getInt(3));
				cart.setBookTitle(rs.getString(4));
				cart.setQuantity(rs.getInt(5));
				cart.setPrice(rs.getInt(6));
				
				cartBooksList.add(cart);
				
			}
			return cartBooksList;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cartBooksList;
	}
	
	public void removeFromCart(Cart cart)
			throws SQLException, ClassNotFoundException {
		/*
		 
		          CartID INT NOT NULL AUTO_INCREMENT,
				  UserID INT NOT NULL,
				  BookID BIGINT NOT NULL,
				  BookTitle
				  Quantity INT NOT NULL,
		 */
		
		Set<Books> books = cart.getBookss();
		
		System.out.print("Hello Motto");
		
		int qty = 1;

        Connection con = connect();

        crt = con.prepareStatement("insert into Cart(UserID, BookID, BookTitle, Quantity, Price) values(?,?,?,?,?)");
        
        for(Books b: books) {
        	//crt.setInt(1, cart.getUserId());
    		crt.setInt(2, b.getBookId());
    		crt.setString(3, b.getTitle());
    		crt.setInt(4, qty);
    		crt.setInt(5, b.getPrice());
    		crt.executeUpdate();
    		
    		System.out.print(b.getBookId() +"BOB"+ b.getTitle());
        }
		
		System.out.print("Hello maria bonita");
	}
	
	private Connection connect() 
			throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// Connect to the database
		Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost/book_store?useTimezone=true&serverTimezone=UTC", "root", "Popeyes chicken sandwich");
		
		return connection;
	} 

}
