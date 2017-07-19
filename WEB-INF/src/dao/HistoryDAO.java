package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.History;
import utility.DriverAccessor;

public class HistoryDAO extends DriverAccessor{

	public static int createHistory(History history, Connection connection) {

		try {

			// SQLコマンド
			String sql = "insert into answers_histories (id,question_id,user_answer,answer_date) values(?,?,?,?)";
			// SQLコマンドの実行
			PreparedStatement stmt = connection.prepareStatement(sql);
			// System.out.println(stmt);
			stmt.setInt(1, history.getId());
			stmt.setInt(2, history.getQuestionId());
			stmt.setInt(3, history.getUserAnswer());
			stmt.setString(4, history.getAnswerDate());
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
	
	public static int updateHistory(History history, Connection connection) {

		try {

			// SQLコマンド
			String sql = "UPDATE answers_histories SET id = ? , question_id = ? , user_answer = ? , answer_date = ? where id = ? AND question_id = ?";
			// SQLコマンドの実行
			PreparedStatement stmt = connection.prepareStatement(sql);
			// System.out.println(stmt);
			stmt.setInt(1, history.getId());
			stmt.setInt(2, history.getQuestionId());
			stmt.setInt(3, history.getUserAnswer());
			stmt.setString(4, history.getAnswerDate());
			stmt.setInt(5, history.getId());
			stmt.setInt(6, history.getQuestionId());
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

	public static List<History> readAllHistory(int id, Connection connection) {

		try {

			// SQLコマンド
			String sql = "select * from answers_histories where id = " + id;
			// SQLコマンドの実行

			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			List<History> history = new ArrayList<History>();
			while (rs.next()) {
				History temp = new History();
				temp.setId(rs.getInt("id"));
				temp.setQuestionId(rs.getInt("question_id"));
				temp.setUserAnswer(rs.getInt("user_answer"));
				temp.setAnswerDate(rs.getString("answer_date"));
				history.add(temp);
			}

			return history;
		} catch (SQLException e) {
			// エラーが発生した場合、エラーの原因を出力する
			e.printStackTrace();
			return null;
		} finally {
		}
	}

	public History readHistory(int questionId, int id, Connection connection) {

		try {

			// SQLコマンド
			String sql = "select * from answers_histories where id = " + id;
			// SQLコマンドの実行

			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			History history = new History();
			while (rs.next()) {
				if (questionId == rs.getInt("question_id")) {
					history.setId(rs.getInt("id"));
					history.setQuestionId(rs.getInt("question_id"));
					history.setUserAnswer(rs.getInt("user_answer"));
					history.setAnswerDate(rs.getString("answer_date"));
				}
			}
			return history;
		} catch (

		SQLException e) {
			// エラーが発生した場合、エラーの原因を出力する
			e.printStackTrace();
			return null;
		} finally {
		}
	}
}
