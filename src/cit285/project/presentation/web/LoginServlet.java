package cit285.project.presentation.web;

import java.io.IOException;
//import java.sql.Connection;
//import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cit285.project.dao.LoginDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String email = request.getParameter("uname");
		String pass = request.getParameter("pass");
		
		LoginDao dao = new LoginDao();
		
		if(dao.checkLogIn(email.toLowerCase(),pass)==1) {
			
			HttpSession session = request.getSession();
			session.setAttribute("username", email); 
			response.sendRedirect("admin.jsp"); 
		}
		else if(dao.checkLogIn(email,pass)==2) {
			
			HttpSession session = request.getSession();
			session.setAttribute("username", email); 
			getServletContext().getRequestDispatcher("/BookshelfServlet").forward(request, response);
		}
		else{
			
			response.sendRedirect("IncorrectLogin.jsp");
		}
	
	}


}
