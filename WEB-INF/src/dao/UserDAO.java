package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import beans.User;
import utility.DriverAccessor;

public class UserDAO extends DriverAccessor {

	public User searchUser(User user, Connection connection) {
		try {
			// SQLコマンド
			String sql = "select * from users_information where user_id ='" + user.getUserId() + "'";
			// SQLコマンドの実行
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);

			rs.first();
			user.setRoleId(rs.getInt("role_id"));
			user.setUserName(rs.getString("user_name"));
			user.setId(rs.getInt("id"));

			stmt.close();
			rs.close();

			return user;
		} catch (SQLException e) {
			// エラーが発生した場合、エラーの原因を出力する
			e.printStackTrace();
			return null;
		} finally {
		}

	}

	public User readUser(User user, Connection connection) {
		try {
			// SQLコマンド
			String sql = "select * from users_information where id ='" + user.getId() + "'";
			// SQLコマンドの実行
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);

			rs.first();
			user.setRoleId(rs.getInt("role_id"));
			user.setUserName(rs.getString("user_name"));
			user.setId(rs.getInt("id"));
			user.setUserId(rs.getString("user_id"));
			user.setUserPassword(rs.getString("user_password"));

			stmt.close();
			rs.close();

			return user;
		} catch (SQLException e) {
			// エラーが発生した場合、エラーの原因を出力する
			e.printStackTrace();
			return null;
		} finally {
		}

	}

	public static List<User> readAllUsers(List<User> user, Connection connection) {

		try {

			// SQLコマンド
			String sql = "select * from users_information";
			// SQLコマンドの実行

			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				if (rs.getInt("role_id") == 0) {
					User temp = new User();
					temp.setId(rs.getInt("id"));
					temp.setUserName(rs.getString("user_name"));
					user.add(temp);
				}
			}
			System.out.println(user.get(0).getUserName());

			return user;
		} catch (SQLException e) {
			// エラーが発生した場合、エラーの原因を出力する
			e.printStackTrace();
			return null;
		} finally {
		}
	}

	public static int deleteUser(int userId, Connection connection) {

		try {

			// SQLコマンド
			String sql = "delete from users_information where id = ?";
			// SQLコマンドの実行
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, userId);
			stmt.executeUpdate();
			stmt.close();

			return 1;
		} catch (SQLException e) {
			// エラーが発生した場合、エラーの原因を出力する
			e.printStackTrace();
			return 0;
		} finally {
		}
	}

	public static int createUser(User user, Connection connection) {

		try {

			// SQLコマンド
			String sql = "insert into users_information (user_id,user_password,user_name,role_id) values(?,?,?,?)";
			// SQLコマンドの実行
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, user.getUserId());
			stmt.setString(2, user.getUserPassword());
			stmt.setString(3, user.getUserName());
			stmt.setInt(4, user.getRoleId());
			System.out.println(stmt);
			stmt.executeUpdate();
			stmt.close();

			return 1;
		} catch (SQLException e) {
			// エラーが発生した場合、エラーの原因を出力する
			e.printStackTrace();
			return 0;
		} finally {
		}
	}

	public static int maxNumUser(Connection connection) {

		try {
			String sql = "select * from users_information";
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			int num = 0;
			while (rs.next()) {
				num = rs.getInt("id");
			}
			return num;
		} catch (SQLException e) {
			// エラーが発生した場合、エラーの原因を出力する
			e.printStackTrace();
			return 0;
		} finally {
		}
	}
}