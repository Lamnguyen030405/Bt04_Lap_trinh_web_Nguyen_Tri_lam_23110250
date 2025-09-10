package vn.iotstar.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/logout")
public class LogoutController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Xóa session hiện tại (đăng xuất)
		req.getSession().invalidate();

		// Chuyển hướng về trang đăng nhập (hoặc trang chủ)
		resp.sendRedirect(req.getContextPath() + "/login");
	}
}
