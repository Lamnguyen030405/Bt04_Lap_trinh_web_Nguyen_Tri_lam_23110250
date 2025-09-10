package vn.iotstar.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.services.IUserService;
import vn.iotstar.services.impl.UserServiceImpl;
import vn.iotstar.utils.path.Constant;

@WebServlet(urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("uname");
		String password = req.getParameter("psw");
		String email = req.getParameter("email");
		String fullname = req.getParameter("fname");
		String phone = req.getParameter("phone");
		String repeatPassword = req.getParameter("psw-repeat");
		IUserService service = new UserServiceImpl();
		String alertMsg ="";
		if (service.checkExistEmail(email)) {
			alertMsg = "Email already exists!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher(Constant.REGISTER).forward(req, resp);
			return;
		}
		if (service.checkExistUsername(username)) {
			alertMsg = "Account already exists!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher(Constant.REGISTER).forward(req, resp);
			return;
		}
		if (!service.isPasswordMatch(password, repeatPassword)) {
			alertMsg = "The passwords you entered do not match. Please try again!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher(Constant.REGISTER).forward(req, resp);
			return;
		}
		boolean isSuccess = service.register(email ,password, repeatPassword, username, fullname, phone);
		if (isSuccess) {
		//SendMail sm = new SendMail();
		//sm.sendMail(email, "Shopping.iotstar.vn", "Welcome to Shopping. Please Login to use service. Thanks !");
		req.setAttribute("alert", alertMsg);
		resp.sendRedirect(req.getContextPath() + "/login");
		} else {
		alertMsg = "System error!";
		req.setAttribute("alert", alertMsg);
		req.getRequestDispatcher(Constant.REGISTER).forward(req, resp);
		}
	}
}
