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
import vn.iotstar.utils.EmailUtils;

@WebServlet(urlPatterns = {"/forgot-password"})
public class ForgotPasswordController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	IUserService service = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/forgot-password.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		
		// Giả sử bạn có UserDAO để tìm user theo email
		UserEntity user = service.findByEmail(email);

		if (user == null) {
			req.setAttribute("error", "Email không tồn tại.");
			req.getRequestDispatcher("/views/forgot-password.jsp").forward(req, resp);
			return;
		}

		// Tạo mã xác thực và gửi email
		EmailUtils emailUtil = new EmailUtils();
		String code = emailUtil.getRandom();
		user.setCode(code); // lưu tạm thời

		boolean sent = emailUtil.sendEmail(user);
		if (sent) {
			req.getSession().setAttribute("authcode", code);
			req.getSession().setAttribute("email", email);
			resp.sendRedirect(req.getContextPath() + "/verify-code");
		} else {
			req.setAttribute("error", "Không thể gửi email.");
			req.getRequestDispatcher("/views/forgot-password.jsp").forward(req, resp);
		}
	}
}
