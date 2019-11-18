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
			int currRow = player.getLocation().getX();
			int currColumn = player.getLocation().getY();
			Room currRoom = field[currRow][currColumn];
			
			System.out.println("\n\nCurrent Row: " + currRow + "\nCurrent Column: " + currColumn + "\n\n");
			
			System.out.print("Which way would you like to move? w:up a:left s:down d:right  --press q to quit--");
			System.out.print("Choice --> ");
			choice = kb.next().charAt(0);
			
			switch (choice) {
				case 'w':
					if(canMove(choice, currRoom)) {
						player.getLocation().setLocation(currRow - 1, currColumn);
					}
					else {
						System.out.println("Not a valid move!");
					}
					break;
				
				case 'a': 
					if(canMove(choice, currRoom)) {
						player.getLocation().setLocation(currRow, currColumn - 1);
					}
					else {
						System.out.println("Not a valid move!");
					}
					break;
					
				case 's':
					if(canMove(choice, currRoom)) {
						player.getLocation().setLocation(currRow + 1, currColumn);
					}
					else {
						System.out.println("Not a valid move!");
					}
					break;
					
				case 'd':
					if(canMove(choice, currRoom)) {
						player.getLocation().setLocation(currRow, currColumn + 1);
					}
					else {
						System.out.println("Not a valid move!");
					}
					break;
					
				case 'q':
					System.out.println("Game ending....");
					gameInProgress = false;
					break;
			}
		}
		return false;
	}

	private static boolean canMove(char c, Room currRoom) {
		
		switch(c) {
			case 'w':
				if(currRoom.getNorth().isDoor() && currRoom.getNorth().isEntrance() == false
						&& currRoom.getNorth().getStatus() != DoorStatus.Locked) {
					return true;
				}
				break;
		
			case 'a': 
				if(currRoom.getWest().isDoor()
						&& currRoom.getWest().getStatus() != DoorStatus.Locked) {
					return true;
				}
				break;
			
			case 's': 
				if(currRoom.getSouth().isDoor() && currRoom.getSouth().isExit() == false
						&& currRoom.getSouth().getStatus() != DoorStatus.Locked) {
					return true;
				}
				break;
			
			case 'd':
				if(currRoom.getEast().isDoor()
						&& currRoom.getEast().getStatus() != DoorStatus.Locked) {
					return true;
				}
				break;
		}
		return false;
	}

}
