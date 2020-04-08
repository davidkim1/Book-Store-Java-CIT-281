package cit285.project.services;

//import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;

import cit285.project.dao.AddBookDao;
import cit285.project.dao.CartDao;
import cit285.project.dao.DeleteBookDao;
import cit285.project.dao.GetBooksDao;
import cit285.project.domain.Books;
import cit285.project.domain.Cart;

public class BooksServices implements BooksServicesAPI{
	GetBooksDao booksDao;
	CartDao cartDao;
	AddBookDao addBookDao;
	DeleteBookDao deleteBookDao;
	
	public BooksServices() {
		booksDao = new GetBooksDao();
		cartDao = new CartDao();
		addBookDao = new AddBookDao();
		deleteBookDao = new DeleteBookDao();
	}
	
	public Set<Cart> getCart(int userId){
		Set<Cart> cart = null;
		System.out.println(" Estoy en bookServices ");
		try {
			System.out.println(" Estoy antes de bookServices (try) ");
			cart = cartDao.getCartBooksList(userId);
			System.out.print(" Estoy despues de bookServices (try) ");
		}catch (Exception e) {	
			System.out.println(" Error en getCart en BookServices " + e.toString());
		}
		return cart;
	}

	public Cart getCartBooks(int userId){
		Cart cart = null;
		
		try {
		//	/*cart = (Cart) cartDao.getCartBooksList(userId);*/
		}catch (Exception e) {
			System.out.println(e.toString());
		}
		return cart;
	}
		
	// Create a new Cart
	public Cart createCart() {
		return new Cart();
	}

	@Override
	public Books getBooks(int bookId) {
		// TODO Auto-generated method stub
		Books book = null;
		
		try {
			book = booksDao.getBooks(bookId);
		}catch (Exception e) {
			System.out.println(e.toString());
		}
		return book;
	}

	public Books getBook(String title) {
		// TODO Auto-generated method stub
		Books book = null;
		
		try {
			book = booksDao.getBook(title);
		}catch (Exception e) {
			System.out.println(e.toString());
		}
		return book;
	}
	
	
	public ArrayList<Books> getBooks(){
		ArrayList<Books> books = null;
		
		try {
			books = booksDao.getBooksList();
		}catch (Exception e) {
			System.out.println(e.toString());
		}
		return books;
	}

	public void addBook(Books book) {
		
		try {
			addBookDao.addBook(book);
		}catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public void deleteBook(Books book) {

		try {
			deleteBookDao.deleteBook(book);
		}catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
