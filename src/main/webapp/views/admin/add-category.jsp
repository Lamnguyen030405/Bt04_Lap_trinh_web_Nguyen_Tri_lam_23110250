<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm danh mục</title>

    <!-- Link Bootstrap nếu bạn dùng -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2>Thêm danh mục mới</h2>

        <form role="form" action="${pageContext.request.contextPath}/admin/category/add" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="name">Tên danh mục:</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="Nhập tên danh mục" required>
            </div>

            <div class="form-group">
                <label for="icon">Ảnh đại diện:</label>
                <input type="file" class="form-control-file" id="icon" name="icon" accept="image/*">
            </div>

            <button type="submit" class="btn btn-success">Thêm</button>
            <a href="${pageContext.request.contextPath}/admin/category/list" class="btn btn-secondary">Hủy</a>
        </form>
    </div>

    <!-- Optional JS for Bootstrap -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
