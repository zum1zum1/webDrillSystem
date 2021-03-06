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
import control.UserManager;

import beans.Question;
import dao.QuestionDAO;

import beans.History;
import dao.HistoryDAO;

public class StudentDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection = null;
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
											throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
											throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		int studentId = Integer.parseInt(request.getParameter("detail"));
		UserManager userManager = new UserManager();
		User user = new User();
		user.setId(studentId);

		System.out.println(studentId);
		user = userManager.readUser(user);
		
		List<Question> question = new ArrayList<Question>();
		QuestionDAO questionDAO = new QuestionDAO();
		this.connection = questionDAO.createConnection();
		question = QuestionDAO.readAllQuestions(question,this.connection);

		List<History> history = new ArrayList<History>();
		HistoryDAO historyDAO = new HistoryDAO();
		this.connection = historyDAO.createConnection();
		history = HistoryDAO.readAllHistory(studentId,this.connection);

		request.setAttribute("User", user);
		request.setAttribute("Question", question);
		request.setAttribute("History", history);
		
		getServletContext().getRequestDispatcher("/jsp/teacher/studentDetail.jsp").forward(request, response);

	}
}