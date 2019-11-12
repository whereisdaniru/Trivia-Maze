package game;

public class Door {
	
	private boolean isDoor, isOpen, isEntrance, isExit;
	private Question question;
	
	public Door(boolean isDoor, boolean isOpen, boolean isEntrance, boolean isExit, Question question) {
		this.setDoor(isDoor);
		this.setOpen(isOpen);
		this.setEntrance(isEntrance);
		this.setExit(isExit);
		this.setQuestion(question);
	}
	
	public Door() {
		this.setDoor(false);
		this.setOpen(false);
		this.setEntrance(false);
		this.setExit(false);
		// should be a default
		this.setQuestion(null);
	}

	public boolean isDoor() {
		return isDoor;
	}

	public void setDoor(boolean isDoor) {
		this.isDoor = isDoor;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
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
}
