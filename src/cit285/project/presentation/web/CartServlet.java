package cit285.project.presentation.web;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cit285.project.config.BookStoreConfig;
import cit285.project.domain.Books;
import cit285.project.domain.Cart;
import cit285.project.domain.User;
import cit285.project.services.BooksServicesAPI;
import cit285.project.services.UserServicesAPI;

/**
 * Servlet implementation class PaymentsServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BooksServicesAPI bookServices;
	private UserServicesAPI userServices;
    
    @Override
    public void init() throws ServletException {
    	try{
		
			BookStoreConfig.configureServices();
		}
		catch(Exception e){}
		bookServices = BookStoreConfig.getBookServices();
		userServices = BookStoreConfig.getUserServices();
	}
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		HttpSession session = request.getSession();
		String source = request.getParameter("source");
		Cart cart = new Cart(); //(Cart)session.getAttribute("cart");
		User user =  null;
		String userEmail = null;
		
		System.out.println("\n\n\n\n"+cart+" este es el carrito\n\n\n\n\n");
		
		
		int userId = 0;
		
		try {
			userEmail = request.getParameter("userEmail");
			
		}catch(NumberFormatException nfe) {
			System.out.println("String not pursable to int... ");
		}
		
		System.out.println("\nESTOY EN CART SERVLET. EL EMAIL = " + userEmail);
		
		user = userServices.getUser(userEmail);
		
		System.out.print(user.getFirstname() + " fsdfsd ");
		
		userId = user.getId();
		
		
		if (source.equals("add")){
			int bookId = 0;
			
			try {
				bookId = Integer.parseInt(request.getParameter("bookId"));
				
			}catch(NumberFormatException nfe) {
				System.out.println("String not pursable to int... ");
			}
			
			System.out.println("\n\n\n\nthis is the bookId: "+bookId +"\n\n\n");
			
			Books book = bookServices.getBooks(bookId);
			
			System.out.print(book.getAuthorFName());
				     
			cart.addBook(book);
			
			session.setAttribute("cart",cart);
			session.setAttribute("bookscart", cart);
			session.setAttribute("userId",userId);
			
			response.sendRedirect("bookshelf.jsp");
		}
		else if(source.equals("remove")) {
			
			int bookId = 0;
			
			try {
				bookId = Integer.parseInt(request.getParameter("bookId"));
				
			}catch(NumberFormatException nfe) {
				System.out.println("String not pursable to int... ");
			}
			
			Books book = bookServices.getBooks(bookId);
			
			cart.removeBook(book);
			
			// Add cart back to the session
			session.setAttribute("cart",cart);
			session.setAttribute("userId",userId);
			
			response.sendRedirect("bookshelf.jsp");
		}
		else if(source.equals("clear")) {
			cart.clear();
		
			session.setAttribute("cart",cart);
			session.setAttribute("userId",userId);
			
			response.sendRedirect("bookshelf.jsp");
		}
		else if(source.equals("showcart")) {
			Cart cart1 =(Cart)session.getAttribute("cart");
			Set<Books> bookscart = cart1.getBookss();
			// Add cart back to the session
			
			if (bookscart == null) {
				
				
			}
			session.setAttribute("bookscart",bookscart);
			session.setAttribute("userId",userId);
			
			System.out.print( " \n\n\n\n\nThis is the car"+cart1 +" Gabe itches \n\n\n\n\n ");
			
			for(Books s: bookscart) {
				
				System.out.print(" ----------This is the car"+ s.getTitle()+" Gabe itches -------- ");
			}
			
			response.sendRedirect("cart.jsp");
			session.setAttribute("bookscart",bookscart);
			session.setAttribute("userId",userId);
		}
		else{
			session.setAttribute("cart",cart);
			session.setAttribute("Error","Unknown source!");
			response.sendRedirect("bookshelf.jsp");
			}
		}
}
		/*if (source.equals("add")){
			int bookId = 0;
			String userEmail = null, bookTitle = null;
			int userId = 0;
			
			try {
				bookId = Integer.parseInt(request.getParameter("bookId"));
				userEmail = request.getParameter("userEmail");
				
			}catch(NumberFormatException nfe) {
				System.out.println("String not pursable to int... ");
			}
			
			Books book = bookServices.getBooks(bookId);
			User user = userServices.getUser(userEmail);
			
			userId = user.getId();
			bookTitle = book.getTitle();
	
			// Add course to the cart
			cart1.addBook(book); // CHANGED TO CART1
			cart1.setUserId(userId);
			
			try {
				cartDao.addToCart(cart1);
				System.out.print("Professor");
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.print("You've got an error in addBook in source = add");
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.print("You've got an error in addBook in source = add");
				e.printStackTrace();
			}
			
			// Add cart back to the session
			session.setAttribute("cart",cart1); // I AM NOT SURE!! CHANGED TO CART 1
			
			response.sendRedirect("bookshelf.jsp");
			//getServletContext().getRequestDispatcher("/WEB-INF/jsp/courseslist.jsp").forward(request, response);
		}
		else if(source.equals("remove")) {
			
			// remove the course from the cart
			
			int bookId = 0;
			String userEmail = null;
			int userId = 0;
			FSDm
			try {
				bookId = Integer.parseInt(request.getParameter("bookId"));
				userEmail = request.getParameter("userEmail");
				
			}catch(NumberFormatException nfe) {
				System.out.println("String not pursable to int... ");
			}
			
			Books book = bookServices.getBooks(bookId);
			User user = userServices.getUser(userEmail);
			
			userId = user.getId();
			
			cart1.setUserId(userId);
			cart1.removeBook(book); // CHANGED TO CART
		}
		else if(source.equals("clear")) {
			cart.clear();
			
			session.setAttribute("cart",cart);
			
			
			response.sendRedirect("bookshelf.jsp");
			
		}
		else if(source.equals("showcart")) {
			
			String userEmail = null;
			int userId = 0;
			
			try {
				userEmail = request.getParameter("userEmail");
				
			}catch(NumberFormatException nfe) {
				System.out.println("String not pursable to int... ");
			}
		
			User user = userServices.getUser(userEmail);
			
			System.out.print(" Estoy en showcart ");
			
			userId = user.getId();
			
			System.out.print(" User Id es " + userId + " ");
			
			Set<Cart> bookscart = null;
			
			try {
				System.out.print(" Estoy antes de bookscart ");
				bookscart = bookServices.getCart(userId);
				System.out.print(" Estoy despues de bookscart ");
			} catch (Exception e) {
				System.out.print("You've got an error in Showcart Cart Servlet");
			}
			
			session.setAttribute("bookscart",bookscart);
			
			response.sendRedirect("cart.jsp");
		}
		 
		else {
			session.setAttribute("cart",cart);
			session.setAttribute("Error","Unknown source!");
			response.sendRedirect("bookshelf.jsp");
		}*/	

