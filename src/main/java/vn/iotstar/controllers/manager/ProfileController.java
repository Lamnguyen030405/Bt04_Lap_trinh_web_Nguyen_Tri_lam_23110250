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
import vn.iotstar.entities.UserEntity;
import vn.iotstar.services.IUserService;
import vn.iotstar.services.impl.UserServiceImpl;
import vn.iotstar.utils.path.Constant;
import vn.iotstar.utils.UploadUtils;


@WebServlet(urlPatterns = { "/manager/profile" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, 	// 2MB
				 maxFileSize = 1024 * 1024 * 10,  		// 10MB
				 maxRequestSize = 1024 * 1024 * 50)		// 50MB
public class ProfileController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	IUserService userService = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        UserEntity user = (UserEntity) session.getAttribute("account");
        req.setAttribute("user", user);
        req.getRequestDispatcher("/views/manager/profile.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        HttpSession session = req.getSession(false);
        UserEntity user = (UserEntity) session.getAttribute("account");

        user.setFullname(req.getParameter("fullname"));
        user.setPhone(req.getParameter("phone"));

        Part filePart = req.getPart("image");
        if (filePart != null && filePart.getSize() > 0) {
            String fileName = UploadUtils.processUploadFile(filePart, Constant.DIR + "/avatar");
            user.setImage(fileName);
        }

        userService.update(user); // cập nhật user trong DB
        session.setAttribute("account", user); // cập nhật lại session

        resp.sendRedirect(req.getContextPath() + "/manager/home");
	}
}
