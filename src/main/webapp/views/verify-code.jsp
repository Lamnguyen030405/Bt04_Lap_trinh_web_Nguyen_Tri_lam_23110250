<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<head><title>Verify Code</title></head>
<body>
    <h2>Enter Verification Code</h2>
    <form action="${pageContext.request.contextPath}/verify-code" method="post">
        <input type="text" name="code" placeholder="Enter code" required />
        <button type="submit">Verify</button>
    </form>
    <p style="color:red">${error}</p>
</body>
</html>