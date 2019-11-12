package game;

public class SimpleMaze implements MazeBuilder {
	
	@Override
	public Room[][] buildMaze(int row, int column) {
		Room[][] maze = new Room[row][column];
		
		for(int i = 0; i < maze.length; i++) {
			for(int j = 0; j < maze.length; j++) {
				maze[i][j] = setDoors(i, j, maze);
			}
		}
		return maze;
	}

	private Room setDoors(int i, int j, Room[][] maze) {
		Room current = new Room(new Door(), new Door(), new Door(), new Door());
		// Set entrance as the top left room, north door.
		if(i == 0 && j == 0) {
			current.getNorth().setDoor(true);
			current.getNorth().setEntrance(true);
			current.getNorth().setStatus(DoorStatus.Init);
			current.getWest().setDoor(false);
			current.getSouth().setDoor(true);
			current.getEast().setDoor(true);
		}
		// Set exit as bottom bottom right, south door.
		else if(i == maze.length - 1 && j == maze[0].length - 1) {
			current.getSouth().setDoor(true);
			current.getSouth().setExit(true);
			current.getSouth().setStatus(DoorStatus.Init);
			current.getWest().setDoor(true);
			current.getNorth().setDoor(true);
			current.getEast().setDoor(false);
		}
		// Set top right corner room.
		else if(i == 0 && j == maze[0].length - 1) {
			current.getNorth().setDoor(false);
			current.getWest().setDoor(true);
			current.getSouth().setDoor(true);
			current.getEast().setDoor(false);
		}
		// Set bottom left corner room.
		else if(i == maze.length - 1 && j == 0) {
			current.getNorth().setDoor(true);
			current.getWest().setDoor(false);
			current.getSouth().setDoor(false);
			current.getEast().setDoor(true);
		}
		// Sets other top row rooms
		else if(i == 0) {
			current.getNorth().setDoor(false);
			current.getWest().setDoor(true);
			current.getSouth().setDoor(true);
			current.getEast().setDoor(true);
		}
		// Sets bottom row
		else if(i == maze.length - 1) {
			current.getSouth().setDoor(false);
			current.getWest().setDoor(true);
			current.getNorth().setDoor(true);
			current.getEast().setDoor(true);
		}
		// Sets left side
		else if(j == 0) {
			current.getWest().setDoor(false);
			current.getNorth().setDoor(true);
			current.getEast().setDoor(true);
			current.getSouth().setDoor(true);
		}
		// Sets right side
		else if(j == maze[0].length - 1) {
			current.getEast().setDoor(false);
			current.getNorth().setDoor(true);
			current.getWest().setDoor(true);
			current.getSouth().setDoor(true);
		}
		// Sets interior rooms
		else {
			current.getNorth().setDoor(true);
			current.getEast().setDoor(true);
			current.getSouth().setDoor(true);
			current.getWest().setDoor(true);
		}
		
		return current;
	}

}
