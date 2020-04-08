package cit285.project.domain;

import java.util.HashSet;
import java.util.Set;

//import java.sql.SQLException;
//import java.util.HashSet;
//import java.util.Set;

//import cit285.project.dao.CartDao;


/* 				  CartID INT NOT NULL AUTO_INCREMENT,
				  UserID INT NOT NULL,
				  BookID BIGINT NOT NULL,
				  Quantity INT NOT NULL,
	*/

public class Cart {
	
	private String bookTitle;
	private Integer quantity;
	private Integer price;

	private User user;
	private Set<Books> bookss; // No duplicate courses in the set.
	//CartDao cartDao = new CartDao();

	public Cart() {
		user = new User();
		bookss = new HashSet<>();
	}
	
	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
	
	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	/*public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}*/

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
	
	public void addBook(Books books) {
		bookss.add(books);
	}
	
	public void removeBook(Books books) {
		bookss.remove(books);
	}
	
	public Set<Books> getBookss() {
		return bookss;
	}
	
	/*
	 * public void addToDataBase(Set<Books> bookss) {
		for(Books b: bookss) {
			try {
				cartDao.addToCart(b);
			} catch (ClassNotFoundException e) {
				System.out.print("Got an error in Cart Domain addToDataBase ");
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.print("Got an error in Cart Domain addToDataBase ");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}*/
	/*
	public Books findCourse(String bookId) {
		Books b = null;
		
		for(Books book: bookss) {
			if(bookss.getBookId().equals(bookId))
				b = book;
		}
		return b;
	}*/
	
	public void clear() {
		bookss.clear();
	}
}
