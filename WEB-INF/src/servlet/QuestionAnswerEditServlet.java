package servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;
import beans.Question;
import control.QuestionManager;
import beans.History;
import dao.HistoryDAO;

public class QuestionAnswerEditServlet extends HttpServlet {
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
		String questionIdString = request.getParameter("detail");
		int questionId = Integer.parseInt(questionIdString);
		QuestionManager questionManager = new QuestionManager();
		Question question = new Question();
		System.out.println(questionId);
		question = questionManager.searchQuestion(questionId);
		int id = (int)session.getAttribute("id");
		HistoryDAO historyDAO = new HistoryDAO();
		this.connection = historyDAO.createConnection();
		History history = new History();
		history = historyDAO.readHistory(questionId,id,this.connection);
		// データベースに接続

		request.setAttribute("Question", question);
		request.setAttribute("History", history);
		getServletContext().getRequestDispatcher("/jsp/students/questionAnswerEdit.jsp").forward(request, response);

	}
}