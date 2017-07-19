package control;

import java.sql.Connection;

import dao.LoginDAO;
import beans.User;

public class LoginManager {

	private Connection connection = null;

	public LoginManager(){
		
	}
	
	public int checkUser(User user){
		LoginDAO loginDAO = new LoginDAO();
		this.connection = loginDAO.createConnection();
		int checkId = loginDAO.checkUser(user,this.connection);
		
		return checkId;
		
	};
}