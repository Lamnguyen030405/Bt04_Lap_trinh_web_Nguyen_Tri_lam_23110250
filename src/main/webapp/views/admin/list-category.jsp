<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách danh mục</title>
    <style>
        table {
            width: 80%;
            margin: 0 auto;
            border-collapse: collapse;
        }

        th, td {
            padding: 10px;
            border: 1px solid #ccc;
            text-align: center;
        }

        img {
            max-width: 150px;
            max-height: 100px;
        }

        a {
            text-decoration: none;
            color: blue;
        }
    </style>
</head>
<body>

    <h2 style="text-align: center;">Danh sách danh mục</h2>
	
	<div style="width: 80%; margin: 10px auto; text-align: right;">
	    <a href="<c:url value='/user/category/add' />"
	       style="padding: 8px 16px; background-color: #28a745; color: white; border-radius: 5px; text-decoration: none;">
	        + Thêm danh mục
	    </a>
	</div>
	
	<div style="width: 80%; margin: 20px auto 10px auto; text-align: right;">
	    <a href="<c:url value='/user/home' />"
	       style="padding: 8px 16px; background-color: #28a745; color: white; border-radius: 5px; text-decoration: none;">
	        Quay lại
	    </a>
	</div>

	
	<c:if test="${not empty sessionScope.message}">
	    <div style="text-align: center; color: red; font-weight: bold;">
	        ${sessionScope.message}
	    </div>
	    <c:remove var="message" scope="session"/>
	</c:if>

    <table>
        <thead>
            <tr>
                <th>STT</th>
                <th>Ảnh Icon</th>
                <th>Tên danh mục</th>
                <th>Hành động</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${cateList}" var="cate" varStatus="STT">
                <tr>
                    <td>${STT.index + 1}</td>
                    
                    <td>
                        <c:url value="/image?fname=${cate.icon}" var="imgUrl" />
                        <img src="${imgUrl}" alt="icon" />
                    </td>
                    
                    <td>${cate.catename}</td>
                    
                    <td>
                        <a href="<c:url value='/admin/category/edit?id=${cate.cateid}' />">Sửa</a>
                        |
                        <a href="<c:url value='/admin/category/delete?id=${cate.cateid}' />" onclick="return confirm('Bạn có chắc chắn muốn xóa?')">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    

</body>
</html>
