package cit285.project.presentation.web;

import java.io.IOException;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cit285.project.dao.BuyAllDao;
import cit285.project.domain.Buy;

/**
 * Servlet implementation class BuyAllServlet
 */
@WebServlet("/BuyAllServlet")
public class BuyAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//UserID, InvoiceDate, TotalAmount, IsProcessed
		
		Buy buy = new Buy();
		
		int userId = Integer.parseInt(request.getParameter("userId"));
		int totalAmount = Integer.parseInt(request.getParameter("price"));
		String isProcessed = "Yes";
		
		System.out.println(userId);
		System.out.println(totalAmount);
		System.out.println(isProcessed);
			
		buy.setUserId(userId); 
		buy.setTotalAmount(totalAmount);
		buy.setIsProcessed(isProcessed);
		
		BuyAllDao dao = new BuyAllDao();
			
		try {
		
			dao.buyAll(buy);
			HttpSession session = request.getSession();
			session.setAttribute("userId", userId); 
			response.sendRedirect("successfullBuy.jsp"); 
			 
		}
		catch (SQLException e) {
				System.out.print("Hey! you've got an error here bro ");
				e.printStackTrace();
		}
	}

}
