package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.Question;
import control.QuestionManager;

public class QuestionCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
											throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
											throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		int questionId = 0;
		String questionHeadline = request.getParameter("headline");
		String questionText = request.getParameter("text");
		String questionChoice1 = request.getParameter("choice1");
		String questionChoice2 = request.getParameter("choice2");
		String questionChoice3 = request.getParameter("choice3");
		String questionCorrectAnswer = request.getParameter("correctAnswer");
		int questionCorrectAnswerInt = Integer.parseInt(questionCorrectAnswer);
		Question question = new Question(questionId,questionHeadline,questionText,questionChoice1,questionChoice2,questionChoice3,questionCorrectAnswerInt);
		QuestionManager questionManager = new QuestionManager();
		int flag = questionManager.createQuestion(question);
		questionId = questionManager.maxNumQuestion();
		question.setQuestionId(questionId);
		// データベースに接続
		if(flag==0){
			getServletContext().getRequestDispatcher("/jsp/teacher/home.jsp").forward(request, response);
		}else{
			request.setAttribute("Question", question);
			getServletContext().getRequestDispatcher("/jsp/teacher/questionDetail.jsp").forward(request, response);
		}
	}
}