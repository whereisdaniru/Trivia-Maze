package game;

public class Maze {
	private Player player;
	private Room[][] maze;
	private int column, row;
	private String type;
	
	public Maze(int row, int column, String type) {
		this.setRow(row);
		this.setColumn(column);
		this.setType(type);
		constructMaze();
	}

	private void constructMaze() {
		if(this.type.equals("Simple")) {
			this.maze = new SimpleMaze().buildMaze(this.row, this.column);
		}
		if(this.type.equals("Complex")) {
			this.maze = new ComplexMaze().buildMaze(this.row, this.column);
		}
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
