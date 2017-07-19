package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import beans.User;
import utility.DriverAccessor;

public class LoginDAO extends DriverAccessor {

	public int checkUser(User user, Connection connection) {

		try {

			// SQLコマンド
			String sql = "select * from users_information where user_id ='" + user.getUserId() + "'";
			// SQLコマンドの実行
			int checkId = 0;
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);

			boolean isExists = rs.first();
			// System.out.println(isExists);
			if (isExists == (true)) {
				String pass = user.getUserPassword();
				String dbpass = rs.getString("user_password");
				if (pass.equals(dbpass)) {
					checkId = 1;
				}
			}

			stmt.close();
			rs.close();

			return checkId;
		} catch (SQLException e) {
			// エラーが発生した場合、エラーの原因を出力する
			e.printStackTrace();
			return 0;
		} finally {
		}
	}
}
