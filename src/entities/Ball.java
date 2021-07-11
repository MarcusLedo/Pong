package entities;

import constants.Constants;

public class Ball {
	private Rectangle rect;
	private Rectangle player1, player2;
	private double vy = 40.0;
	private double vx = -150.0;
	
	
	public Ball(Rectangle rect, Rectangle player1, Rectangle player2) {
		this.rect = rect;
		this.player1 = player1;
		this.player2 = player2;
	}


	public Rectangle getRect() {
		return rect;
	}


	public void setRect(Rectangle rect) {
		this.rect = rect;
	}


	public Rectangle getPlayer1() {
		return player1;
	}


	public void setPlayer1(Rectangle player1) {
		this.player1 = player1;
	}


	public Rectangle getPlayer2() {
		return player2;
	}


	public void setPlayer2(Rectangle player2) {
		this.player2 = player2;
	}


	public double getVy() {
		return vy;
	}


	public void setVy(double vy) {
		this.vy = vy;
	}


	public double getVx() {
		return vx;
	}


	public void setVx(double vx) {
		this.vx = vx;
	}
	
	public void update(double dt) {
		
		if(vx < 0) { //Esquerda
			if(rect.x <= player1.x + player1.getWidth() && rect.y >= player1.y && 
				rect.x >= player1.x && rect.y <= player1.y + player1.getHeight()) {
				vx *= -1;
				vy *= -1;
			} else if(rect.x + rect.getWidth() < player1.x) 
				System.out.println("You lost");
			
		} else if(vx > 0) { //Direita
			if(rect.x + rect.getWidth() >= player2.x && rect.y >= player2.y && 
				rect.x <= player2.x + player2.getWidth() && rect.y <= player2.y + player2.getHeight()) {
					vx *= -1;
					vy *= -1;
			} else if(rect.x + rect.getWidth() > player2.x + player2.getWidth()) 
				System.out.println("Player 2 has lost a point");
		}
		
		if(vy > 0) {
			if(rect.y + rect.getHeight() > Constants.SCREEN_HEIGHT)
				vy *= -1;
		} else if(vy < 0) {
			if(rect.y < Constants.HEIGHT_LIMIT)
				vy *= -1;
		}
			
			
		
		rect.x += vx * dt;
		rect.y += vy * dt;
		
	}
	
}
