package services;

import java.awt.event.KeyEvent;

import constants.Constants;
import entities.Rectangle;

public class PlayerController {
	private Rectangle rect;
	private KeyIn keyListener;
	
	//Preciso saber qual retangulo irei controlar
	public PlayerController(Rectangle rect, KeyIn keyListener) {
		this.rect = rect;
		this.keyListener = keyListener;
	}
	
	
	
	public KeyIn getKeyListener() {
		return keyListener;
	}

	public void setKeyListener(KeyIn keyListener) {
		this.keyListener = keyListener;
	}

	public Rectangle getRect() {
		return rect;
	}

	public void setRect(Rectangle rect) {
		this.rect = rect;
	}
	
	public void update(double dt) {
		int key = keyListener.getKey();
		double distance;
		
		switch(key) {
		case KeyEvent.VK_DOWN:
			if(rect.getY() < Constants.SCREEN_HEIGHT - 111) {
				distance = (rect.getY() + (Constants.PLAYER_SPEED * dt));
				rect.setY(distance);
			}
			
		break;
		case KeyEvent.VK_UP:
			if(rect.getY() > Constants.HEIGHT_LIMIT) {
				distance = (rect.getY() - (Constants.PLAYER_SPEED * dt));
				rect.setY(distance);
			}
			
		break;
		}
	}
}
