<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Successful Buy</title>
</head>
<body>
	Congrats!! You just bought one of our books!!
	
	<form action="backToBookshelf" method="post">
			<input type="hidden" name="source" value="">
			<input type="hidden" name="cart" value="${cart}">
			<div id = "button">
				<button type="submit" class="btn btn-primary btn-block">Back to bookshelf</button>
			</div>
		</form>
</body>
</html>