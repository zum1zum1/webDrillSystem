package servlet;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import beans.History;
import control.HistoryManager;

public class HistoryUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
											throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
											throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		request.setCharacterEncoding("UTF-8");
		String userAnswerString = request.getParameter("answer");
		int userAnswer = Integer.parseInt(userAnswerString);
		String questionIdString = request.getParameter("questionId");
		int questionId = Integer.parseInt(questionIdString);
		String date = null;
		int id = (int)session.getAttribute("id");
		System.out.println(id);
		History history = new History(id,questionId,userAnswer,date);
		HistoryManager historyManager = new HistoryManager();
		int flag = 0;
		try {
			flag = historyManager.updateHistory(history);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(flag==0){
			getServletContext().getRequestDispatcher("/jsp/students/home.jsp").forward(request, response);
		}else{
			getServletContext().getRequestDispatcher("/jsp/students/success.jsp").forward(request, response);
		}
	}
}