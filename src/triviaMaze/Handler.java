package triviaMaze;

import java.awt.Graphics;
import java.io.Serializable;
import java.util.LinkedList;

public class Handler implements Serializable{
	private static final long serialVersionUID = 1L;
	private LinkedList<GameObject> gameObjects = new LinkedList<GameObject>();
	public void tick() {
		for(int i = 0; i < gameObjects.size(); i++) {
			GameObject temp = gameObjects.get(i);
			temp.tick();
		}
	}
	public void render(Graphics g) {
		for(int i = 0; i < gameObjects.size(); i++) {
			GameObject temp = gameObjects.get(i);
			temp.render(g);
		}
		
	}
	public void addObject(GameObject object) {
		this.gameObjects.add(object);
	}
	public void removeObject(GameObject object) {
		this.gameObjects.remove(object);
	}
	public void removeAllObject() {
		for(int i = 0; i < gameObjects.size(); i++) {
			removeObject(gameObjects.get(i));
			i--;
		}
	}
	public LinkedList<GameObject> getGameObjects(){
		return this.gameObjects;
	}
}
