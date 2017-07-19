package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.User;
import control.UserManager;

public class StudentCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
											throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
											throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		int id = 0;
		String userName = request.getParameter("userName");
		String userId = request.getParameter("userId");
		String userPassword = request.getParameter("userPassword");
		int roleId = 0;
		User user = new User(id,userId,userPassword,userName,roleId);
		UserManager userManager = new UserManager();
		int flag = userManager.createUser(user);
		id = userManager.maxNumUser();
		user.setId(id);
		// データベースに接続
		if(flag==0){
			getServletContext().getRequestDispatcher("/jsp/teacher/home.jsp").forward(request, response);
		}else{
			getServletContext().getRequestDispatcher("/jsp/teacher/success.jsp").forward(request, response);
		}
	}
}