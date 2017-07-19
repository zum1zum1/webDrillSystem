package beans;

public class Question {
	private int questionId = 0;
	private String questionHeadline = null;
	private String questionText = null;
	private String choice1 = null;
	private String choice2 = null;
	private String choice3 = null;
	private int correctAnswer = 0;

	public Question(int questionId, String questionHeadline, String questionText, String choice1, String choice2,
			String choice3, int correctAnswer) {
		super();
		this.questionId = questionId;
		this.questionHeadline = questionHeadline;
		this.questionText = questionText;
		this.choice1 = choice1;
		this.choice2 = choice2;
		this.choice3 = choice3;
		this.correctAnswer = correctAnswer;
	}

	public Question() {

	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestionHeadline() {
		return questionHeadline;
	}

	public void setQuestionHeadline(String questionHeadline) {
		this.questionHeadline = questionHeadline;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public String getChoice1() {
		return choice1;
	}

	public void setChoice1(String choice1) {
		this.choice1 = choice1;
	}

	public String getChoice2() {
		return choice2;
	}

	public void setChoice2(String choice2) {
		this.choice2 = choice2;
	}

	public String getChoice3() {
		return choice3;
	}

	public void setChoice3(String choice3) {
		this.choice3 = choice3;
	}

	public int getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(int correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

}
