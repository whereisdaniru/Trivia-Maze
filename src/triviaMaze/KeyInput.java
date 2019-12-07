package triviaMaze;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	private Handler handler;
	private GameManager gameManager;
	public KeyInput(Handler handler, GameManager gameManager) {
		this.handler = handler;
		this.gameManager = gameManager;
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if(!gameManager.getPaused()) {
			for (GameObject gameObject : handler.getGameObjects()) {
				if(gameObject.getID() == ID.Player && gameManager.getWindowState() == WindowState.GameWindow) {
					//System.out.println(key);
					if(key == KeyEvent.VK_UP) { 
						gameObject.moveUp(); 
						gameManager.setDirection(Direction.Up);
					}
					if(key == KeyEvent.VK_DOWN) {
						gameObject.moveDown();
						gameManager.setDirection(Direction.Down);
					}
					if(key == KeyEvent.VK_RIGHT) {
						gameObject.moveRight();
						gameManager.setDirection(Direction.Right);
					}
					if(key == KeyEvent.VK_LEFT) {
						gameObject.moveLeft();
						gameManager.setDirection(Direction.Left);
					}
				}
			}
		}
		//paused game when press p 
		if(key == KeyEvent.VK_P) {
			if(gameManager.getWindowState() == WindowState.GameWindow) {
				gameManager.pauseGame();
			}
		}
		if(key == KeyEvent.VK_ESCAPE)
			System.exit(1);
		
	}
}
