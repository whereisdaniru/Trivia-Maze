package triviaMaze_tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import triviaMaze.GameManager;

class GameManager_tests {

	
	@Test
	void gameManagerTests_newEasyGame() 
	{
		GameManager testgm = new GameManager();
		testgm.newGame("easy");
		assertTrue(testgm != null);
	}
	
	@Test
	void gameManagerTests_newHardGame() 
	{
		GameManager testgm = new GameManager();
		testgm.newGame("hard");
		assertTrue(testgm != null);
	}

}
