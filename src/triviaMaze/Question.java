package TrivialMaze;

public class Question {
	private int id;
	private String question;
	private String correctAns;
	private String wrongAns1;
	private String wrongAns2;
	private String wrongAns3;
	//private String hint;
	private TypeOfQuestion type;
	private int status;
	private QuestionHandler questionHandler;
	public Question() {
		questionHandler = QuestionHandler.getInstance();
		Question temp = questionHandler.getRandomQuestion();
		if (temp != null) {
			this.id = temp.getId();
			this.question = temp.getQuestion();
			this.correctAns = temp.getCorrectAns();
			this.wrongAns1 = temp.getWrongAns1();
			this.wrongAns2 = temp.getWrongAns2();
			this.wrongAns3 = temp.getWrongAns3();
			//this.hint = hint;
			this.type = temp.getType();
			this.status = temp.getStatus();
		}
	}
	public Question(int id, String question, String correctAns, String wrongAns1, String wrongAns2, String wrongAns3, TypeOfQuestion type, int status) {
		this.id = id;
		this.question = question;
		this.correctAns = correctAns;
		this.wrongAns1 = wrongAns1;
		this.wrongAns2 = wrongAns2;
		this.wrongAns3 = wrongAns3;
		//this.hint = hint;
		this.type = type;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public String getQuestion() {
		return question;
	}
	public String getCorrectAns() {
		return correctAns;
	}
	public String getWrongAns1() {
		return wrongAns1;
	}
	public String getWrongAns2() {
		return wrongAns2;
	}
	public String getWrongAns3() {
		return wrongAns3;
	}
	public TypeOfQuestion getType() {
		return type;
	}
	public int getStatus() {
		return this.status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
    public String toString() {
    	String result = "";
    	result += "QuestionID: " + id + ", Question: " + question + ", Correct Answer: " + correctAns +
    		 	", Wrong Answer 1: " + wrongAns1 + ", Wrong Answer 2: " + wrongAns2 + ", Wrong Answer 2: " + wrongAns3 +
    		 	", Type Of Question: " + type + ", Status: " + status;
    	return result;
    }
}
