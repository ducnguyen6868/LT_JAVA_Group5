<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Đại học Công nghiệp Hà Nội</title>
<link rel="icon" type="image/x-icon" href="resources/img/logo1.png">
</head>
<body>
<head>
<meta charset="UTF-8">
<title>Login</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-image: url("resources/img/t89945.jpg");
	height:100vh;
	background-position:center;
	background-size:cover;
	over-flow:hidden;
}

.container {
	width: 400px;
	margin: 0 auto;
	margin-top: 100px;
	background-color:rgba(255,255,255,0.4);
	padding:20px;
	border-radius:1rem;
}
input{
	font-size:larger;
}
input[type="text"], input[type="password"] {
	width: 100%;
	padding: 10px;
	margin: 5px 0;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
	outline:none;
}
input[type="text"]:focus, input[type="password"]:focus{
box-shadow:0px 0px 6px blue;
}
input[type="submit"] {
	width: 100%;
	background-color: blue;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;

}
input[type="submit"]:hover{
background-color: #0056b3;
}
</style>
</head>
<body>

	<div class="container">
		<div style="text-align:center;">
			<img src="resources/img/logo1.png" style="width:150px; height:auto" alt="Logo Image" >
		</div>
		<form action="login-checking" method="post">
			<label for="username">Mã sinh viên</label> <input type="text"
				id="username" name="username" required> <label
				for="password">Mật khẩu</label>
				 <input type="password"
				id="password" name="password" required> <input type="submit"
				value="Đăng nhập">
		</form>
	</div>


</body>
</html>