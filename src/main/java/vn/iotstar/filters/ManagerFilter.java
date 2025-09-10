package vn.iotstar.filters;

import java.io.IOException;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.*;

@WebFilter("/manager/*")
public class ManagerFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("account") != null) {
			var user = (vn.iotstar.entities.UserEntity) session.getAttribute("account");
			if (user.getRoleid() == 2) {
				chain.doFilter(request, response);
				return;
			}
		}
		resp.sendRedirect(req.getContextPath() + "/login");
	}
}
