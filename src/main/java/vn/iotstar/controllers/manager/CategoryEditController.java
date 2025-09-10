package vn.iotstar.controllers.manager;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import vn.iotstar.entities.CategoryEntity;
import vn.iotstar.entities.UserEntity;
import vn.iotstar.services.ICategoryService;
import vn.iotstar.services.impl.CategoryServiceImpl;
import vn.iotstar.utils.UploadUtils;
import vn.iotstar.utils.path.Constant;

@WebServlet(urlPatterns = { "/manager/category/edit" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, 	// 2MB
				 maxFileSize = 1024 * 1024 * 10,  		// 10MB
				 maxRequestSize = 1024 * 1024 * 50)		// 50MB
public class CategoryEditController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	ICategoryService cateService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idStr = req.getParameter("id");

		try {
			int id = Integer.parseInt(idStr);
			CategoryEntity category = cateService.findById(id);
			req.setAttribute("category", category);
			req.getRequestDispatcher("/views/manager/edit-category.jsp").forward(req, resp);
		} catch (Exception e) {
			resp.sendRedirect(req.getContextPath() + "/manager/category/list?error=invalid_id");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		HttpSession session = req.getSession(false);
		if (session == null || session.getAttribute("account") == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}

		UserEntity user = (UserEntity) session.getAttribute("account");
		String message = null;

		try {
			int id = Integer.parseInt(req.getParameter("id"));
			CategoryEntity category = cateService.findById(id);

			if (category == null) {
				message = "Danh mục không tồn tại.";
			} else if (user.getId() != category.getUserid() && user.getRoleid() != 3) {
				message = "Bạn không có quyền chỉnh sửa danh mục này.";
			} else {
				// Cập nhật tên mới
				category.setCatename(req.getParameter("name"));

				// Cập nhật ảnh mới nếu có
				Part filePart = req.getPart("icon");
				String iconPath = UploadUtils.processUploadFile(filePart, Constant.DIR + "/category");
				if (iconPath != null) {
					category.setIcon(iconPath);
				}

				cateService.update(category);
				message = "Cập nhật danh mục thành công.";
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = "Lỗi khi cập nhật danh mục.";
		}

		session.setAttribute("message", message);
		resp.sendRedirect(req.getContextPath() + "/manager/category/list");
	}
}
