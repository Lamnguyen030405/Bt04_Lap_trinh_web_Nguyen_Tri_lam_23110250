package vn.iotstar.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.entities.UserEntity;
import vn.iotstar.services.IUserService;
import vn.iotstar.services.impl.UserServiceImpl;

@WebServlet(urlPatterns = "/reset-password")
public class ResetPasswordController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	IUserService service = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/reset-password.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String newPassword = req.getParameter("newPassword");
		String email = (String) req.getSession().getAttribute("email");

		UserEntity user = service.findByEmail(email);
		if (user != null) {
			user.setPassword(newPassword); // nên mã hóa trước khi lưu
			service.update(user);
			req.setAttribute("success", "Đặt lại mật khẩu thành công.");
			resp.sendRedirect(req.getContextPath() + "/login");
		} else {
			req.setAttribute("error", "Không thể đặt lại mật khẩu.");
			req.getRequestDispatcher("views/reset-password.jsp").forward(req, resp);
		}
	}
}
