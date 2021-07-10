package entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Rectangle {
	private double x;
	private double y;
	private double width, height;
	private Color color;
	
				//x - posição na tela (eixo x), y - posição na tela (eixo y)
	public Rectangle(double x, double y, double width,double height, Color color) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.color = color;
	}
	
	
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}


	public double getY() {
		return y;
	}


	public void setY(double y) {
		this.y = y;
	}


	public void draw(Graphics2D g2) {
		g2.setColor(color);
		g2.fill(new Rectangle2D.Double(x, y, width, height));
	}
	
	public void move(Graphics2D g2, int y) {
		g2.setColor(color);
	}
}
