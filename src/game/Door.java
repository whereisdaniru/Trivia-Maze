package game;

public class Door {
	private boolean isDoor;
	
	public Door(boolean isDoor) {
		this.setDoor(isDoor);
	}

	public boolean isDoor() {
		return isDoor;
	}

	public void setDoor(boolean isDoor) {
		this.isDoor = isDoor;
	}
}
