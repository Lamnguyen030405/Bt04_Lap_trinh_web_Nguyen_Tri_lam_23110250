package vn.iotstar.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/verify-code")
public class VerifyCodeController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/verify-code.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code = req.getParameter("code");
		String savedCode = (String) req.getSession().getAttribute("authcode");

		if (code.equals(savedCode)) {
			resp.sendRedirect(req.getContextPath() + "/reset-password");
		} else {
			req.setAttribute("error", "Mã xác thực không đúng.");
			req.getRequestDispatcher("/views/verify-code.jsp").forward(req, resp);
		}
	}
}
