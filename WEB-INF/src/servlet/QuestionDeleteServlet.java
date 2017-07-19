package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import control.QuestionManager;

public class QuestionDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
											throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
											throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String questionId = request.getParameter("delete");
		int questionIdInt = Integer.parseInt(questionId);

		QuestionManager questionManager = new QuestionManager();
		int flag = questionManager.deleteQuestion(questionIdInt);
		// データベースに接続
		if(flag==0){
			getServletContext().getRequestDispatcher("/jsp/teacher/home.jsp").forward(request, response);
		}else{
			getServletContext().getRequestDispatcher("/jsp/teacher/home.jsp").forward(request, response);
		}
	}
}