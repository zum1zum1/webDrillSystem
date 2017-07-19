package beans;

public class History {
	private int id = 0; // id
	private int questionId = 0; // 問題id
	private int userAnswer = 0; // ユーザーの解答
	private String answerDate = null;
	
	public History(int id, int questionId, int userAnswer, String answerDate) {
		super();
		this.id = id;
		this.questionId = questionId;
		this.userAnswer = userAnswer;
		this.answerDate = answerDate;
	}

	public String getAnswerDate() {
		return answerDate;
	}

	public void setAnswerDate(String answerDate) {
		this.answerDate = answerDate;
	}

	public History() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public int getUserAnswer() {
		return userAnswer;
	}

	public void setUserAnswer(int userAnswer) {
		this.userAnswer = userAnswer;
	}

}
