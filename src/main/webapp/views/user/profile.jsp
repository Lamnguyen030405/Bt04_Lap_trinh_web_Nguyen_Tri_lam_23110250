<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Thông tin cá nhân</title>
    <!-- Bootstrap 5 CSS CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f4f6f9;
            margin: 0;
            padding: 0;
        }

        .profile-container {
            max-width: 400px;
            margin: 50px auto;
            padding: 20px;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .avatar-frame {
            width: 300px; /* Kích thước khung cố định */
            height: 400px; /* Kích thước khung cố định */
            border: 1px solid #ddd;
            border-radius: 50%; /* Làm khung tròn cho avatar */
            overflow: hidden; /* Ẩn phần thừa của ảnh */
            display: flex;
            align-items: center;
            justify-content: center;
            margin-top: 10px;
        }

        .avatar-frame img {
            max-width: 100%; /* Scale ảnh theo khung */
            max-height: 100%; /* Scale ảnh theo khung */
            object-fit: cover; /* Crop hoặc fit ảnh vào khung */
            border-radius: 50%; /* Bo tròn ảnh */
        }

        .btn-custom {
            background-color: #28a745;
            border: none;
        }

        .btn-custom:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>

<div class="profile-container">
    <h2 class="text-center mb-4">Thông tin cá nhân</h2>
    <form action="profile" method="post" enctype="multipart/form-data" class="needs-validation">
        <div class="mb-3">
            <label for="fullname" class="form-label">Họ tên:</label>
            <input type="text" class="form-control" id="fullname" name="fullname" value="${user.fullname}" required>
        </div>

        <div class="mb-3">
            <label for="phone" class="form-label">Số điện thoại:</label>
            <input type="text" class="form-control" id="phone" name="phone" value="${user.phone}" required>
        </div>

        <div class="mb-3">
            <label for="image" class="form-label">Ảnh đại diện:</label>
            <div class="avatar-frame">
                <c:if test="${not empty user.image}">
                    <img src="<c:url value='/image?fname=${user.image}'/>" alt="Avatar" class="img-fluid img-thumbnail" style="max-width: 300px; max-height: 400px;">
                </c:if>
            </div>
            <input type="file" class="form-control mt-2" id="image" name="image" required>
        </div>

        <button type="submit" class="btn btn-custom w-100 mt-3">Cập nhật</button>
    </form>
</div>

<!-- Bootstrap 5 JS CDN (bao gồm Popper.js) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>