package vn.iotstar.controllers.manager;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.entities.CategoryEntity;
import vn.iotstar.entities.UserEntity;
import vn.iotstar.services.ICategoryService;
import vn.iotstar.services.impl.CategoryServiceImpl;

@WebServlet(urlPatterns = "/manager/category/delete")
public class CategoryDeleteController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ICategoryService categoryService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session == null || session.getAttribute("account") == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}

		UserEntity user = (UserEntity) session.getAttribute("account");
		String message = null;

		try {
			int id = Integer.parseInt(req.getParameter("id"));
			CategoryEntity cate = categoryService.findById(id);

			if (cate == null) {
				message = "Danh mục không tồn tại.";
			} else if (user.getId() == cate.getUserid() || user.getRoleid() == 3) {
				categoryService.delete(id);
				message = "Xóa danh mục thành công.";
			} else {
				message = "Bạn không có quyền xóa danh mục này.";
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = "Lỗi khi xóa danh mục.";
		}

		// Lưu thông báo vào session để hiển thị lại trên giao diện
		session.setAttribute("message", message);

		// Chuyển hướng về danh sách
		resp.sendRedirect(req.getContextPath() + "/manager/category/list");
	}
}
