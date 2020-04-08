<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>David's Bookshelf</title>
</head>
<body>

	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Expires", "0"); // for proxy servers
	
		if(session.getAttribute("username")== null){
			
			response.sendRedirect("home.jsp"); 
		}
	%>
	
	Hello ${username}
	
	
	 
	Please pick from this variety of books 
	
	<form action="CartServlet" method="post">
			<input type="hidden" name="source" value="remove">
			<input type="hidden" name="student" value="${student}">
			<input type="hidden" name="courses" value="${courses}">
			<input type="hidden" name="userEmail" value="${username}">
			<input type="hidden" name="cart" value="${cart}">
			<div id="clear">
				<button type="submit" class="btn btn-primary btn-block">Clear cart</button>
			</div>
		</form>
		<form action="CartServlet" method="post">
			<input type="hidden" name="source" value="showcart">
			<input type="hidden" name="userEmail" value="${username}">
			<input type="hidden" name="cart" value="${cart}">
			<div id = "button">
				<button type="submit" class="btn btn-primary btn-block">Show cart</button>
			</div>
		</form>
		<hr />
		<!-- Display Students -->
		<div id="bookslist" class="BookshelfServlet">
			<c:forEach items="${books}" var="book">
				<br />
 				${book.getTitle()}
 				$${book.getPrice()}
				<form action="CartServlet" method="post">
					<input type="hidden" name="source" value="add">
					<input type="hidden" name="student" value="${student}">
					<input type="hidden" name="userEmail" value="${username}">
					<input type="hidden" name="bookId" value="${book.getBookId()}">
					<input type="hidden" name="courses" value="${courses}">
					<div id = "button">
						<button type="submit" class="btn btn-primary btn-block">Add</button>
					</div>
				</form>
			</c:forEach>
		</div>
	
	<form action="Logout">
		<input type ="submit" value= "Logout">
		
	</form>
</body>
</html>