package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import beans.User;
import control.LoginManager;
import control.UserManager;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPassword = request.getParameter("userPassword");
		/*
		 * DBにアクセス
		 */
		User user = new User();
		user.setUserId(userId);
		user.setUserPassword(userPassword);
		LoginManager checkLoginManager = new LoginManager();

		int checkId = checkLoginManager.checkUser(user);
		if (checkId == 0) {
			getServletContext().getRequestDispatcher("/jsp/error.jsp").forward(request, response);
		} else if (checkId == 1) {
			UserManager userManager = new UserManager();
			user = userManager.searchUser(user);

			/*
			 * sessionの開始
			 */
			HttpSession session = request.getSession(true);
			session.setAttribute("id", user.getId());
			session.setAttribute("userId", user.getUserId());
			session.setAttribute("userPassword", user.getUserPassword());
			session.setAttribute("userName", user.getUserName());
			session.setAttribute("roleId", user.getRoleId());

			/*
			 * 遷移先の振り分け
			 */
			if (user.getRoleId() == 0) {
				getServletContext().getRequestDispatcher("/jsp/studentLoginSuccess.jsp").forward(request, response);
			} else if (user.getRoleId() == 1) {
				getServletContext().getRequestDispatcher("/jsp/teacherLoginSuccess.jsp").forward(request, response);

			}
		}
	}
}