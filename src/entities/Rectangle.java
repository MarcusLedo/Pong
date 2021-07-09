package entities;

import java.awt.Color;
import java.awt.Graphics2D;

public class Rectangle {
	private int x;
	private int y;
	private int width, height;
	private Color color;
	
				//x - posição na tela (eixo x), y - posição na tela (eixo y)
	public Rectangle(int x, int y, int width, int height, Color color) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.color = color;
	}
	
	
	public void draw(Graphics2D g2) {
		g2.setColor(color);
		g2.fillRect(x, y, width, height);
	}
}
