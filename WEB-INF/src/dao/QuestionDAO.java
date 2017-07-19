package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import beans.Question;
import utility.DriverAccessor;

public class QuestionDAO extends DriverAccessor {

	public static List<Question> readAllQuestions(List<Question> question, Connection connection) {

		try {

			// SQLコマンド
			String sql = "select * from questions_information";
			// SQLコマンドの実行

			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Question temp = new Question();
				temp.setQuestionId(rs.getInt("question_id"));
				temp.setQuestionHeadline(rs.getString("question_headline"));
				temp.setQuestionText(rs.getString("question_text"));
				temp.setChoice1(rs.getString("choice_1"));
				temp.setChoice2(rs.getString("choice_2"));
				temp.setChoice3(rs.getString("choice_3"));
				temp.setCorrectAnswer(rs.getInt("correct_answer"));
				question.add(temp);
			}

			return question;
		} catch (SQLException e) {
			// エラーが発生した場合、エラーの原因を出力する
			e.printStackTrace();
			return null;
		} finally {
		}
	}

	public static Question readQuestion(Question question, Connection connection) {

		try {

			// SQLコマンド
			String sql = "select * from questions_information where question_id ='" + question.getQuestionId() + "'";
			// SQLコマンドの実行
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			rs.first();
			Question temp = new Question();
			temp.setQuestionId(rs.getInt("question_id"));
			temp.setQuestionHeadline(rs.getString("question_headline"));
			temp.setQuestionText(rs.getString("question_text"));
			temp.setChoice1(rs.getString("choice_1"));
			temp.setChoice2(rs.getString("choice_2"));
			temp.setChoice3(rs.getString("choice_3"));
			temp.setCorrectAnswer(rs.getInt("correct_answer"));
			stmt.close();
			return temp;
		} catch (SQLException e) {
			// エラーが発生した場合、エラーの原因を出力する
			e.printStackTrace();
			return null;
		} finally {
		}
	}

	public static int updateQuestion(Question question, Connection connection) {

		try {

			// SQLコマンド
			String sql = "UPDATE questions_information SET question_headline = ? , question_text = ? , choice_1 = ? , choice_2 = ? , choice_3 = ? , correct_answer = ? where question_id = ? ";
			// SQLコマンドの実行
			PreparedStatement stmt = connection.prepareStatement(sql);
			// System.out.println(stmt);
			stmt.setString(1, question.getQuestionHeadline());
			stmt.setString(2, question.getQuestionText());
			stmt.setString(3, question.getChoice1());
			stmt.setString(4, question.getChoice2());
			stmt.setString(5, question.getChoice3());
			stmt.setInt(6, question.getCorrectAnswer());
			stmt.setInt(7, question.getQuestionId());
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

	public static int deleteQuestion(int questionId, Connection connection) {

		try {

			// SQLコマンド
			String sql = "delete from questions_information where question_id = ?";
			// SQLコマンドの実行
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, questionId);
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

	public static int createQuestion(Question question, Connection connection) {

		try {

			// SQLコマンド
			String sql = "insert into questions_information (question_headline,question_text,choice_1,choice_2,choice_3,correct_answer) values(?,?,?,?,?,?)";
			// SQLコマンドの実行
			PreparedStatement stmt = connection.prepareStatement(sql);
			// System.out.println(stmt);
			stmt.setString(1, question.getQuestionHeadline());
			stmt.setString(2, question.getQuestionText());
			stmt.setString(3, question.getChoice1());
			stmt.setString(4, question.getChoice2());
			stmt.setString(5, question.getChoice3());
			stmt.setInt(6, question.getCorrectAnswer());
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

	public static int maxNumQuestion(Connection connection) {

		try {
			String sql = "select * from questions_information";
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			int num = 0;
			while (rs.next()) {
				num = rs.getInt("question_id");
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
