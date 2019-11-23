package triviaMaze;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.Rectangle;

public class QuestionWindow extends MouseAdapter{
	private GameManager gameManager;
	private Handler handler;
	public QuestionWindow(Handler handler, GameManager gameManager) {
		this.handler = handler;
		this.gameManager = gameManager;
	}
	public void mousePressed(MouseEvent e) {
		if(gameManager.getWindowState() == WindowState.QuestionWindow) {
			int xmouse = e.getX(); //get temporary mouse click position
			int ymouse = e.getY();
			// True button click handle
			if(mouseOver(xmouse, ymouse, new Rectangle(210, 116, 200, 64))) {
				playerMoveForward();
				gameManager.setWindowState(WindowState.GameWindow);
			}
			// False button click handle
			if(mouseOver(xmouse, ymouse, new Rectangle(210, 200, 200, 64))) {
				playerMoveBackward();
				gameManager.setWindowState(WindowState.GameWindow);
			}
		}
	}
	private void playerMoveForward() {
		for (GameObject gameObject : handler.gameObjects) {
			if(gameObject.getID() == ID.Player) {
				switch(gameManager.getDirection()) {
				case Down:
					gameObject.moveDown();
					break;
				case Up:
					gameObject.moveUp();
					break;
				case Right:
					gameObject.moveRight();
					break;
				case Left:
					gameObject.moveLeft();
					break;
				default:
					break;
				}
			}
		}
	}
	private void playerMoveBackward() {
		for (GameObject gameObject : handler.gameObjects) {
			if(gameObject.getID() == ID.Player) {
				switch(gameManager.getDirection()) {
				case Down:
					gameObject.moveUp();
					break;
				case Up:
					gameObject.moveDown();
					break;
				case Right:
					gameObject.moveLeft();
					break;
				case Left:
					gameObject.moveRight();
					break;
				default:
					break;
				}
			}
		}
	}
	// if mouse click on a rectangle, return true
	private boolean mouseOver(int xmouse, int ymouse, Rectangle rec) {
		if(xmouse > rec.x && xmouse < rec.x + rec.width) {
			if (ymouse > rec.y && ymouse < rec.y + rec.height) {
				return true;
			}
		}
		return false;
	}
	public void mouseReleased(MouseEvent e) {
		
	}
	public void tick() {}
	public void render(Graphics g) {
		if(gameManager.getWindowState() == WindowState.QuestionWindow) {
			Font bigFont = new Font("airal", 1,50);
			Font normalFont = new Font("airal", 1,40);
			g.setFont(bigFont);
			g.setColor(Color.WHITE);
			g.drawString("Question", 210, 50);
			
			g.setFont(normalFont);
			g.setColor(Color.white);
			g.drawRect(210, 116, 200, 64);
			g.drawString("True", 262, 160);
			
			g.setFont(normalFont);
			g.setColor(Color.white);
			g.drawRect(210, 200, 200, 64);
			g.drawString("False", 258, 250);
			
	//		g.setColor(Color.white);
	//		g.drawRect(210, 284, 200, 64);
		}
	}

}
