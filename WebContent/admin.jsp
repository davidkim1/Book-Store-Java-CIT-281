<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Expires", "0"); // for proxy servers
	
		if(session.getAttribute("username")== null){
			
			response.sendRedirect("home.jsp"); 
		}
	%>
	Would you like to add a book or remove any book(s)?
	
	
	<form action="AddBook" method="post">
		Enter Author First Name: <input type= "text" name="authorFN"><br>
		Enter Author Last Name: <input type= "text" name="authorLN"><br>
		Enter ISBN: <input type= "text" name="ISBN"><br>
		Enter Book Title: <input type= "text" name="bookTitle"><br>
		Enter Editor: <input type= "text" name="editor"><br>
		Enter Edition: <input type= "text" name="edition"><br>
		Enter Year: <input type= "number" name="Year"><br>
		Enter Price: <input type= "number" name="Price"><br>
		<input type= "submit" value= "Add Book">
	</form>
	
	<form action="DeleteBook" method="post">
		Enter Book Title: <input type= "text" name="bookTitle"><br>
		<input type= "submit" value= "Delete Book">
	</form>
	
	<form action="Logout">
		<input type ="submit" value= "Logout">
		
	</form>
</body>
</html>