package vn.iotstar.controllers.user;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.entities.CategoryEntity;
import vn.iotstar.services.ICategoryService;
import vn.iotstar.services.impl.CategoryServiceImpl;

@WebServlet(urlPatterns = { "/user/category/list" })
public class CategoryListController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	ICategoryService cateService = new CategoryServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<CategoryEntity> cateList = cateService.findAll();
		req.setAttribute("cateList", cateList);
		req.getRequestDispatcher("/views/user/list-category.jsp").forward(req, resp);
	}
}