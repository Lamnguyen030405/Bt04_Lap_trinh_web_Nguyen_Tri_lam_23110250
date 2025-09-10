package vn.iotstar.controllers.manager;

import java.io.IOException;
import java.util.List;

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

@WebServlet(urlPatterns = { "/manager/category/list" })
public class CategoryListController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	ICategoryService cateService = new CategoryServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session= req.getSession();
		UserEntity u=(UserEntity) session.getAttribute("account");
		List<CategoryEntity> cateList = cateService.findByUserId(u.getId());
		req.setAttribute("cateList", cateList);
		req.getRequestDispatcher("/views/manager/list-category.jsp").forward(req, resp);
	}
}