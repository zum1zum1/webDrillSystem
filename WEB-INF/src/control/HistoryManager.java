package control;

import java.sql.Connection;
import beans.History;
import dao.HistoryDAO;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class HistoryManager {
	private Connection connection = null;
	
	public HistoryManager(){
		
	}
	public int createHistory(History history) throws ParseException{
		int flag=0;
		HistoryDAO historyDAO = new HistoryDAO();
		this.connection = historyDAO.createConnection();
		Date strDate = new Date();
	    String str = new SimpleDateFormat("yyyy/MM/dd").format(strDate);
	    System.out.println(str);
	    history.setAnswerDate(str);
		flag = HistoryDAO.createHistory(history,connection);
		return flag;
	}
	
	public int updateHistory(History history) throws ParseException{
		int flag=0;
		HistoryDAO historyDAO = new HistoryDAO();
		this.connection = historyDAO.createConnection();
		Date strDate = new Date();
	    String str = new SimpleDateFormat("yyyy/MM/dd").format(strDate);
	    System.out.println(str);
	    history.setAnswerDate(str);
		flag = HistoryDAO.updateHistory(history,connection);
		return flag;
	}
}
