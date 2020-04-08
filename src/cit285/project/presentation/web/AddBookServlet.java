package cit285.project.presentation.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cit285.project.config.BookStoreConfig;
import cit285.project.dao.AddBookDao;
import cit285.project.domain.Books;
import cit285.project.services.BooksServicesAPI;

/**
 * Servlet implementation class AddBook
 */
@WebServlet("/AddBook")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BooksServicesAPI bookServices;
	AddBookDao dao = new AddBookDao();
	
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
		//String AuthorID = request.getParameter("authorID");
		
		String AuthorFname = request.getParameter("authorFN");
		String AuthorLname = request.getParameter("authorLN");
		//String BookID = request.getParameter("bookId");
		String isbn = request.getParameter("ISBN");
		String title = request.getParameter("bookTitle");
		String editor = request.getParameter("editor");
		String edition = request.getParameter("edition");
		//String year1= request.getParameter("year");
		//Integer year = Integer.parseInt(year1);
		Integer year = Integer.parseInt(request.getParameter("Year"));
		Integer price = Integer.parseInt(request.getParameter("Price"));
		
		System.out.print(AuthorFname);
		System.out.print(AuthorLname);
		System.out.print(isbn);
		System.out.print(title);
		
		
		
		//AddBookDao dao = new AddBookDao();
		//dao.connect();
		PrintWriter out = response.getWriter();
		
		if(AuthorFname.length() == 0 || AuthorLname.length() == 0 || /*BookID.length() == 0 ||*/
				isbn.length() == 0 || title.length() == 0|| editor.length() == 0  ||
				edition.length() == 0  ||  year == null || price == null) {
			
		//if(book.getAuthorFName().length() == 0 || book.getAuthorLName().length() == 0 || /*BookID.length() == 0 ||*/
		//		book.getIsbn().length() == 0 || book.getTitle().length() == 0|| book.getEditor().length() == 0  ||
		//		book.getEdition().length() == 0  ||  book.getYear() == null || price == null) {
			
			
			out.println("All spaces must be filled in");
		}
		
		else{
			
			Books book = new Books();
			
			book.setAuthorFName(AuthorFname);
			book.setAuthorLName(AuthorLname);
			book.setIsbn(isbn);
			book.setTitle(title);
			book.setEditor(editor);
			book.setEdition(edition);
			book.setYear(year);
			book.setPrice(price);
			System.out.print(" Estoy en addBook ");
			System.out.print(book.getAuthorFName());
			
			bookServices.addBook(book);
			
			out.println(book.getTitle() + " has been added to the database");
			HttpSession session = request.getSession();
			session.setAttribute("title", book.getTitle()); 
			response.sendRedirect("bookAdded.jsp");
		}
	}
}
