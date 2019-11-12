package game;

public class Room {
	
private Door north, east, south, west;
	
	public Room(Door northDoor, Door eastDoor, Door southDoor, Door westDoor) {
		this.setNorth(northDoor);
		this.setEast(eastDoor);
		this.setSouth(southDoor);
		this.setWest(westDoor);
	}

	public Door getNorth() {
		return north;
	}

	public void setNorth(Door north) {
		this.north = north;
	}

	public Door getEast() {
		return east;
	}

	public void setEast(Door east) {
		this.east = east;
	}

	public Door getSouth() {
		return south;
	}

	public void setSouth(Door south) {
		this.south = south;
	}

	public Door getWest() {
		return west;
	}

	public void setWest(Door west) {
		this.west = west;
	}
}
