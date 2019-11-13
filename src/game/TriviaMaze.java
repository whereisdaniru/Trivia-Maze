package game;

import java.util.Scanner;

public class TriviaMaze {

	public static void main(String[] args) {
		boolean gameInProgress = true;
		Maze maze = new Maze(4,4,"Simple");
		Room[][] field = maze.getMaze();
		Player player = new Player("Player 1", 4, new Location(0,0));
		boolean game = game(gameInProgress, maze, player, field);
		
	}

	private static boolean game(boolean gameInProgress, Maze maze, Player player, Room[][] field) {
		Scanner kb = new Scanner(System.in);
		char choice;
		
		
		while(gameInProgress) {
			System.out.print("Which way would you like to move? w:up a:left s:down d:right  --press q to quit--");
			System.out.print("Choice --> ");
			choice = kb.next().charAt(0);
			
			switch (choice) {
				case 'w':
					if(canMove('w', field, player)) {
						
					}
				
				case 'a': // move left
					
				case 's': // move down
					
				case 'd': // move right
			}
		}
		
		return false;
	}

	private static boolean canMove(char c, Room[][] field, Player player) {
		int currRow = player.getLocation().getX();
		int currColumn = player.getLocation().getY();
		Room currRoom = field[currRow][currColumn];
		
		switch(c) {
			case 'w':
				if(currRoom.getNorth().isDoor()
						&& currRoom.getNorth().getStatus() != DoorStatus.Locked) {
					return false;
				}
				break;
		
			case 'a': 
				if(currRoom.getWest().isDoor()
						&& currRoom.getWest().getStatus() != DoorStatus.Locked) {
					return false;
				}
				break;
			
			case 's': 
				if(currRoom.getSouth().isDoor()
						&& currRoom.getSouth().getStatus() != DoorStatus.Locked) {
					return false;
				}
				break;
			
			case 'd':
				if(currRoom.getEast().isDoor()
						&& currRoom.getEast().getStatus() != DoorStatus.Locked) {
					return false;
				}
				break;
		}
		return true;
	}

}
