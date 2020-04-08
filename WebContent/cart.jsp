<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart</title>
</head>
<body>
<form action="CartServlet" method="post">
			<input type="hidden" name="source" value="clear">
			<input type="hidden" name="student" value="${student}">
			<input type="hidden" name="courses" value="${courses}">
			<input type="hidden" name="cart" value="${cart}">
			<div id="clear">
				<button type="submit" class="btn btn-primary btn-block">Clear cart</button>
			</div>
		</form>
		<form action="backToBookshelf" method="post">
			<input type="hidden" name="source" value="">
			<input type="hidden" name="cart" value="${cart}">
			<div id = "button">
				<button type="submit" class="btn btn-primary btn-block">Back to bookshelf</button>
			</div>
		</form>
		<hr />
		<!-- Display Students -->
		<div id="bookscart" class="CartServlet">
			<c:forEach items="${bookscart}" var="bookscart">
				<br />
 				${bookscart.getTitle()}                               
 				------------ Quantity: 1          
 				-------------Price: $${bookscart.getPrice()}               
 				<form action="CartServlet" method="post">
					<input type="hidden" name="source" value="remove">
					<input type="hidden" name="student" value="${student}">
					<input type="hidden" name="course" value="${course}">
					<input type="hidden" name="cart" value="${cart}">
					<div id = "button">
						<button type="submit" class="btn btn-primary btn-block">remove</button>
					</div>
				</form>
				<form action="BuyAllServlet" method="post">
					<input type="hidden" name="source" value="remove">
					<input type="hidden" name="price" value="${bookscart.getPrice()}">
					<input type="hidden" name="userId" value="${userId}">
					<input type="hidden" name="cart" value="${cart}">
					<div id = "button">
						<button type="submit" class="btn btn-primary btn-block">Buy</button>
					</div>
				</form>
			</c:forEach>
		</div>
		

</body>
</html>