<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="Website.css" />
<meta charset="UTF-8">
<title>David's Book Store</title>
</head>
<body>
	<!--form action="Login" method="post">
		Enter username: <input type= "email" name="uname"><br>
		Enter password: <input type= "password" name="pass"><br>
		<input type= "submit" value= "Login"> 
	</form>   -->
	
	<div class="bookstore-header-base">
		</div>
		<form action="Login" method="post">
		<div class="bookstore-header">
			<div id="img1" class="bookstore-header">David's BookStore</div>
			<div id="form1" class="bookstore-header">Email or Phone<br>
			<input placeholder="Email" type="email" name="uname" /><br>
			<input type="checkbox" />keep me logged in</div>

			<div id="form2" class="bookstore-header">Password<br>
			<input placeholder="Password" type="password" name="pass" /><br>
			Forgotten your password?
			</div>
			</div>
		<input type= "submit" value= "Login"> 
		</form>
		<div class="bookstore-body">
			<div id="intro1" class="bookstore-body">Buying books has never been <br>
			easier!</div>
			<div id="intro2" class="bookstore-body">Create an account</div>
			<div id="img2" class="bookstore-body"><img src=".png" /></div>
			<div id="intro3" class="bookstore-body">It's free and always will be.</div>
			<div id="form3" class="bookstore-body">
			<form action="Registration" method="post">
				<input placeholder="First Name" type="text" id="namebox" name="fname" />
				<input placeholder="Last Name" type="text" id="namebox"  name="lname" /> <br>
				<input placeholder="Enter Street Address" type="text" id="mailbox" name="sAddress" /><br>
				<input placeholder="City" type="text" id="mailbox"  name="city" /><br>
				<input placeholder="State" type="text" id="mailbox" name="state" /><br>
				<input placeholder="Zip" type="number" id="mailbox" name="zip" /><br>
				<input placeholder="Country" type="text" id="mailbox" name="country" /><br>
				<input placeholder="Email Address" type="text" id="mailbox" name="email" /><br>
				<input placeholder="Password" type="password" id="mailbox" name="pass" /><br><br>
				<input type="submit" class="button2" value="Register" />
				</form>
			</div>
		</div>
</body>
</html> 