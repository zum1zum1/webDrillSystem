package control;

import java.sql.Connection;

import beans.Question;
import dao.QuestionDAO;

public class QuestionManager {
	private Connection connection = null;
	
	public QuestionManager(){
		
	}
	public Question searchQuestion(int questionId){
	
		QuestionDAO questionDAO = new QuestionDAO();
		this.connection = questionDAO.createConnection();
		Question question = new Question();
		question.setQuestionId(questionId);
		question = QuestionDAO.readQuestion(question,connection);
		
		return question;
		
	}
	public int updateQuestion(Question question){
		int flag=0;
		QuestionDAO questionDAO = new QuestionDAO();
		this.connection = questionDAO.createConnection();
		flag = QuestionDAO.updateQuestion(question,connection);
		return flag;
	}
	
	public int createQuestion(Question question){
		int flag=0;
		QuestionDAO questionDAO = new QuestionDAO();
		this.connection = questionDAO.createConnection();
		flag = QuestionDAO.createQuestion(question,connection);
		return flag;
	}
	public int deleteQuestion(int questionId){
		int flag=0;
		QuestionDAO questionDAO = new QuestionDAO();
		this.connection = questionDAO.createConnection();
		flag = QuestionDAO.deleteQuestion(questionId,connection);
		return flag;
	}
	public int maxNumQuestion(){
		int num=0;
		QuestionDAO questionDAO = new QuestionDAO();
		this.connection = questionDAO.createConnection();
		num = QuestionDAO.maxNumQuestion(connection);
		return num;
	}
}
