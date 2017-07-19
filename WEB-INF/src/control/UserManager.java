package control;

import dao.UserDAO;
import java.sql.Connection;
import beans.User;

public class UserManager {

	private Connection connection = null;
	
	public UserManager(){
		
	}
	public User searchUser(User user){
		
		UserDAO userDAO = new UserDAO();
		this.connection = userDAO.createConnection();
		user = userDAO.searchUser(user,connection);
		
		return user;
		
	}
	
	public User readUser(User user){
		
		UserDAO userDAO = new UserDAO();
		this.connection = userDAO.createConnection();
		user = userDAO.readUser(user,connection);
		
		return user;
		
	}
	
	public int createUser(User user){
		int flag=0;
		UserDAO userDAO = new UserDAO();
		this.connection = userDAO.createConnection();
		flag = UserDAO.createUser(user,connection);
		return flag;
	}
	
	public int maxNumUser(){
		int num=0;
		UserDAO userDAO = new UserDAO();
		this.connection = userDAO.createConnection();
		num = UserDAO.maxNumUser(connection);
		return num;
	}
	
	public int deleteUser(int userId){
		int flag=0;
		UserDAO userDAO = new UserDAO();
		this.connection = userDAO.createConnection();
		flag = UserDAO.deleteUser(userId,connection);
		return flag;
	}
}
