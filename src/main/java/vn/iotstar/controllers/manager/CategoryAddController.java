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

@WebServlet(urlPatterns = { "/manager/category/add" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, 	// 2MB
maxFileSize = 1024 * 1024 * 10,  		// 10MB
maxRequestSize = 1024 * 1024 * 50)		// 50MB
public class CategoryAddController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	ICategoryService cateService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/manager/add-category.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		try {
			CategoryEntity category = new CategoryEntity();

			// Lấy name từ form
			String name = req.getParameter("name");
			category.setCatename(name);
			HttpSession session = req.getSession();
			UserEntity manager = (UserEntity) session.getAttribute("account");

			category.setUserid(manager.getId());


			// Lấy file icon từ form
			Part filePart = req.getPart("icon");

			// Gọi UploadUtils để xử lý upload
			String iconPath = UploadUtils.processUploadFile(filePart, Constant.DIR + "/category");

			// Nếu có icon thì set
			if (iconPath != null) {
				category.setIcon(iconPath);
			}

			// Thêm mới vào DB
			cateService.insert(category);

			// Chuyển hướng sau khi thêm
			resp.sendRedirect(req.getContextPath() + "/manager/category/list");

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Có lỗi xảy ra khi thêm danh mục.");
			req.getRequestDispatcher("/views/manager/add-category.jsp").forward(req, resp);
		}
	}
}
