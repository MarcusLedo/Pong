package services;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyIn implements KeyListener {
	
	private boolean keyPressed[] = new boolean[128];

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent keyEvent) {
		keyPressed[keyEvent.getKeyCode()] = true;
		
	}

	@Override
	public void keyReleased(KeyEvent keyEvent) {
		keyPressed[keyEvent.getKeyCode()] = false;
		
	}
	
	public boolean isKeyPressed(int keyCode) {
		return keyPressed[keyCode];
	}

}