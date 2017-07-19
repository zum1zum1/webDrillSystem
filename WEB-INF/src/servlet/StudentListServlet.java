package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;
import dao.UserDAO;

public class StudentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection = null;
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
											throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
											throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		// データベースに接続
		List<User> user = new ArrayList<User>();
		UserDAO userDAO = new UserDAO();
		this.connection = userDAO.createConnection();
		user = UserDAO.readAllUsers(user,this.connection);

		request.setAttribute("User", user);
		getServletContext().getRequestDispatcher("/jsp/teacher/studentList.jsp").forward(request, response);

	}
}