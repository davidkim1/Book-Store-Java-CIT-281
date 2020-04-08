<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Succesfully Added</title>
</head>
<body>

	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Expires", "0"); // for proxy servers
	
		if(session.getAttribute("username")== null){
			
			response.sendRedirect("home.jsp"); 
		}
	%>
	
	${title} has been successfully added!!
	
	<form action="Logout">
		<input type ="submit" value= "Logout">
		
	</form>

	<form action="goBackAdmin">
		<input type ="submit" value= "Go Back">
		
	</form>
</body>
</html>