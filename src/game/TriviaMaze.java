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
		
		
		while(gameInProgress && canSolve(field, 0, 0)) {
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
	
/*
 * Uses backtracking to find a valid path through the Maze.	
 */

private static boolean canSolve(Room[][] field, int x, int y) {
	// Reached Exit, Maze is still solvable
	if(x == field.length - 1 && y == field[0].length - 1)
		return true;
	// If x and y aren't outside the bounds of the array, attempt to move.
	if(isSafe(field, x, y)) {
		// Move East
		if(canSolve(field, x + 1, y))
			return true;
		// Move South
		if(canSolve(field, x, y + 1))
			return true;
		// Backtrack
		return false;
	}
	// Returns false if no valid path
	return false;
	}

	private static boolean isSafe(Room[][] field, int x, int y) {
		return (x >= 0 && x < field.length && y >= 0 && y < field[0].length);
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
