package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverAccessor {

	private final static String DRIVER_URL = "jdbc:mysql://localhost:3306/webDrillSystem?useUnicode=true&characterEncoding=UTF-8";

	private final static String DRIVER_NAME = "com.mysql.jdbc.Driver";

	private final static String USER_NAME = "root";

	private final static String PASSWORD = "";

	// DBへ接続する
	public Connection createConnection() {
		try {
			Class.forName(DRIVER_NAME);
			Connection con = DriverManager.getConnection(DRIVER_URL, USER_NAME, PASSWORD);
			return con;
		} catch (ClassNotFoundException e) {
			System.out.println("Can't Find JDBC Driver.\n");

		} catch (SQLException e) {
			System.out.println("Connect Error.\n");
		}
		return null;
	}

	// DBへの接続を切る
	public void closeConnection(Connection con) {

		try {
			con.close();
		} catch (Exception ex) {
		}
	}
}