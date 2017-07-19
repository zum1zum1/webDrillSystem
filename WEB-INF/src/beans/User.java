package beans;

public class User {
	private int id = 0;
	private String userId = null;
	private String userPassword = null;
	private String userName = null;
	private int roleId = 0;

	public User(int id, String userId, String userPassword, String userName, int roleId) {
		super();
		this.id = id;
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.roleId = roleId;
	}

	public User() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

}
