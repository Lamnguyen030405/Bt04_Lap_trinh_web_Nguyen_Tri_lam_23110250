package vn.iotstar.filters;

import java.io.IOException;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.*;

@WebFilter("/admin/*")
public class AdminFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("account") != null) {
			var user = (vn.iotstar.entities.UserEntity) session.getAttribute("account");
			if (user.getRoleid() == 3) {
				chain.doFilter(request, response); // Đúng role → cho qua
				return;
			}
		}

		// Không đúng role → về login
		resp.sendRedirect(req.getContextPath() + "/login");
	}
}
