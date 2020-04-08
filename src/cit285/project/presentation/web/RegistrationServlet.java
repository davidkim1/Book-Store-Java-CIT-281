package cit285.project.presentation.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cit285.project.dao.RegistrationDao;

//import cit285.project.dao.WebsiteDao;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String sAddress = request.getParameter("sAddress");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
		String country = request.getParameter("country");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		int zip1 = Integer.parseInt(zip);	
		
		RegistrationDao dao = new RegistrationDao();
		dao.connect();
			
		try {
		
		if(fname.length() == 0 ||lname.length()== 0 || sAddress.length()== 0 || city.length()== 0 ||state.length()== 0 ||
				zip.length()== 0 || country.length()== 0 ||email.length()== 0 || pass.length()== 0) {
			
			
			response.sendRedirect("IncorrectLogin.jsp"); // SEND TO ALL FIELDS MUST BE FILLED
		}
		
		else{
				dao.addUser(fname, lname, pass, email, city, state, zip1, country, sAddress);
				HttpSession session = request.getSession();
				session.setAttribute("username", email); 
				getServletContext().getRequestDispatcher("/BookshelfServlet").forward(request, response);
			} 
		}
		catch (SQLException e) {
				System.out.print("Hey! you've got an error here bro ");
				e.printStackTrace();
		}
	}
}

