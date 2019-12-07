package triviaMaze_tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


import triviaMaze.GameManager;
import triviaMaze.ID;
import triviaMaze.Player;
import triviaMaze.Handler;

class Player_tests 
{
	@Test
	void Playertest_Player_exists() 
	{
		Player testPlayer = new Player(0, 0, ID.Player, 0, 0, 0, 0, null, null);
		assertTrue(testPlayer != null);
	}
	
	@Test
	void Playertest_Player_moveRight() 
	{
		GameManager gm = new GameManager();
		Handler hn = new Handler();
		Player testPlayer = new Player(208, 108, ID.Player, 208, 108, 4, 4, hn, gm);
		hn.addObject(testPlayer);
		testPlayer.moveRight();
		assertTrue(testPlayer.getX()==238);

	}
	
	@Test
	void Playertest_Player_moveLeft() 
	{
		GameManager gm = new GameManager();
		Handler hn = new Handler();
		Player testPlayer = new Player(238, 108, ID.Player, 208, 108, 4, 4, hn, gm);
		hn.addObject(testPlayer);
		testPlayer.moveLeft();
		assertTrue(testPlayer.getX()==208);
		

	}
	
	@Test
	void Playertest_Player_moveLeft_False() 
	{
		GameManager gm = new GameManager();
		Handler hn = new Handler();
		Player testPlayer = new Player(208, 108, ID.Player, 208, 108, 4, 4, hn, gm);
		hn.addObject(testPlayer);
		testPlayer.moveLeft();
		assertFalse(testPlayer.getX()==178);
		

	}
	
	@Test
	void Playertest_Player_moveUp() 
	{
		GameManager gm = new GameManager();
		Handler hn = new Handler();
		Player testPlayer = new Player(208, 138, ID.Player, 208, 108, 4, 4, hn, gm);
		hn.addObject(testPlayer);
		testPlayer.moveUp();
		assertTrue(testPlayer.getY()==108);
			
	}
	
	@Test
	void Playertest_Player_moveUp_False() 
	{
		GameManager gm = new GameManager();
		Handler hn = new Handler();
		Player testPlayer = new Player(208, 108, ID.Player, 208, 108, 4, 4, hn, gm);
		hn.addObject(testPlayer);
		testPlayer.moveUp();
		assertFalse(testPlayer.getY()==78);
			
	}
	
	@Test
	void Playertest_Player_moveDown() 
	{
		GameManager gm = new GameManager();
		Handler hn = new Handler();
		Player testPlayer = new Player(208, 108, ID.Player, 208, 108, 4, 4, hn, gm);
		hn.addObject(testPlayer);
		testPlayer.moveDown();
		assertTrue(testPlayer.getY()==138);
			
	}
}
