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
			// Question window handle
			if (gameManager.getSelectedObject().getDoorStatus() == DoorStatus.Init) {
				// True button click handle
				if(mouseOver(xmouse, ymouse, new Rectangle(210, 116, 200, 64))) {
					playerMoveForward();
					// change status of the door to passed
					gameManager.getSelectedObject().setDoorStatus(DoorStatus.Passed);
					gameManager.setWindowState(WindowState.GameWindow);
				}
				// False button click handle
				if(mouseOver(xmouse, ymouse, new Rectangle(210, 200, 200, 64))) {
					playerMoveBackward();
					gameManager.getSelectedObject().setDoorStatus(DoorStatus.Locked);
					gameManager.setWindowState(WindowState.GameWindow);
				}
				
			// Locked window handle
			} else if(gameManager.getSelectedObject().getDoorStatus() == DoorStatus.Locked) {
				// OK button click handle
				if(mouseOver(xmouse, ymouse, new Rectangle(210, 300, 200, 64))) {
					playerMoveBackward();
					gameManager.setWindowState(WindowState.GameWindow);
				}
				
			// Won window handle
			} else if (gameManager.getSelectedObject().getID() == ID.Target) {
				// OK button click handle
				if(mouseOver(xmouse, ymouse, new Rectangle(210, 300, 200, 64))) {
					//Call the new game function
					gameManager.clearObject();
					gameManager.newGame();
					//gameManager.setWindowState(WindowState.GameWindow);
				}
			}
		}
	}

	private void playerMoveForward() {
		for (GameObject gameObject : handler.gameObjects) {
			if(gameObject.getID() == ID.Player) {
				gameObject.moveForward();
			}
		}
	}
	private void playerMoveBackward() {
		for (GameObject gameObject : handler.gameObjects) {
			if(gameObject.getID() == ID.Player) {
				gameObject.moveBackward();
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
			if (gameManager.getSelectedObject().getDoorStatus() == DoorStatus.Init) {
				Question question = gameManager.getSelectedObject().getQuestion();
				if (question.getType() == TypeOfQuestion.TrueFalse) {
					
					String strQuestion = question.getQuestion();
					Font bigFont = new Font("airal", 1,30);
					Font normalFont = new Font("airal", 1,40);
					
					g.setFont(bigFont);
					g.setColor(Color.WHITE);
					g.drawString(strQuestion, 20, 50);
					
					g.setFont(normalFont);
					g.setColor(Color.white);
					g.drawRect(210, 116, 200, 64);
					g.drawString("True", 262, 160);
					
					g.setFont(normalFont);
					g.setColor(Color.white);
					g.drawRect(210, 200, 200, 64);
					g.drawString("False", 258, 250);
				} else if (question.getType() == TypeOfQuestion.MutipleChoice) {
					
					String strQuestion = question.getQuestion();
					Font bigFont = new Font("airal", 1,30);
					Font normalFont = new Font("airal", 1,40);
					
					g.setFont(bigFont);
					g.setColor(Color.WHITE);
					g.drawString(strQuestion, 20, 50);
					
					g.setFont(normalFont);
					g.setColor(Color.white);
					g.drawRect(210, 116, 200, 64);
					g.drawString("True", 262, 160);
					
					g.setFont(normalFont);
					g.setColor(Color.white);
					g.drawRect(210, 200, 200, 64);
					g.drawString("False", 258, 250);
				}else if (question.getType() == TypeOfQuestion.ShortAnswer) {
					
					String strQuestion = question.getQuestion();
					Font bigFont = new Font("airal", 1,30);
					Font normalFont = new Font("airal", 1,40);
					
					g.setFont(bigFont);
					g.setColor(Color.WHITE);
					g.drawString(strQuestion, 20, 50);
					
					g.setFont(normalFont);
					g.setColor(Color.white);
					g.drawRect(210, 116, 200, 64);
					g.drawString("True", 262, 160);
					
					g.setFont(normalFont);
					g.setColor(Color.white);
					g.drawRect(210, 200, 200, 64);
					g.drawString("False", 258, 250);
				}
				
		//		g.setColor(Color.white);
		//		g.drawRect(210, 284, 200, 64);
			} else if(gameManager.getSelectedObject().getDoorStatus() == DoorStatus.Locked) {
				Font smallFont = new Font("airal", 1,32);
				Font normalFont = new Font("airal", 1,40);
				g.setFont(smallFont);
				g.setColor(Color.WHITE);
				g.drawString("This door has been locked permanently", 10, 150);
				
				g.setFont(normalFont);
				g.setColor(Color.white);
				g.drawRect(210, 300, 200, 64);
				g.drawString("OK", 280, 350);
			} else if (gameManager.getSelectedObject().getID() == ID.Target) {
				Font smallFont = new Font("airal", 1,32);
				Font normalFont = new Font("airal", 1,40);
				g.setFont(smallFont);
				g.setColor(Color.WHITE);
				g.drawString("Congratulations !!! You won the game", 20, 150);
				
				g.setFont(smallFont);
				g.setColor(Color.WHITE);
				g.drawString("Click OK to play New Game", 100, 200);
				
				g.setFont(normalFont);
				g.setColor(Color.white);
				g.drawRect(210, 300, 200, 64);
				g.drawString("OK", 280, 350);
			}
		}
	}

}
