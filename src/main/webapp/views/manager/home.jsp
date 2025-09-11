<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>manager Home</title>
</head>
<body>
	<h2>Trang chủ của Manager</h2>

	<!-- Nút Logout -->
	<form action="${pageContext.request.contextPath}/logout" method="get" style="display:inline;">
		<button type="submit">Đăng xuất</button>
	</form>
	
	<!-- Nút Xem list category -->
	<form action="${pageContext.request.contextPath}/manager/category/list" method="get" style="display:inline;">
		<button type="submit">Xem list</button>
	</form>
	
	<!-- Nút xem profile -->
	<form action="${pageContext.request.contextPath}/manager/profile"
		method="get" style="display: inline;">
		<button type="submit">Edit profile</button>
	</form>
	
</body>
</html>