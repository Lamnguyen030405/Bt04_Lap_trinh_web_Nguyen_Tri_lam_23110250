<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix= "c" uri="jakarta.tags.core" %>
<%@ taglib prefix= "fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix= "fn" uri="jakarta.tags.functions"%>

<!DOCTYPE html>
<html>
<head>
    <title>Forgot Password</title>
</head>
<body>
    <h2>Forgot Password</h2>
    <form action="forgot-password" method="post">
        <input type="email" name="email" placeholder="Enter your email" required />
        <button type="submit">Send Verification Code</button>
    </form>
    <p style="color:red">${error}</p>
</body>
</html>