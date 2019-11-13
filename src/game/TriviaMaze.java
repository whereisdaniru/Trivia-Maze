package game;

public class TriviaMaze {
	
	private static boolean gameInProgress = true;
	private static Maze maze = new Maze(4,4,"Simple");
	private static Player player = new Player("Player 1", 4, new Location(0,0));

	public static void main(String[] args) {
		boolean game = game();
	}

	private static boolean game() {
		
		while(gameInProgress) {
			
		}
		
		return false;
	}

}
