<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>${page.title}</title>
    ${page.meta}

    <!-- Bootstrap 5 CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="container-fluid">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/manager/home">Quản lý</a>
        <a class="nav-link text-white ms-auto" href="${pageContext.request.contextPath}/logout">Đăng xuất</a>
    </div>
</nav>

<div class="container mt-4">
    <sitemesh:write property="body"/>
</div>

<footer class="text-center mt-5 py-3 bg-light">
    <p class="mb-0">Bảng điều khiển quản trị - &copy; 2025</p>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
