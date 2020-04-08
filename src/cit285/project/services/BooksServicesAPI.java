package cit285.project.services;

import java.util.ArrayList;
import java.util.Set;

import cit285.project.domain.Books;
import cit285.project.domain.Cart;

public interface BooksServicesAPI {

	public Books getBooks(int userId);
	
	public Set<Cart> getCart(int userId);
	
	//public Course getCourse(int courseId);
	
	public ArrayList<Books> getBooks();
	
	public Cart createCart();

	public Cart getCartBooks(int userId);

	public Books getBook(String bookTitle);

	public void addBook(Books book);

	public void deleteBook(Books book);
}
