package game;

enum DoorStatus {
	Init,
	Passed,
	Locked
}

public class Door {
	
	private boolean isDoor, isEntrance, isExit;
	private DoorStatus status;
	private Question question;
	
	public Door(boolean isDoor, DoorStatus status, boolean isEntrance, boolean isExit, Question question) {
		this.setDoor(isDoor);
		this.setStatus(status);
		this.setEntrance(isEntrance);
		this.setExit(isExit);
		this.setQuestion(question);
	}
	
	public Door() {
		this.setDoor(false);
		this.setStatus(DoorStatus.Init);
		this.setEntrance(false);
		this.setExit(false);
		// should be a default
		this.setQuestion(null);
	}
	
	public void showQuestion(Question question) {
		// TODO
	}
	
	public void getAnswer() {
		// TODO
	}

	public boolean isDoor() {
		return isDoor;
	}

	public void setDoor(boolean isDoor) {
		this.isDoor = isDoor;
	}

	public boolean isEntrance() {
		return isEntrance;
	}

	public void setEntrance(boolean isEntrance) {
		this.isEntrance = isEntrance;
	}

	public boolean isExit() {
		return isExit;
	}

	public void setExit(boolean isExit) {
		this.isExit = isExit;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public DoorStatus getStatus() {
		return status;
	}

	public void setStatus(DoorStatus status) {
		this.status = status;
	}
}
