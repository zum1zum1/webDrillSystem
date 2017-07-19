package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import beans.Question;
import dao.QuestionDAO;

import beans.History;
import dao.HistoryDAO;

public class QuestionListServletStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection = null;
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
											throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
											throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		request.setCharacterEncoding("UTF-8");
		// データベースに接続
		List<Question> question = new ArrayList<Question>();
		QuestionDAO questionDAO = new QuestionDAO();
		this.connection = questionDAO.createConnection();
		question = QuestionDAO.readAllQuestions(question,this.connection);

		List<History> history = new ArrayList<History>();
		HistoryDAO historyDAO = new HistoryDAO();
		this.connection = historyDAO.createConnection();
		int id = (int)session.getAttribute("id");
		history = HistoryDAO.readAllHistory(id,this.connection);

		

		request.setAttribute("Question", question);
		request.setAttribute("History", history);
		getServletContext().getRequestDispatcher("/jsp/students/questionList.jsp").forward(request, response);

	}
}