<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ - Quản lý trực nhật</title>
<link rel="icon" type="image/x-icon" href="resources/img/logo1.png">
<style>
/* CSS cho trang */
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	background-color: #f4f4f4;
}

header {
	background-color: #15c715;
	color: #fff;
	padding: 10px;
	text-align: center;
	display: flex;
	justify-content: space-between;
	align-items: center;
	position: relative;
}

header img {
	width: 100px; /* Độ rộng của logo */
	vertical-align: middle;
}

header p, header span {
	display: inline-block;
	vertical-align: middle;
	margin-left: 10px;
	cursor: pointer;
	font-size: 40px;
	margin: 0px;
}

header span {
	font-size: 16px;
	padding: 0px 40px;
	cursor: pointer;
}

header span:hover {
	text-decoration:underline;
	}
menu {
	padding: 20px;
	background-color: #fff;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

table {
	width: 100%;
	border-collapse: collapse;
}
table caption{
	font-size:30px;
	font-weight:bold;
	margin-bottom:10px;
}
th, td {
	border: 1px solid #ddd;
	padding: 8px;
	text-align: left;
}

th {
	background-color: #f2f2f2;
}
table .className:hover,table .classId:hover{
	text-decoration:underline;
	cursor:pointer;
}
.class-row:nth-child(even) {
	background-color: #f9f9f9;
}
</style>
</head>
<body>
	<header>
		<img src="resources/img/logo1.png" alt="Logo Image">
		<p>Quản lý trực nhật HaUI</p>
		<span>Nguyễn Đức</span>
	</header>
	<menu>
		<table>
			<caption>Danh sách lớp học</caption>
			<tr>
				<th>Mã lớp</th>
				<th>Tên lớp</th>
				<th>Ngày bắt đầu</th>
				<th>Ngày kết thúc</th>
				<th>Số buổi học</th>
				<th>Số sinh viên</th>
			</tr>
			<tr class="class-row">
				<td class="classId">L001</td>
				<td class="className">Lập trình Java cơ bản</td>
				<td>01/05/2024</td>
				<td>30/06/2024</td>
				<td>30</td>
				<td>25</td>
			</tr>
			<tr class="class-row">
				<td class="classId">L002</td>
				<td class="className">Lập trình Web cơ bản</td>
				<td>05/05/2024</td>
				<td>25/07/2024</td>
				<td>25</td>
				<td>20</td>
			</tr>
			<tr class="class-row">
				<td class="classId">L003</td>
				<td class="className">Lập trình hướng đối tượng</td>
				<td>05/05/2024</td>
				<td>25/07/2024</td>
				<td>25</td>
				<td>20</td>
			</tr>
			<tr class="class-row">
				<td class="classId">L004</td>
				<td class="className">Lập trình Java</td>
				<td>05/05/2024</td>
				<td>25/07/2024</td>
				<td>25</td>
				<td>20</td>
			</tr>
			<!-- Thêm các hàng khác tương tự -->
		</table>
	</menu>
</body>
</html>
