package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.Question;
import control.QuestionManager;

public class QuestionDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
											throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
											throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String questionIdString = request.getParameter("detail");
		int questionId = Integer.parseInt(questionIdString);
		QuestionManager questionManager = new QuestionManager();
		Question question = new Question();
		question = questionManager.searchQuestion(questionId);
		// データベースに接続

		request.setAttribute("Question", question);
		getServletContext().getRequestDispatcher("/jsp/teacher/questionDetail.jsp").forward(request, response);

	}
}