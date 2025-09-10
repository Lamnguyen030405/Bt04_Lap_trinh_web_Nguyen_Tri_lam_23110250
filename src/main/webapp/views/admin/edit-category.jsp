<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sửa danh mục</title>

    <!-- Bootstrap CSS nếu có -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-5">
    <h2>Sửa danh mục</h2>

    <c:url value="/admin/category/edit" var="editUrl" />

    <form action="${editUrl}" method="post" enctype="multipart/form-data">
        <!-- ID danh mục (ẩn) -->
        <input type="hidden" name="id" value="${category.cateid}" />

        <!-- Tên danh mục -->
        <div class="form-group">
            <label for="name">Tên danh mục:</label>
            <input type="text" class="form-control" id="name" name="name" value="${category.catename}" required />
        </div>

        <!-- Ảnh đại diện -->
        <div class="form-group">
            <label>Ảnh hiện tại:</label><br />
            <c:url value="/image?fname=${category.icon}" var="imgUrl" />
            <img src="${imgUrl}" alt="Ảnh đại diện" width="150" class="img-thumbnail mb-2" />
        </div>

        <div class="form-group">
            <label for="icon">Chọn ảnh mới (nếu muốn thay đổi):</label>
            <input type="file" class="form-control-file" id="icon" name="icon" accept="image/*" />
        </div>

        <!-- Nút hành động -->
        <button type="submit" class="btn btn-success">Cập nhật</button>
        <button type="reset" class="btn btn-secondary">Làm lại</button>
    </form>

    <!-- Hiển thị lỗi nếu có -->
    <c:if test="${not empty error}">
        <div class="alert alert-danger mt-3">${error}</div>
    </c:if>
</div>

<!-- JS Bootstrap nếu cần -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
