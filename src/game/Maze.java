package game;

public class Maze {
	private Player player;
	private Room[][] maze;
	private int column, row;
	
	public Maze(Room[][] maze) {
		this.setMaze(maze);
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Room[][] getMaze() {
		return maze;
	}

	public void setMaze(Room[][] maze) {
		this.maze = maze;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}
}
