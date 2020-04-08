package cit285.project.presentation.web;

import java.io.IOException;
//import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cit285.project.config.BookStoreConfig;
import cit285.project.domain.Books;
//import cit285.project.services.BooksServices;
import cit285.project.services.BooksServicesAPI;

/**
 * Servlet implementation class BookshelfServlet
 */
@WebServlet("/BookshelfServlet")
public class BookshelfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BooksServicesAPI booksServices;
	
	public void init() throws ServletException {
    	try{
			//System.out.println("Configuring services...");
			BookStoreConfig.configureServices();
		}
		catch(Exception e){}
		//System.out.println("Getting payments services...");
		booksServices = BookStoreConfig.getBookServices();
	}
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		//String source = request.getParameter("source");

		
		ArrayList<Books> books = null;
			
		try {
			books = booksServices.getBooks();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			// Add attribute to the session
		session.setAttribute("books",books);
		
		
		//getServletContext().getRequestDispatcher("/WEB-INF/jsp/bookshelf.jsp").forward(request, response);
		response.sendRedirect("bookshelf.jsp");
	}
}
