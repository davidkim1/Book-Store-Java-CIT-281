package cit285.project.presentation.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import cit285.project.config.BookStoreConfig;
import cit285.project.dao.DeleteBookDao;
import cit285.project.domain.Books;
import cit285.project.services.BooksServicesAPI;

/**
 * Servlet implementation class DeleteBook
 */
@WebServlet("/DeleteBook")
public class DeleteBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BooksServicesAPI bookServices;
	DeleteBookDao dao = new DeleteBookDao();
	
	public void init() throws ServletException {
    	try{
			//System.out.println("Configuring services...");
			BookStoreConfig.configureServices();
		}
		catch(Exception e){}
		//System.out.println("Getting payments services...");
		bookServices = BookStoreConfig.getBookServices();
	}
   
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//HttpSession session = request.getSession();
		 
		PrintWriter out = response.getWriter();
		
		String bookTitle = request.getParameter("bookTitle");
		
		if(bookTitle.length() == 0) {
			
			
			out.println("Title needs to be filled");
		}
		
		else {
			
			Books book = bookServices.getBook(bookTitle);
			
			System.out.println(bookTitle+"yooooooo");
			System.out.println(book.getAuthorFName()+ "YO WASUP");
			bookServices.deleteBook(book);
			//dao.deleteBook(bookId);
			
		response.sendRedirect("admin.jsp");
		}
	
	}
}
