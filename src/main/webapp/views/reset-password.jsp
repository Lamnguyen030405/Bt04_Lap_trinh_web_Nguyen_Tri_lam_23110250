<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<head><title>Reset Password</title></head>
<body>
    <h2>Reset Your Password</h2>
    <form action="${pageContext.request.contextPath}/reset-password" method="post">
        <input type="password" name="newPassword" placeholder="New Password" required />
        <button type="submit">Reset</button>
    </form>
    <p style="color:green">${success}</p>
    <p style="color:red">${error}</p>
</body>
</html>